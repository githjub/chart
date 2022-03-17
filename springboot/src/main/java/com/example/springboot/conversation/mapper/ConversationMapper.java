package com.example.springboot.conversation.mapper;

import com.example.springboot.bean.Conversation;
import com.example.springboot.bean.ConversationExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ConversationMapper {
    List<Map<String,Object>> selectConversation();

    int countByExample(ConversationExample example);

    int deleteByExample(ConversationExample example);

    int insert(Conversation record);

    int insertSelective(Conversation record);

    List<Conversation> selectByExample(ConversationExample example);

    int updateByExampleSelective(@Param("record") Conversation record, @Param("example") ConversationExample example);

    int updateByExample(@Param("record") Conversation record, @Param("example") ConversationExample example);
}