package com.example.springboot.单向通信;

import com.example.springboot.util.mymq.OnlieUserList;
import jdk.nashorn.internal.ir.CallNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.IOException;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: springboot
 * @description:
 * @author: llz
 * @date: 2021/9/13 9:18
 *
 * 服务端读取消息线程
 */
public class Read implements Runnable{

    private Socket socket;

    public Read(Socket socket) {
        this.socket = socket;
    }

    @Autowired
    @Qualifier("onlieUserList")
    OnlieUserList onlieUserList;

//    OnlieUserList onlieUserList=new OnlieUserList();

    @Override
    public void run() {
        try {
            System.out.println("读消息线程启动了.....");

                String receiveMsg = null;
                Scanner scanner = new Scanner(socket.getInputStream());
                scanner.useDelimiter("\n");//设置分隔符为回车
                while (scanner.hasNext()) {
                    System.out.println("获取客户端消息...");
                    receiveMsg = scanner.next();
                    System.out.println("得到的客户端消息: "+receiveMsg);
                    String[] strings = receiveMsg.split(" >< ");
                    String msg = strings[0];

                    //不能用map来存储在线用户(需要存在数据库里)

                    Map<String, Object> allOnlineUserList = onlieUserList.getOnlineUserList(strings[0]);
                    System.out.println("得到的发送者信息: "+allOnlineUserList.toString());
                    Socket socket1 = (Socket) OnlieUserList.onlineUserList.get(strings[0]);

                    //调用客户端的发送消息线程
                    Thread send = new Thread(new Send(socket1,msg));
                    send.start();
                }
                System.out.println("读消息结束了....");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
