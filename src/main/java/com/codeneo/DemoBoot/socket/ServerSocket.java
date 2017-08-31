package com.codeneo.DemoBoot.socket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ServerSocket extends TextWebSocketHandler {

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionClosed(session, status);
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		session.sendMessage(new TextMessage("Estas conectado al servidor"));
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("Message Receive:" + message.getPayload());
	}

}
