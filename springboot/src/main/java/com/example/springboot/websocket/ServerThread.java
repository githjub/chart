package com.example.springboot.websocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ServerThread implements Runnable{
    @Override
    public void run() {
        Server server = new Server(8888);
        server.start();
        System.out.println("服务器端启动，端口号为：" + server.getPort());
        BufferedReader sysin = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                String in = null;
                    in = sysin.readLine();
                server.broadcast(in);
                if (in.equals("exit")) {

                        server.stop(1000);

                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
