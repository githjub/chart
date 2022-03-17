package com.example.springboot.friend.controller;

import com.example.springboot.friend.service.FriendService;
import com.example.springboot.util.JsonResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

/**
 * @program: springboot
 * @description:
 * @author: llz
 * @date: 2021/8/16 22:32
 */
@RequestMapping("/friendAction")
@RestController
@Component
public class FriendAction {

    @Autowired
    @Qualifier("friendService")
    FriendService friendService;

     @RequestMapping("/selectFriend")
    public JsonResultBean selectFriend(HttpServletRequest request, @PathParam("userId") String userId){
        System.out.println("selectFriend方法被调用了...");

         JsonResultBean jsonResultBean = new JsonResultBean();
         List<Map<String,Object>> friendMap = friendService.selectFriend(userId);
            jsonResultBean.setCode(200);
            jsonResultBean.setData(friendMap);
            jsonResultBean.setMsg("查询成功!");
        return jsonResultBean;
    }
}
