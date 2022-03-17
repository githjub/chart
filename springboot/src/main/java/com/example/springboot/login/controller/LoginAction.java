package com.example.springboot.login.controller;

import com.example.springboot.login.service.LoginService;
import com.example.springboot.util.JWTUtil;
import com.example.springboot.util.JsonResultBean;
import com.example.springboot.util.SystemConstant;
import com.example.springboot.util.mapper.OnlineUserMapper;
import com.example.springboot.websocket.ChartServerEndpoint;
import com.example.springboot.websocket.ServerThread;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: springboot
 * @description:
 * @author: llz
 * @date: 2021/8/16 22:32
 */
@RequestMapping("/LoginAction")
@RestController
@Component
public class LoginAction {

    @Autowired
    @Qualifier("loginService")
    LoginService loginService;

    @RequestMapping("/a")
    public String a(HttpServletRequest request) {
        System.out.println("a方法被调用了...");
        return "a方法被调用....";
    }

     @RequestMapping("/login")
    public JsonResultBean login(HttpServletRequest request,@RequestParam String username,@RequestParam String password){
        System.out.println("login方法被调用了...");
        System.out.println("前端传来的username: "+username+",password: "+password);
        JsonResultBean jsonResultBean = new JsonResultBean();
        Map<String,Object> user = new HashMap<>();
        user.put("username",username);
        user.put("password",password);
        //先判断是否存在该账号id,减少查询量
        //TODO
         System.out.println("当前在线用户: "+ChartServerEndpoint.livingSessions.toString());
         if (ChartServerEndpoint.livingSessions.containsKey(username)) {
             //该用户以及登录不允许重复登录
             System.out.println("该用户以及登录不允许重复登录");
             jsonResultBean.setCode(2);
             jsonResultBean.setMsg("该用户以及登录不允许重复登录!");
             return jsonResultBean;
         }
        if (loginService.login(user)){
            //把token返回给客户端-->客户端保存至cookie-->客户端每次请求附带cookie参数

            //签发JWT
            String JWT = JWTUtil.createJWT("1", username, SystemConstant.JWT_TTL);
            System.out.println(JWT);

            HashMap<String, String> data = loginService.selectUserById(username);
            data.put("jwt",JWT);
            jsonResultBean.setCode(0);
            jsonResultBean.setData(data);
            jsonResultBean.setMsg("登陆成功!");

//            //解析JWT拿到用户信息    在拦截器中验证JWT
//            try {
//                Claims claims = JWTUtil.parseJWT(JWT);
//                System.out.println(claims);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }

            System.out.println("登陆成功!");

        }else {
            jsonResultBean.setCode(1);
            jsonResultBean.setMsg("登陆失败!账号或密码错误");
            System.out.println("登陆失败!账号或密码错误 ");
        }
        return jsonResultBean;
    }
}
