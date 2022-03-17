package com.example.springboot.friend.service;

import com.example.springboot.friend.mapper.FriendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @program: springboot
 * @description:
 * @author: llz
 * @date: 2021/9/30 9:18
 */
@Transactional
@Service("friendService")
public class FriendServiceImpl implements FriendService {

    @Autowired
    @Qualifier("friendMapper")
    FriendMapper friendMapper;

    @Override
    public List<Map<String,Object>> selectFriend(String userId) {

        return friendMapper.selectFriend(userId);
    }
}
