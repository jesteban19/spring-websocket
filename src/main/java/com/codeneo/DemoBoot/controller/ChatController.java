package com.codeneo.DemoBoot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.codeneo.DemoBoot.model.ChatMessage;

@Controller
public class ChatController {
	
	private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);
	@MessageMapping("/chat.sendMessage")
	@SendTo("/channel/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		return chatMessage;
	}
	
	@MessageMapping("/chat.addUser")
	@SendTo("/channel/public")
	public ChatMessage addUser(@Payload ChatMessage chatMessage,
			SimpMessageHeaderAccessor headerAccessor) {
		logger.info(chatMessage.toString());
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}
}
