package com.example.springboot.group.controller;

import com.example.springboot.group.service.GroupService;
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
public class GroupAction {

    @Autowired
    @Qualifier("groupService")
    GroupService groupService;

     @RequestMapping("/getGroupUserid")
    public JsonResultBean getGroupUserid(HttpServletRequest request, @PathParam("groupId") String groupId){
        System.out.println("getGroupUserid方法被调用了...");

         JsonResultBean jsonResultBean = new JsonResultBean();
         List<String> getGroupUserid = groupService.getGroupUserid(groupId);
            jsonResultBean.setCode(200);
            jsonResultBean.setData(getGroupUserid);
            jsonResultBean.setMsg("查询成功!");
        return jsonResultBean;
    }
}
