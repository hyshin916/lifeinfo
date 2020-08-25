package kr.co.mseshop.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.AndroidNotification;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;

public class FcmUtil {
	
	
	private static String getAccessToken() throws IOException {
		  GoogleCredential googleCredential = GoogleCredential
		      .fromStream(new FileInputStream("C:\\Users\\사용자\\git\\lifeinfo\\lifeinfo\\src\\main\\webapp\\resources\\google\\json\\fcm-test-fc769-firebase-adminsdk-7m7y6-8101d9bc19.json"))
		      .createScoped(Arrays.asList("https://www.googleapis.com/auth/firebase.messaging"));
		  googleCredential.refreshToken();
		  return googleCredential.getAccessToken();
		}
	
    public void send_FCM(String tokenId, String title, String content) {
        try {   
            //본인의 json 파일 경로 입력
            FileInputStream refreshToken = new FileInputStream("C:\\Users\\사용자\\git\\lifeinfo\\lifeinfo\\src\\main\\webapp\\resources\\google\\json\\fcm-test-fc769-firebase-adminsdk-7m7y6-8101d9bc19.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
            	    .setCredentials(GoogleCredentials.getApplicationDefault())
            	    .setDatabaseUrl("https://fcm-test-fc769.firebaseio.com")
            	    .build();
            //Firebase 처음 호출시에만 initializing 처리
            if(FirebaseApp.getApps().isEmpty()) { 
                FirebaseApp.initializeApp(options);
            }
            
            //String registrationToken = 안드로이드 토큰 입력;
            String registrationToken = tokenId;

            //message 작성
            Message msg = Message.builder()
                    .setAndroidConfig(AndroidConfig.builder()
                        .setTtl(3600 * 1000) // 1 hour in milliseconds
                        .setPriority(AndroidConfig.Priority.NORMAL)
                        .setNotification(AndroidNotification.builder()
                            .setTitle(title)
                            .setBody(content)
                            .setIcon("stock_ticker_update")
                            .setColor("#f45342")
                            .build())
                        .build())
                    .setToken(registrationToken)
                    .build();

            //메세지를 FirebaseMessaging 에 보내기
            String response = FirebaseMessaging.getInstance().send(msg);
            //결과 출력
            System.out.println("Successfully sent message: " + response);
                 
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String args[]) {
    	new FcmUtil().send_FCM("cBc4c723-gY:APA91bEe1yBre5h1pdKigxkaXk-sVEl_UhPvE0t3ClOKYulJ85HTz7groP4nF7XMdTlFyG539XxTl1m2-hX3ZEHwWD6Quvr0rXH-ARpKJDhKWtgKPaLolXzJKfR3aVog4pWXBr6WPsUy", "title", "content");
    }
}
