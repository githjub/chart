package com.example.springboot.bean;

public class User {
    private String countId;

    private String pwd;

    private String nickname;

    private String name;

    public User(String countId, String pwd, String nickname, String name) {
        this.countId = countId;
        this.pwd = pwd;
        this.nickname = nickname;
        this.name = name;
    }

    public User() {
        super();
    }

    public String getCountId() {
        return countId;
    }

    public void setCountId(String countId) {
        this.countId = countId == null ? null : countId.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}