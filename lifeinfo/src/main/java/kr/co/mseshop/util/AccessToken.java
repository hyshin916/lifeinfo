package kr.co.mseshop.util;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;

import java.io.FileInputStream;
import java.io.IOException;  
import java.io.InputStream;  
import java.util.List;  

public class AccessToken  
{  
  
   public static String getAccessToken(String keyFile, List<String> scopes) throws IOException  
   {  
  System.out.println("keyfile:" + keyFile);
      
	  GoogleCredential googleCredential = GoogleCredential  
            .fromStream(new FileInputStream(keyFile))  
            .createScoped(scopes);  
  
	  googleCredential.refreshToken();  
  
	 return googleCredential.getAccessToken();  
  }  
}