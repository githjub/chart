package com.example.springboot.bean;

public class Friend {
    private String userId;

    private String friendId;

    private String status;

    public Friend(String userId, String friendId, String status) {
        this.userId = userId;
        this.friendId = friendId;
        this.status = status;
    }

    public Friend() {
        super();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId == null ? null : friendId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}