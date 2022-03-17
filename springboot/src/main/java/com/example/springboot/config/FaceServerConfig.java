package com.example.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @program: springboot
 * @description:
 * @author: llz
 * @date: 2021/7/28 10:21
 */
@Component
@PropertySource("classpath:faceserver.properties")
public class FaceServerConfig {
    @Value("${key}")
    private String key;
    @Value("${serverurl}")
    private String serverurl;
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;

    @Override
    public String toString() {
        return "FaceServerConfig{" +
                "key='" + key + '\'' +
                ", serverurl='" + serverurl + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getServerurl() {
        return serverurl;
    }

    public void setServerurl(String serverurl) {
        this.serverurl = serverurl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
