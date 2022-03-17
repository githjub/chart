package com.example.springboot.group.mapper;

import com.example.springboot.bean.Friend;
import com.example.springboot.bean.FriendExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GroupMapper {
    List<String> getGroupUserid(String groupId);
}