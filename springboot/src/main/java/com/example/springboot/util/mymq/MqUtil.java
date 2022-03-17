package com.example.springboot.util.mymq;

import com.example.springboot.bean.OnlineUser;
import com.example.springboot.util.JsonResultBean;
import com.example.springboot.util.mapper.OnlineUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.Socket;
import java.util.Map;

/**
 * @program: springboot
 * @description:
 * @author: llz
 * @date: 2021/12/7 10:49
 * 创建连接
 * 接收消息
 * 发送消息
 * 关闭连接
 */
@Transactional
@Service("mqUtil")
public class MqUtil {

//    private Thread read;
    public Socket client;

    @Autowired
    @Qualifier("onlieUserList")
    OnlieUserList onlieUserList;

    //获取Socket连接
    public void getConnection(String userId) throws IOException {
        //创建客户端
        client = new Socket("127.0.0.1", 6666);//服务端地址与IP,应该可以根据需求修改
        System.out.println(client);
        System.out.println("客户端的端口号为: " + client.getLocalPort());

        //存储在线用户
        OnlieUserList.onlineUserList.put(userId, client);
        System.out.println(userId + "client上线了" + client);
        System.out.println("当前上线人数: " + OnlieUserList.onlineUserList.toString());
        OnlineUser onlineUser = new OnlineUser();
        onlineUser.setUsername(userId);
        onlineUser.setSocket(String.valueOf(client.getLocalPort()));
        onlieUserList.addOnlineUserList(onlineUser);
        System.out.println("onlineUserList: "+onlieUserList.getOnlineUserList(userId).toString());

        //调用读消息线程
        JsonResultBean jsonResultBean = null;
        Thread read = new Thread(new ReadMessage(client, jsonResultBean));
        read.start();
    }

    //关闭连接
    public void coseConnecton(String userId) throws IOException {
        Socket client = (Socket) OnlieUserList.onlineUserList.get(userId);//通过存储的用户list拿到客户端的socket
        OnlieUserList.onlineUserList.remove(userId);
        System.out.println("client下线了"+client);
        //关闭客户端
        client.close();
        System.out.println("读消息线程结束.....");
        //关闭读消息线程
    }

    //一对一发消息
    public void sendMsgSingle(String fromUserId,String toUserId,String sendMessage) throws IOException, InterruptedException {
        System.out.println("发消息对象client "+client);
        Thread send = new Thread(new SendMessage(client, sendMessage));
        send.start();

        send.join();//等待发消息线程结束
        System.out.println("发消息线程结束.....");
    }
}
