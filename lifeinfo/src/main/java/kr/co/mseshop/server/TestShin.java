package kr.co.mseshop.server;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestShin {
		

		public void dbConnection() throws ClassNotFoundException {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("JDBC Driver loading SUCCESS...");
			String url ="jdbc:mysql://localhost:3306/crawldb?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
			String user = "root";
			String password = "1234";
			Connection con = null;
			PreparedStatement psmt = null;
			ResultSet rs = null;
			
			String maxCodeQuery = "select max(no) from crawlinfo_tbl";
			
			try {
				con = DriverManager.getConnection(url, user, password);
				psmt = con.prepareStatement(maxCodeQuery);
				rs = psmt.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getInt(1)+1);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}


	public static void main(String args[]) throws InterruptedException, ClassNotFoundException {
		new TestShin().dbConnection();
	}
}
