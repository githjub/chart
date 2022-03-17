package com.example.springboot.websocket;

import com.example.springboot.util.sendgrouputil.SendGroupUtil;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ServerEndpoint
 * <p>
 * 使用springboot的唯一区别是要@Component声明下，而使用独立容器是由容器自己管理websocket的，但在springboot中连容器都是spring管理的。
 * <p>
 * 虽然@Component默认是单例模式的，但springboot还是会为每个websocket连接初始化一个bean，所以可以用一个静态set保存起来。
 *
 * @author sam
 * @since 2017/9/13
 */
@Component
@ServerEndpoint(value = "/websocket/{userName}") //WebSocket客户端建立连接的地址
public class ChartServerEndpoint {
    /**
     * 存活的session集合（使用线程安全的map保存）
     */
    public static Map<String, Session> livingSessions = new ConcurrentHashMap<>();

    //消息列表
    public static List<HashMap<String,String>> messageList = new ArrayList<>();

    //离线消息列表  监听用户连接发送消息
    public static List<HashMap<String,String>> unLivingMessageList = new ArrayList<>();

//    @Autowired
//    @Qualifier("friendService")
//    FriendService friendService;

    /**
     * 建立连接的回调方法
     *
     * @param session  与客户端的WebSocket连接会话
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("userName") String userName) {
        livingSessions.put(userName, session);
//        sendMessageToAll(userName + " 加入聊天室");
        System.out.println(userName+ " 连接成功");
        System.out.println("当前在线用户: "+ChartServerEndpoint.livingSessions.toString());
    }

    /**
     * 收到客户端消息的回调方法
     *
     * @param message 客户端传过来的消息(Json字符串:sendUserId,fromUserId,message)
     * @param session 对应的session
     */
    @OnMessage
    public void onMessage(String message, Session session, @PathParam("userName") String userName) {
        Gson gson = new Gson();
        HashMap messageMap = gson.fromJson(message, HashMap.class);
        System.out.println("服务端接收到的消息为: "+messageMap.toString());
        //消息记录暂时存储
        messageList.add(messageMap);
//        System.out.println(messageList.toString());

        //通过消息对象拿到消息发送人与接收人id还有消息
        String sendUserId = (String) messageMap.get("sendUserId");
        String fromUserId = (String) messageMap.get("fromUserid");

        //根据接收人id判断是群聊还是私聊(先去群聊找,没有则是私聊)
        if (sendUserId!=null){
            //私发消息
            sendMessgaPrivate(messageMap,message, sendUserId);
        }else {
            //群发消息
            sendMessageGroup(messageMap,message);
        }
    }

    /**
     * 发生错误的回调方法
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("连接发生错误");
        error.printStackTrace();
    }

    /**
     * 关闭连接的回调方法
     */
    @OnClose
    public void onClose(Session session, @PathParam("userName") String userName) {
        livingSessions.remove(userName);
//        sendMessageToAll(userName + " 退出聊天室");
        System.out.println(userName + "断开连接");
        System.out.println("当前在线用户: "+ChartServerEndpoint.livingSessions.toString());
    }

    /**
     * 单独发送消息
     *
     * @param sendUserId (发送对象的id)
     * @param messageMap
     */
    private void sendMessgaPrivate(HashMap<String,String> messageMap, String message, String sendUserId) {
        if (!livingSessions.containsKey(sendUserId)){//如果该用户没有上线需要把消息储存起来,然后等该用户上线再推送消息
            System.out.println("该用户不在线!");
            //TODO
            //存储消息至离线消息队列,等待用户上线推送(监听客户端连接时判断消息队列是否又该用户的滞留消息)
            unLivingMessageList.add(messageMap);
            return;
        }

        Session sendSession = livingSessions.get(sendUserId);
        //调用发送给指定人的方法
        sendMessage(sendSession,message);
    }

    /**
     * 发送消息(需要传入发送对象的session)
     *
     * @param session (发送对象的session)
     * @param message
     */
    public void sendMessage(Session session, String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 群发消息
     *
     * @param messageMap
     */
    public void sendMessageGroup(HashMap<String,String> messageMap, String message) {
        String GroupId = "";//群id
        List<String> groupUseridList = new SendGroupUtil().getGroupUserid(GroupId);
            for (String a:groupUseridList) {
                if (!livingSessions.containsKey(a)){
                    //a用户不在线 离线消息 群消息不同于私发消息
//                    unLivingMessageList.add(messageMap);
                    System.out.println("群成员"+a+"不在线!");
                    continue;
                }
                //群组用户在线
                System.out.println("群成员在线发送消息给"+a);
                sendMessage(livingSessions.get(a), message);
            }

//        //发送给所有在线用户
//        livingSessions.forEach((sessionId, session) -> {
//            sendMessage(session, message);
//        });
    }

}

