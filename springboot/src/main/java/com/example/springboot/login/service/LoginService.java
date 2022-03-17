package com.example.springboot.login.service;

import java.util.HashMap;
import java.util.Map;

public interface LoginService {
    int register(Map<String,Object> user);

    boolean login(Map<String,Object> user);

    HashMap<String,String> selectUserById(String countId);
}
