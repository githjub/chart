package com.example.springboot.util.mymq;

import com.example.springboot.util.JsonResultBean;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @program: springboot
 * @description:
 * @author: llz
 * @date: 2021/9/12 21:25
 *
 * 读消息线程
 */
public class ReadMessage implements Runnable{

    private Socket socket;
    private JsonResultBean jsonResultBean;
    public ReadMessage(Socket socket,JsonResultBean jsonResultBean) {
        this.socket = socket;
        this.jsonResultBean = jsonResultBean;
    }

    @Override
    public void run() {
        System.out.println("读消息线程启动了.....");
        try {

            Scanner scanner = new Scanner(socket.getInputStream());
            scanner.useDelimiter("\n");//设置分隔符为回车
            while (scanner.hasNext()) {

                jsonResultBean.setMsg(scanner.next());
                System.out.println("接收到消息,Msg: "+jsonResultBean.getMsg());

                System.out.println(jsonResultBean.toString());

                jsonResultBean.setCode(1);//用来保证消息不重复读
                System.out.println("接收到消息,code: "+jsonResultBean.getCode());

                System.out.println(jsonResultBean.toString());
            }

//            InputStream is = socket.getInputStream();
//            String receiveMsg = null;
//            byte[] buf = new byte[1024];
//            int len = -1;
//            while ((len = is.read(buf)) != -1) {
//                System.out.println("获取服务端消息...");
//                receiveMsg = new String(buf, 0, len);
//                System.out.println("得到的服务端消息: "+receiveMsg);
//                jsonResultBean.setMsg(receiveMsg);
//                //清空消息
//                receiveMsg = null;
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
