package com.example.springboot.conversation.service;

import com.example.springboot.conversation.mapper.ConversationMapper;
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
@Service("conversationService")
public class ConversationServiceImpl implements ConversationService {

    @Autowired
    @Qualifier("conversationMapper")
    ConversationMapper conversationMapper;

    @Override
    public List<Map<String,Object>> selectConversation() {

        return conversationMapper.selectConversation();
    }
}
