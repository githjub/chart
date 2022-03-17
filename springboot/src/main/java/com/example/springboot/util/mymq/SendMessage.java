package com.example.springboot.util.mymq;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @program: springboot
 * @description:
 * @author: llz
 * @date: 2021/9/12 21:25
 *
 * 发送消息线程
 */
public class SendMessage implements Runnable{

    private Socket socket;
    private String sendMessage;


    public SendMessage(Socket socket,String sendMessage) {
        this.socket = socket;
        this.sendMessage = sendMessage;
    }

    @Override
    public void run() {
        try {
            System.out.println("sendMessage线程被调用....");
//            //1.调用输出流的写的方法
//            OutputStream os = server.getOutputStream();
//            os.write(Integer.parseInt(sendMessage));
//            //刷新管道
//            os.flush();

            //获取客户端的输出流,向客户端输出内容
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println(sendMessage);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
