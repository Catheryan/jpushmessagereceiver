package com.mvc.jpushmessagereceiver;

import org.json.JSONObject;

import android.util.Log;

public class NotificationMessageHandler extends MessageHandler{

	public NotificationMessageHandler(String messageType) {
		super(messageType);
	}

	@Override
	public void handleMessage(JSONObject jobj) {
		Log.i("MessageHandler", getMessageType() + " registed");
	}

}
