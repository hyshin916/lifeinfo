package kr.co.mseshop.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;

public class FCMTest {

	
	public void start1() throws FirebaseMessagingException {
		String registrationToken = "dfJB6hoG8NU:APA91bFMdY6MaVzEIK8NvdgyehJyAIgrGt6KkSaoQIJROknSwUOlXEDP4Qq1r7H5IsTKFo-Q85qo-DmEpXN0Dfhq4T6U3OkZvPbX3-jaVe9ML4Q2o1v0YB5tzYiO8XMZzq5KJlp6mPUV";

		// See documentation on defining a message payload.
		Message message = Message.builder()
		    .putData("score", "850")
		    .putData("time", "2:45")
		    .setToken(registrationToken)
		    .build();

		// Send a message to the device corresponding to the provided
		// registration token.
		String response = FirebaseMessaging.getInstance().send(message);
		// Response is a message ID string.
		System.out.println("Successfully sent message: " + response);
	}
	public void start() {
		String urlStr = "https://fcm.googleapis.com/fcm/send";
		String authorization = "key=AAAAA4Axasc:APA91bG-mtwvbLB_9SrG1OzYfCCQEBkiyMj5BHJC1HP2rBus-1mj2Hf4d2sYw88IoHjfJMKaKbPE6Dc9FDeScZRB0R_55wa5c3y0kYn9jnRnn0UTBKPvmQikhpHPbDwVJNdJ2t37Z-rJ";

		String token = "c992UTHgaL4:APA91bGoCVR-3luP0nSqhNUXPaBWp31a_jfVWO0jDPGbG81Qx7or2xXhzwW9C_bIZFit9x1sh0BXs7fvCX_NTbJtZb9SJAItOHU5On_b_k48-l-vKbE4-76EH0oBWJceGdsb0eXomY4C";
		String data = "\"data\": {\r\n" + "  \"en\": \"abc\",\r\n" + "  \"ko\": \"가나다\"\r\n" + " }";
		String notification = "\"notification\" : {\r\n"
		        + "  \"body\" : \"This is an FCM notification message!\",\r\n"
		        + "  \"title\" : \"FCM Message\"\r\n" + " }";

		URL url = null;
		HttpURLConnection connection = null;
		BufferedOutputStream bos = null;
		BufferedReader reader = null;

		try {
		    url = new URL(urlStr);
		    connection = (HttpsURLConnection) (urlStr.startsWith("https://") ? (HttpsURLConnection) url.openConnection()
		            : (HttpsURLConnection) url.openConnection());
		    connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
		    connection.setRequestProperty("cache-control", "no-cache");
		    connection.setRequestProperty("Authorization", authorization);

		    connection.setDoOutput(true);
		    connection.setDoInput(true);

		    connection.connect();

		    bos = new BufferedOutputStream(connection.getOutputStream());

		    String message = "{\"to\" : \"" + token + "\"," + data + "," + notification + "}";
		    bos.write(message.getBytes("UTF-8"));

		    bos.flush();
		    bos.close();

		    int responseCode = connection.getResponseCode();
		    String responseMessage = connection.getResponseMessage();
		    StringBuffer buffer = null;
		    if (responseCode == HttpURLConnection.HTTP_OK) {

		        buffer = new StringBuffer();
		        reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
		        String temp = null;
		        while ((temp = reader.readLine()) != null) {
		            buffer.append(temp);
		        }
		        reader.close();
		    }
		    connection.disconnect();
		    System.out.println(String.format("Response : %d, %s", responseCode, responseMessage));
		    System.out.println("Response DATA : ");
		    System.out.println(buffer == null ? "NULL " : buffer.toString());
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	public static void main(String args[]) throws FirebaseMessagingException {
		new FCMTest().start();
	}
}
