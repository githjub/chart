package com.example.springboot.bean;

public class MessageBean {
    private String message;
    private String sendUserId;
    private String fromUserId;

    public MessageBean(String message, String sendUserId, String fromUserId) {
        this.message = message;
        this.sendUserId = sendUserId;
        this.fromUserId = fromUserId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    @Override
    public String toString() {
        return "MessageBean{" +
                "message='" + message + '\'' +
                ", sendUserId='" + sendUserId + '\'' +
                ", fromUserId='" + fromUserId + '\'' +
                '}';
    }
}
