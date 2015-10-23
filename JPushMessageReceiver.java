package com.mvc.jpushmessagereceiver;

import org.json.JSONObject;

/**
 * 此类程序应用于推送系统中。
 * @author haier
 *
 */
public class JPushMessageReceiver extends BaseMessageHandlerRegister{
	private static JPushMessageReceiver receiver;
	
	private JPushMessageReceiver(){}
	
	public static JPushMessageReceiver getReceiver() {
		if (receiver == null) {
			receiver = new JPushMessageReceiver();
		}
		return receiver;
	}
	
	public void dispatchMessage(JSONObject jobj) {
		final int N = getMessageTypes().size();
		for (int i = 0; i < N; i++) {
			final MessageHandler handler = getMessageHandler(i);
			final String messageType = handler.getMessageType();
			if (jobj.has(messageType)) {
				if (handler != null) {
					handler.handleMessage(jobj);
				}
			}
		}
	}
}
