package com.example.springboot.group.service;

import com.example.springboot.group.mapper.GroupMapper;
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
@Service("groupService")
public class GroupServiceImpl implements GroupService {

    @Autowired
    @Qualifier("groupMapper")
    GroupMapper groupMapper;

    @Override
    public List<String> getGroupUserid(String groupId) {

        return groupMapper.getGroupUserid(groupId);
    }
}
