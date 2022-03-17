package com.example.springboot.friend.mapper;

import com.example.springboot.bean.Friend;
import com.example.springboot.bean.FriendExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface FriendMapper {
    List<Map<String,Object>> selectFriend(String userId);

    int countByExample(FriendExample example);

    int deleteByExample(FriendExample example);

    int insert(Friend record);

    int insertSelective(Friend record);

    List<Friend> selectByExample(FriendExample example);

    int updateByExampleSelective(@Param("record") Friend record, @Param("example") FriendExample example);

    int updateByExample(@Param("record") Friend record, @Param("example") FriendExample example);
}