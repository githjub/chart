package com.example.springboot.单向通信;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @program: springboot
 * @description:
 * @author: llz
 * @date: 2021/9/6 20:31
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //1.构建一个客户端对象，需要指定服务端地址和服务端端口，向服务端第一次发送请求
        Socket client = new Socket("127.0.0.1", 6666);
        System.out.println("客户端是: " + client.getLocalPort());

        // 2.客户端发送消息给服务端
        // 2.1准备一个字符串
        String sendMsg = "你好,服务端, 我是客户端!";
        // 2.2得到一个输出流对象
        OutputStream os = client.getOutputStream();
        // 2.3调用输出流的写的方法
        os.write(sendMsg.getBytes());
        // 2.4刷新管道
        os.flush();

        // 3.关闭流和socket
        os.close();
        client.close();

        System.out.println("客户端代码运行结束...");
    }
}
