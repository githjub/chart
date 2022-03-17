package com.example.springboot.websocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.example.springboot.SpringbootApplication;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import org.springframework.boot.SpringApplication;

public class Server extends WebSocketServer{
    private static Server server;
    private static Map<String,Object> onlinUserMap = new ConcurrentHashMap<String, Object>();;//用于存储在线用户

    public Server(int port) {
        super(new InetSocketAddress(port));
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        server = new Server(8090);
        server.start();
        System.out.println("服务器端启动，端口号为：" + server.getPort());

        BufferedReader sysin = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String in = sysin.readLine();
            server.broadcast(in);
            if (in.equals("exit")) {
                server.stop(1000);
                break;
            }
        }

    }

    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        System.out.println("有人进来了");
        onlinUserMap.put("user",webSocket);
        String resourceDescriptor = clientHandshake.getResourceDescriptor();
    }

    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {

    }

    @Override
    public void onMessage(WebSocket webSocket, String message) {
        System.out.println("收到消息：" + message);
        server.broadcast(message);
//        webSocket.send("服务端收到了");
//        webSocket.setAttachment();
    }

    @Override
    public void onError(WebSocket webSocket, Exception e) {

    }

    @Override
    public void onStart() {

    }
}
