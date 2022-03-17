package com.example.springboot.bean;

public class OnlineUser {
    private String username;

    private String socket;

    private String onlineuserid;

    public OnlineUser(String username, String socket, String onlineuserid) {
        this.username = username;
        this.socket = socket;
        this.onlineuserid = onlineuserid;
    }

    public OnlineUser() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket == null ? null : socket.trim();
    }

    public String getOnlineuserid() {
        return onlineuserid;
    }

    public void setOnlineuserid(String onlineuserid) {
        this.onlineuserid = onlineuserid == null ? null : onlineuserid.trim();
    }
}