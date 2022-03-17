package com.example.springboot.xiaozhitiao.controller;

import com.example.springboot.websocket.ChartServerEndpoint;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@RestController
@RequestMapping("/ChatAction")
public class ChatAction {
//    @Autowired
//    @Qualifier("mqUtil")
//    MqUtil mqUtil;

    //获取消息记录
    @RequestMapping("/getMessage")
    public List<HashMap<String,String>> getMessage(@RequestParam String userId, @RequestParam String sendUserId) throws IOException, InterruptedException {
        List<HashMap<String,String>> rsList = new ArrayList<>();
        if (ChartServerEndpoint.messageList!=null){
            ChartServerEndpoint.messageList.forEach(map->{
                if((map.get("sendUserId").equals(userId)&&map.get("fromUserId").equals(sendUserId))||(map.get("fromUserId").equals(userId)&&map.get("sendUserId").equals(sendUserId))){
                    rsList.add(map);
                }
            });
        }
        return rsList;
    }

}
