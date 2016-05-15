package com.example.coolweather.app.utils;

public interface HttpCallbackListener {
	void onFinish(String resonse);
	
	void onError(Exception e);
}
