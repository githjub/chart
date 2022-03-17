package com.example.springboot.单向通信;

import com.example.springboot.util.mapper.OnlineUserMapper;
import com.example.springboot.util.mymq.OnlieUserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: springboot
 * @description:
 * @author: llz
 * @date: 2021/9/6 20:31
 */
public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 1.创建一个服务器对象，指定端口
        ServerSocket server = new ServerSocket(6666);
         System.out.println("xxxxxxxxx服务端已经启动,端口号为: 6666xxxxxxx");
        //2.创建线程池，从而可以处理多个客户端
        ExecutorService executorService = Executors.newFixedThreadPool(20);

//         //存储在线用户
//        Map<String,Object> userMap = new HashMap<String,Object>();
        int i = 0;

//        Socket client = null;

        while (true) {
//            try {
                // 2.监听端口，等待客户端的连接
                Socket client = server.accept();// 这句代码会发生阻塞，直到客户端连接成功才会继续执行。
                System.out.println("服务端收到客户端请求,客户端为: "+client);

                //存储在线用户
                OnlieUserList.onlineUserList.put(String.valueOf(client.getPort()),client);
                System.out.println("当前上线人数: "+OnlieUserList.onlineUserList.toString());
                System.out.println("client上线了"+client);

                //存储在线用户
//                userMap.put("User"+(i++),client);
//                System.out.println(userMap.get("User"+(i-1))+"上线了...");
//                System.out.println(userMap.toString());

                //启动接收消息线程
                executorService.execute(new Read(client));
    //            //调用接收消息线程
    //            Thread read = new Thread(new Read(client));
    //            read.start();
//            }catch (Exception e){
//                client.close();
//            }
        }

        // 4.关闭IO流和socket
//        is.close();
//        client.close();
//        server.close();

//        System.out.println("服务端代码运行结束....");
    }
}
