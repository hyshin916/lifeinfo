package kr.co.mseshop.util;

import java.util.ArrayList;

public class FTPUpLoaderMain {
    
    public static void main(String[] args) {
        
        FTPUpLoader upLoader = new FTPUpLoader();
        ArrayList<String> list = new ArrayList<String>();
        
        list.add("msmart1.jpg");
        String article_upload = "/usr/local/tomcat/webapps/lifeinfo/resources/lifeinfo/";
        boolean re = upLoader.sendFtpServer("183.111.169.187", 21, "lifeinfo",

                                                               "5467", article_upload,"D:\\", list);
        
        if(re){
            System.out.println("FTPUpLoaderMain.java :: 업로드 성공");
        }else{
            System.out.println("FTPUpLoaderMain.java :: 업로드 실패");
        }
    }
    

}



