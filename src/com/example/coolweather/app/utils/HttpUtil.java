package com.example.coolweather.app.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.R.string;

public class HttpUtil {
	public static void sendHttpRequest(final String address, final HttpCallbackListener listener){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				HttpURLConnection connection = null;
				try {
					URL url = new URL(address);
					connection = (HttpURLConnection) url.openConnection();
					connection.setRequestMethod("GET");
					connection.setReadTimeout(2000);
					connection.setReadTimeout(2000);
					InputStream in = connection.getInputStream();
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
					StringBuilder response = new StringBuilder();
					String line;
					while((line = bufferedReader.readLine()) != null){
						response.append(line);
					}
					if(listener != null){
						listener.onFinish(response.toString());
					}
				} catch (Exception e) {
					if(listener != null){
						listener.onError(e);
					}
				} finally{
					if(connection != null){
						connection.disconnect();
					}
				}
				
			}
		}).start();
	}
}
