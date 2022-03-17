package com.example.springboot;

import com.example.springboot.websocket.Server;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * springBoot项目运行的入口方法
 * 纳入spring容器管理的类必需放到 加了@SpringBootApplication注解的类的子包中
 * */
@SpringBootApplication
@MapperScan("com.example.springboot.**.mapper")  /*指定Mybatis映射接口的包名*/
public class SpringbootApplication {
//public class SpringbootApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    //修改启动类
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
////        System.out.println("修改的启动类..............***********");
//
//        //main方法执行的application启动类
//        return builder.sources(SpringbootApplication.class);
//    }

}
