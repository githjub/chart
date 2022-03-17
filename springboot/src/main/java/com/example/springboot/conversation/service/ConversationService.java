package com.example.springboot.conversation.service;

import java.util.List;
import java.util.Map;

public interface ConversationService {
    List<Map<String,Object>> selectConversation();
}
