package com.example.springboot.util.mymq;

import com.example.springboot.bean.OnlineUser;
import com.example.springboot.login.service.LoginService;
import com.example.springboot.util.mapper.OnlineUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: springboot
 * @description:
 * @author: llz
 * @date: 2021/10/8 10:01
 *  存储在线用户
 */
@Transactional
@Service("onlieUserList")
public class OnlieUserList {
    public static Map<String,Object> onlineUserList = new HashMap<>();

    @Autowired
    @Qualifier("onlineUserMapper")
    OnlineUserMapper onlineUserMapper;

    public int addOnlineUserList(OnlineUser onlieUser) {
        return onlineUserMapper.insert(onlieUser);
    }

    public Map<String, Object> getOnlineUserList(String username) {
        return onlineUserMapper.selectOnlineUserList(username);
    }

    public Map<String, Object> getAllOnlineUserList() {
        return onlineUserMapper.selectAllOnlineUserList();
    }
}
