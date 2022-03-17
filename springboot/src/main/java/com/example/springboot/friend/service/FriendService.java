package com.example.springboot.friend.service;

import java.util.List;
import java.util.Map;

public interface FriendService {
    List<Map<String,Object>> selectFriend(String userId);
}
