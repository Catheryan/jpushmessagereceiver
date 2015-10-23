package com.mvc.jpushmessagereceiver;

public interface IMessageHandlerRegister {
	void registeMessageHandler(MessageHandler messageType);
	void unRegisteMessageHandler(String messageType);
}
