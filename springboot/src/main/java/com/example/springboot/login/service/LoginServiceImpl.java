package com.example.springboot.login.service;

import com.example.springboot.bean.User;
import com.example.springboot.bean.UserExample;
import com.example.springboot.login.mapper.UserMapper;
import com.example.springboot.util.mapper.OnlineUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: springboot
 * @description:
 * @author: llz
 * @date: 2021/9/30 9:18
 */
@Transactional
@Service("loginService")
public class LoginServiceImpl implements LoginService{

    @Autowired
    @Qualifier("userMapper")
    UserMapper userMapper;

    @Override
    public int register(Map<String, Object> user) {
        return 0;
    }

    @Override
    public boolean login(Map<String,Object> user) {

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andCountIdEqualTo((String) user.get("username"));
        criteria.andPwdEqualTo((String) user.get("password"));
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size()==1) {
            return true;
        }
        return false;

    }

    @Override
    public HashMap<String, String> selectUserById(String countId) {
        return userMapper.selectUserById(countId);
    }
}
