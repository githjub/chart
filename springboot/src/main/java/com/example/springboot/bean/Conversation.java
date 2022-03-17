package com.example.springboot.bean;

import java.util.Date;

public class Conversation {
    private String nickName;

    private String countId;

    private String latestMessage;

    private Date latestTime;

    private String headimg;

    public Conversation(String nickName, String countId, String latestMessage, Date latestTime, String headimg) {
        this.nickName = nickName;
        this.countId = countId;
        this.latestMessage = latestMessage;
        this.latestTime = latestTime;
        this.headimg = headimg;
    }

    public Conversation() {
        super();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getCountId() {
        return countId;
    }

    public void setCountId(String countId) {
        this.countId = countId == null ? null : countId.trim();
    }

    public String getLatestMessage() {
        return latestMessage;
    }

    public void setLatestMessage(String latestMessage) {
        this.latestMessage = latestMessage == null ? null : latestMessage.trim();
    }

    public Date getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(Date latestTime) {
        this.latestTime = latestTime;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg == null ? null : headimg.trim();
    }
}