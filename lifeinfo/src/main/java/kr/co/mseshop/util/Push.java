package kr.co.mseshop.util;

import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.OutputStream;  
import java.net.HttpURLConnection;  
import java.net.URL;  
import java.util.ArrayList;  
import java.util.List;  
  
public class Push  
{  
	String            endpoint;  
	List<String>      scope;  
	String            keyFile;  
	String            accessToken;  
	HttpURLConnection http;  
	StringBuffer      responseBody;  
  
	public Push() throws IOException  
	{  
	    this.endpoint = System.getProperty("endpoint");  
		this.keyFile = System.getProperty("fcm_key");  
	  
		String tmp[] = System.getProperty("scope").split(",");  
		this.scope = new ArrayList<>();  
		for (String s : tmp)  
		{  
			this.scope.add(s);  
	    }  
	  
		this.accessToken = AccessToken.getAccessToken(keyFile, scope);
		responseBody = new StringBuffer();  
	}  

	public String getEndpoint()  
	{  
		return endpoint;  
	}  
  
    public void setEndpoint(String endpoint)  
    {  
		this.endpoint = endpoint;  
	}  
  
	public String getAccessToken()  
	{  
		return accessToken;  
	}  
  
	public void setAccessToken(String accessToken)  
	{  
		this.accessToken = accessToken;  
	}  
  
	public StringBuffer getResponseBody()  
	{  
		return responseBody;  
	}  
  
	public String send(String userToken, String message) throws IOException  
	{  
		URL url = new URL(endpoint);  
		http = (HttpURLConnection) url.openConnection();  
  
		http.setRequestMethod("POST");  
		http.setDoInput(true);  
		http.setRequestProperty("Authorization", "Bearer " + accessToken);  
		http.setRequestProperty("Content-Type", "application/json; UTF-8");  
  
		http.setDoOutput(true);  
		OutputStream os = http.getOutputStream();  

		String body =  
            "{\n" + "\"message\":{\n" + " \"notification\": {\n" + " \"title\": \"FCM Message\",\n"  
			+ " \"body\": \"" + message + "\",\n"  
			+ "  },\n" + " \"token\": \"" + userToken + "\"\n" + "  }\n" + "}\n";  
  
		  System.out.println(body);  
  
		os.write(body.getBytes());  
		os.flush();  
  
		os.close();  
  
		System.out.println("* CODE : " + http.getResponseCode());  
		System.out.println("* MSG  : " + http.getResponseMessage());  
  
		if(http.getResponseCode() == 200)  
		{  
			BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream(), "UTF8"));  
  
			String line;  
			while ((line = br.readLine()) != null)  
			{  
				responseBody.append(line);  
			}  
  
			br.close();  
		}  
  
		 http.disconnect();  
  
		return http.getResponseMessage();  
	}  
	
	
	public static void main(String[] args) throws IOException 
	{  
		System.setProperty("endpoint", "https://fcm.googleapis.com/v1/projects/fcm-test-fc769/messages:send");
		System.setProperty("fcm_key", "C:\\Users\\사용자\\git\\lifeinfo\\lifeinfo\\src\\main\\webapp\\resources\\google\\json\\fcm-test-fc769-firebase-adminsdk-7m7y6-8101d9bc19.json");
		System.setProperty("scope", "https://www.googleapis.com/auth/firebase," + 
				" https://www.googleapis.com/auth/cloud-platform," + 
				" https://www.googleapis.com/auth/firebase.readonly");
		
		Push push = new Push();  
		try 
		{  
			push.send("cBc4c723-gY:APA91bEe1yBre5h1pdKigxkaXk-sVEl_UhPvE0t3ClOKYulJ85HTz7groP4nF7XMdTlFyG539XxTl1m2-hX3ZEHwWD6Quvr0rXH-ARpKJDhKWtgKPaLolXzJKfR3aVog4pWXBr6WPsUy", "잘 갑니다~~");  
	  } catch (IOException e) {  
	      e.printStackTrace();  
	  }  
	}
}