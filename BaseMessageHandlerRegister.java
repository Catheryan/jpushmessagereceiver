package com.mvc.jpushmessagereceiver;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

public class BaseMessageHandlerRegister implements IMessageHandlerRegister{
	private List<MessageHandler> messageTypes = new ArrayList<MessageHandler>();

	public List<MessageHandler> getMessageTypes() {
		return messageTypes;
	}
	
	@Override
	public void registeMessageHandler(MessageHandler messageType) {
		messageTypes.add(messageType);
	}

	@Override
	public void unRegisteMessageHandler(String messageType) {
		final MessageHandler handler = getMessageHandler(messageType);
		messageTypes.remove(handler);
		Log.i("MessageHandler", handler.getMessageType() + " removed");
	}
	
	public void addMessageHandler(MessageHandler messageType) {
		registeMessageHandler(messageType);
	}
	
	public void removeMessageType(String messageType) {
		unRegisteMessageHandler(messageType);
	}
	
	public MessageHandler getMessageHandler(String messageType) {
		final int N = messageTypes.size();
		for (int i = 0; i < N; i++) {
			final MessageHandler handler = getMessageHandler(i);
			if (handler.getMessageType().equals(messageType)) {
				return handler;
			}
		}
		return null;
	}
	
	public MessageHandler getMessageHandler(int index) {
		return messageTypes.get(index);
	}

}
