package kr.co.mseshop.back.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;

public class PushNotifictionHelper {
	public final static String AUTH_KEY_FCM = "AIzaSyCApwvAVuDEGUVemjJ641xoJV7rr02fNDg";
    public final static String API_URL_FCM = "https://fcm.googleapis.com/v1/projects/fcm-test-fc769/messages:send";

    public static String sendPushNotification()
            throws IOException {
        String result = "";
        URL url = new URL(API_URL_FCM);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "key=" + AUTH_KEY_FCM);
        conn.setRequestProperty("Content-Type", "application/json");

        JSONObject json = new JSONObject();

        json.put("to", "cBc4c723-gY:APA91bEe1yBre5h1pdKigxkaXk-sVEl_UhPvE0t3ClOKYulJ85HTz7groP4nF7XMdTlFyG539XxTl1m2-hX3ZEHwWD6Quvr0rXH-ARpKJDhKWtgKPaLolXzJKfR3aVog4pWXBr6WPsUy".trim());
        JSONObject info = new JSONObject();
        info.put("title", "notification title"); // Notification title
        info.put("body", "message body"); // Notification
                                                                // body
        json.put("notification", info);
        try {
            OutputStreamWriter wr = new OutputStreamWriter(
                    conn.getOutputStream());
            wr.write(json.toString());
            wr.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            result = "success";
        } catch (Exception e) {
            e.printStackTrace();
            result = "fail";
        }
        System.out.println("GCM Notification is sent successfully");

        return result;
    }
    public static void main(String args[]) {
    	try {
			new PushNotifictionHelper().sendPushNotification();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
