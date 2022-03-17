package com.example.springboot.util.sendgrouputil;

import com.example.springboot.group.mapper.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

public class SendGroupUtil {
    static List<String> list ;

    @Autowired
    @Qualifier("groupMapper")
    GroupMapper groupMapper;

    public List<String> getGroupUserid(String groupId) {
        list = groupMapper.getGroupUserid(groupId);
        return list;
    }
}
