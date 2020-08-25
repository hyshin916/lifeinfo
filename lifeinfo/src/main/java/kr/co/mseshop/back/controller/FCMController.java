package kr.co.mseshop.back.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;

@Controller
public class FCMController {
	
	@RequestMapping(value="/fcmTest1")
    public String index(Model model, HttpServletRequest request, HttpSession session)throws Exception{
            
                
                final String apiKey = "AAAAXz8YYtE:APA91bH7nlpxqxH1IITtQb9lt37XY4AZOaIGU8fejVniHVhgoeLU6rMDVS-_CImClvdI7a-oGyzYuQyGxOWwLj0IWalOcXeetvItxBs9yZkNaIAYu6TFjLLmsJBZp-Z7OA3OhYk7ikiS";
                URL url = new URL("https://fcm.googleapis.com/fcm/send");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("Authorization", "key=" + apiKey);
 
                conn.setDoOutput(true);
                
 
                
                // 이걸로 보내면 특정 토큰을 가지고있는 어플에만 알림을 날려준다  위에 둘중에 한개 골라서 날려주자
                String input = "{\"notification\" : {\"title\" : \"이계진님 당첨되셨습니다. \", \"body\" : \"ms인포테크\"}, \"data\" : {\"url\" : \"http://ms-eshop.co.kr/m/board_view.php?num=3270&board=event&alrim=1\" }, \"to\":\"02AA7C906FB344BB95970A5C8E2A1CF01293882880EDED77840628F07CAABD54\"}";
 
                OutputStream os = conn.getOutputStream();
                
                // 서버에서 날려서 한글 깨지는 사람은 아래처럼  UTF-8로 인코딩해서 날려주자
                os.write(input.getBytes("UTF-8"));
                os.flush();
                os.close();
 
                int responseCode = conn.getResponseCode();
                System.out.println("\nSending 'POST' request to URL : " + url);
                System.out.println("Post parameters : " + input);
                System.out.println("Response Code : " + responseCode);
                
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
 
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                // print result
                System.out.println(response.toString());
                
        return "FCMTest";
    }


	
	@RequestMapping(value="/fcmTest", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
    public String fcmTest() throws Exception {
        try {    
            System.out.println("[FCM TEST] fcm test start ...");
            String path = "C:\\Users\\사용자\\git\\lifeinfo\\lifeinfo\\src\\main\\webapp\\resources\\google\\json\\fcm-test-fc769-firebase-adminsdk-7m7y6-8101d9bc19.json";           
            String MESSAGING_SCOPE = "https://www.googleapis.com/auth/firebase.messaging";
            String[] SCOPES = { MESSAGING_SCOPE };
            
            GoogleCredential googleCredential = GoogleCredential
                                .fromStream(new FileInputStream(path))
                                .createScoped(Arrays.asList("https://www.googleapis.com/auth/firebase", 
                                		"https://www.googleapis.com/auth/cloud-platform", 
                                		"https://www.googleapis.com/auth/firebase.readonly"));
            googleCredential.refreshToken();
                                
            HttpHeaders headers = new HttpHeaders();
            headers.add("content-type" , MediaType.APPLICATION_JSON_VALUE);
            headers.add("Authorization", "Bearer " + googleCredential.getAccessToken());
            
            
            
            JSONObject notification = new JSONObject();
            notification.put("body", "TEST");
            notification.put("title", "TEST");
            
            JSONObject message = new JSONObject();
            message.put("token", "cBc4c723-gY:APA91bEe1yBre5h1pdKigxkaXk-sVEl_UhPvE0t3ClOKYulJ85HTz7groP4nF7XMdTlFyG539XxTl1m2-hX3ZEHwWD6Quvr0rXH-ARpKJDhKWtgKPaLolXzJKfR3aVog4pWXBr6WPsUy");
            message.put("notification", notification);
            
            JSONObject jsonParams = new JSONObject();
            jsonParams.put("message", message);
            
            HttpEntity<JSONObject> httpEntity = new HttpEntity<JSONObject>(jsonParams, headers);
            RestTemplate rt = new RestTemplate();            
            
            ResponseEntity<String> res = rt.exchange("https://fcm.googleapis.com/v1/projects/fcm-test-fc769/messages:send"
                    , HttpMethod.POST
                    , httpEntity
                    , String.class);
        
            if (res.getStatusCode() != HttpStatus.OK) {
                /*log.debug("FCM-Exception");
                log.debug(res.getStatusCode().toString());
                log.debug(res.getHeaders().toString());
                log.debug(res.getBody().toString());
                */
            	System.out.println("FCM-Exception");
            	System.out.println(res.getStatusCode().toString());
            	System.out.println(res.getHeaders().toString());
            	System.out.println(res.getBody().toString());
               
            	
            } else {
                /*log.debug(res.getStatusCode().toString());
                log.debug(res.getHeaders().toString());
                log.debug(res.getBody().toLowerCase());
                */
            	System.out.println(res.getStatusCode().toString());
            	System.out.println(res.getHeaders().toString());
            	System.out.println(res.getBody().toLowerCase());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return "FCMTest";
    }

}
