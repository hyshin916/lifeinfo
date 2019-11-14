package kr.co.mseshop.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import kr.co.mseshop.model.CrawlInfoVO;

public class DBSave2 {
	
	String url ="jdbc:mysql://localhost:3306/crawldb?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
	String user = "root";
	String password = "1234";
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("JDBC Driver loading SUCCESS...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	
	
	public String strParse(String parseData) throws IOException, InterruptedException {

		CrawlInfoVO info = new CrawlInfoVO();

		int result = 0;

		String[] str1 = parseData.split("&&");
		System.out.println("str Size: " + str1.length);
		String[] str2 = null;
		String[] str3 = null;
		for (int i = 0; i < str1.length; i++) {
			System.out.println("==========================================================================");
			System.out.println(str1[i]);
			System.out.println("==========================================================================");
			str2 = str1[i].split(";;");
			str3 = new String[str2.length];
			System.out.println("str3size:"  + str3.length);
			for (int j = 0; j < str2.length; j++) {
				str3[j] = str2[j];
				System.out.println("str3: " + str3[j]);
			}
			info.setCategory(str3[0]);
			String[] viewURLThumb = str3[1].split("::");
			info.setViewURL(viewURLThumb[0]);
			info.setThumbURL(viewURLThumb[1]);
			info.setTitle(str3[2]);
			info.setPrice(str3[3]);
			info.setProPrice(str3[4]);
			info.setSize(str3[5]);
			info.setColor(str3[6]);
			if (str3.length == 7) {
				info.setBodyImgURL("");
			} else {
				info.setBodyImgURL(str3[7]);	
			}
			
			dbConnection(info);

		}

		if (result == 0) {
			System.out.println("================== DB insert SUCCESS ==================");
		}
		refinddata();
		return null;
	}

	public void refinddata() throws IOException, InterruptedException {
		URL url = new URL("http://localhost:8080/open/refinddata");
		URLConnection uc;
		uc = url.openConnection();
		uc.setConnectTimeout(30000);
		uc.setReadTimeout(30000);


		
	//	uc.setDoOutput(true);
		uc.setRequestProperty("token", "lee");
		
/*		OutputStreamWriter out = new OutputStreamWriter(uc.getOutputStream());
		out.write(para);
		out.flush();*/
		
		BufferedReader buffer = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		String value ="";
		System.out.println("result:");
		StringBuffer buffers = new StringBuffer();
		while ((value = buffer.readLine())!=null) {
			//System.out.println(value);
			buffers.append(value);
		}
		Thread.sleep(3000);
	}
	
	public void dbConnection(CrawlInfoVO info) {
		
		Connection con = null;
		PreparedStatement psmt = null;
		
		String query = "insert into crawlinfo_tbl(category,viewurl,thumburl,title,price,proprice,size,color,bodyimgurl,thumbfileName,made,reg_date) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			con = DriverManager.getConnection(url, user, password);
			psmt = con.prepareStatement(query);
			psmt.setString(1, info.getCategory());
			psmt.setString(2,info.getViewURL());
			psmt.setString(3,info.getThumbURL());
			psmt.setString(4,info.getTitle());
			psmt.setString(5,info.getPrice());
			
			

				String convertStr = info.getProPrice().replace("¥ ", "");

			    if (convertStr.indexOf(".")!=-1) {
			    	int a = convertStr.indexOf(".");
			    	String temp = convertStr.substring(0, a);
					info.setProPrice(temp);
			    } else {
			    	info.setProPrice(convertStr);
			    }
						
			
			psmt.setString(6,info.getProPrice());
			psmt.setString(7,info.getSize());
			psmt.setString(8,info.getColor());
			psmt.setString(9, info.getBodyImgURL());
			
			int a = info.getThumbURL().lastIndexOf("/");
			String convetFileName = info.getThumbURL().substring(a+1,info.getThumbURL().length());
			info.setThumbfileName(convetFileName);
			psmt.setString(10,info.getThumbfileName());
			psmt.setString(11,"Y");
			
			Date today = new Date();
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			
			psmt.setString(12,format1.format(today));
			
			psmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
