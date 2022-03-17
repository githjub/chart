package com.example.springboot.conversation.controller;

import com.example.springboot.conversation.service.ConversationService;
import com.example.springboot.util.JWTUtil;
import com.example.springboot.util.JsonResultBean;
import com.example.springboot.util.SystemConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: springboot
 * @description:
 * @author: llz
 * @date: 2021/8/16 22:32
 */
@RequestMapping("/conversationAction")
@RestController
@Component
public class ConversationAction {

    @Autowired
    @Qualifier("conversationService")
    ConversationService conversationService;

     @RequestMapping("/selectConversation")
    public JsonResultBean selectConversation(HttpServletRequest request){
        System.out.println("lselectConversation方法被调用了...");

         JsonResultBean jsonResultBean = new JsonResultBean();
         List<Map<String,Object>> conversationMap = conversationService.selectConversation();
            jsonResultBean.setCode(200);
            jsonResultBean.setData(conversationMap);
            jsonResultBean.setMsg("查询成功!");
        return jsonResultBean;
    }
}
