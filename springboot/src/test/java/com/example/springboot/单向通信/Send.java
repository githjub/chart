package com.example.springboot.单向通信;

import com.example.springboot.util.JsonResultBean;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @program: springboot
 * @description:
 * @author: llz
 * @date: 2021/9/13 9:18
 *
 * 服务端发送消息线程
 */
public class Send implements Runnable{

    private Socket socket;
    private String sendMessage;

    public Send(Socket socket,String sendMessage) {
        this.socket = socket;
        this.sendMessage = sendMessage;
    }

    @Override
    public void run() {

        try {
            System.out.println("发送消息线程启动....");
//            Thread.sleep(100);//线程休眠
            System.out.println("发送消息内容为: "+sendMessage);
                //获取客户端的输出流,向客户端输出内容
            System.out.println("发送消息目标为: "+socket);
                PrintStream ps = new PrintStream(socket.getOutputStream());
                ps.println(sendMessage);
            System.out.println("发送消息线程结束....");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
