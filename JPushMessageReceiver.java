package com.mvc.jpushmessagereceiver;

import org.json.JSONObject;

/**
 * �������Ӧ��������ϵͳ�С�
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
