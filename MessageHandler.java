package com.mvc.jpushmessagereceiver;

import org.json.JSONObject;

public abstract class MessageHandler {
	private String messageType;
	
	public MessageHandler(String messageType) {
		this.messageType = messageType;
	}
	
	public String getMessageType() {
		return messageType;
	}
	
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	
	public void registe(IMessageHandlerRegister register) {
		register.registeMessageHandler(this);
	}
	
	public abstract void handleMessage(JSONObject jobj);
}
