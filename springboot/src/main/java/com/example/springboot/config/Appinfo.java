package com.example.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: springboot
 * @description:
 * @author: llz
 * @date: 2021/7/28 10:05
 */
@Component
@ConfigurationProperties(prefix = "app")
public class Appinfo {
    private String appley;

    private String url;

    @Override
    public String toString() {
        return "Appinfo{" +
                "appley='" + appley + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getAppley() {
        return appley;
    }

    public void setAppley(String appley) {
        this.appley = appley;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
