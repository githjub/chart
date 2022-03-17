package com.example.springboot.xiaozhitiao.controller;

import com.example.springboot.util.JsonResultBean;
import com.example.springboot.util.mapper.OnlineUserMapper;
import com.example.springboot.util.mymq.OnlieUserList;
import com.example.springboot.util.mymq.SendMessage;
import com.example.springboot.util.mymq.MqUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.Socket;

/**
 * @program: springboot
 * @description:
 * @author: llz
 * @date: 2021/9/12 15:15
 */
@Component
@RestController
@RequestMapping("/ChartAction")
public class ChartAction {

//    private Socket client;
    private Thread read;
    private Boolean flag = true;
    JsonResultBean jsonResultBean = new JsonResultBean();
    private JsonResultBean jsonResultBean1 = new JsonResultBean();

//    MqUtil mqUtil= new MqUtil();

    @Autowired
    @Qualifier("mqUtil")
    MqUtil mqUtil;

    //客户端发消息给服务端
    @RequestMapping("/sendMessage")
    public void sendMessage(@RequestParam String message,@RequestParam String userId,@RequestParam String sendUserId) throws IOException, InterruptedException {

        System.out.println("ChartAction/sendMessage被调用了...");

        String sendMessage = "";

        //通过存储的用户list拿到客户端的socket
        Socket client = (Socket)OnlieUserList.onlineUserList.get(userId);
        sendMessage = message+" >< "+client.getLocalPort();

        //调用发消息方法
        mqUtil.sendMsgSingle(userId,sendUserId,message);

        //调用发送消息线程
//        Thread send = new Thread(new SendMessage(client,sendMessage));
//        send.start();
//
//        send.join();//等待发消息线程结束
//        System.out.println("发消息线程结束.....");
    }

    //客户端读来自服务端的消息(程序初始化时开启读消息线程)
    @RequestMapping("/readMessage")
    public JsonResultBean readMessage() throws InterruptedException {
        System.out.println("ChartAction/readMessage被调用了...");

        //需要在新消息来后第一次返回jsonResultBean之后将jsonResultBean设为null
        if (jsonResultBean.getCode() == 1){//已经有消息
            jsonResultBean.setCode(2);//只有code为1才返回消息给前端
            System.out.println("code为1,已有消息将code设为2: "+jsonResultBean.getCode());
            return jsonResultBean;
        }else {
            System.out.println("返回空消息");
            return jsonResultBean1;
        }

    }

    //开启Socket连接
    @RequestMapping("/openSocket")
    public void openSocket(@RequestParam String userId) throws IOException {
        System.out.println("userId: "+userId);
        System.out.println("创建客户端..");

        mqUtil.getConnection(userId);

    }

//    private void getConnection(String userId) throws IOException {
//        //创建客户端
//        Socket client = new Socket("127.0.0.1",6666);//客户端地址与IP,应该可以根据需求修改
//        System.out.println(client);
//        System.out.println("客户端的端口号为: "+client.getLocalPort());
//
//        //存储在线用户
//        OnlineUser onlineUser = new OnlineUser();
//        OnlieUserList.onlineUserList.put(userId,client);
//        System.out.println(userId+"client上线了"+client);
//        System.out.println("当前上线人数: "+OnlieUserList.onlineUserList.toString());
//
//        //调用读消息线程
//        read = new Thread(new ReadMessage(client,jsonResultBean));
//        read.start();
//    }

    //关闭Socket连接
    @RequestMapping("/closeSocket")
    public void closeSocket(@RequestParam String userId) throws IOException {
        System.out.println("关闭客户端..");

        mqUtil.coseConnecton(userId);
    }

//    private void coseConnecton(String userId) throws IOException {
//        Socket client = (Socket) OnlieUserList.onlineUserList.get(userId);//通过存储的用户list拿到客户端的socket
//        OnlieUserList.onlineUserList.remove(userId);
//        System.out.println("client下线了"+client);
//        //关闭客户端
//        client.close();
//        System.out.println("读消息线程结束.....");
//        //关闭读消息线程
//    }
}
