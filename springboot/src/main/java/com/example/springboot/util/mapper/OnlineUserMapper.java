package com.example.springboot.util.mapper;

import com.example.springboot.bean.OnlineUser;
import com.example.springboot.bean.OnlineUserExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface OnlineUserMapper {
    int countByExample(OnlineUserExample example);

    int deleteByExample(OnlineUserExample example);

    int insert(OnlineUser record);

    int insertSelective(OnlineUser record);

    List<OnlineUser> selectByExample(OnlineUserExample example);

    int updateByExampleSelective(@Param("record") OnlineUser record, @Param("example") OnlineUserExample example);

    int updateByExample(@Param("record") OnlineUser record, @Param("example") OnlineUserExample example);

    Map<String, Object> selectOnlineUserList(String username);

    Map<String, Object> selectAllOnlineUserList();
}