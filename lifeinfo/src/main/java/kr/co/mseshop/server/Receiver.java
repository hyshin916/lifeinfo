package kr.co.mseshop.server;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class Receiver extends Thread {
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	FileOutputStream fos;
	BufferedOutputStream bos;
	
	public Receiver(Socket socket) {
		this.socket = socket;
	
	}
	
	public void run() {
		try {
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			String type= dis.readUTF();
			
			if (type.equals("file")) {
				String result = null;
				try {
					result = fileWrite(dis);
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					System.out.println("파일을 끝까지 읽었습니다.");
				}
				System.out.println("Result:" + result);
			} else if(type.equals("msg")) {
				String result = getMsg(dis);
				System.out.println("Result:" + result);
				if (result.equals("SUCCESS")) {
					dos.writeUTF("SUCCESS");	
				} else {
					dos.writeUTF("FAIL");
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
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
	
	public boolean userChk(String userInfo) {
	
		boolean chkUser = false;
		String[] userArr = userInfo.split(";");
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT id FROM crawldb.user_tbl where id='" + userArr[0]+ "' and passwd = '"+ userArr[1] +"'";
		try {
			conn = DriverManager.getConnection(url, user, password);
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("id"));
				if (!rs.getString("id").equals("")) {
					chkUser = true;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return chkUser;
	}

	private String getMsg(DataInputStream dis) {
		String result = null;
		try {
			System.out.println("File RECEIVE Start...");
			String msg = dis.readUTF();
			System.out.println("msg:" + msg.toString());
			
			boolean isChkUser = userChk(msg.toString());
			if (isChkUser == true) {
				result = "SUCCESS";	
			} else {
				result = "ERROR";
			}
			System.out.println("MESSAGE RECEIVE END");
		} catch (Exception e) {
			e.printStackTrace();
			result = "ERROR";
		} finally {
			try {
				//dis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public String clientFileRead() throws IOException, InterruptedException {
		
		
	    BufferedReader bReader = null;
	    StringBuffer buffer = new StringBuffer();
	        try {
	            
	            String s;
	            FileInputStream fis = new FileInputStream(Constants.LOG_UNZIPFILES);
	            InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
	            bReader = new BufferedReader(isr);
	            
	            while((s = bReader.readLine()) != null) {
	                buffer.append(s);
	            }
	            bReader.close();
				isr.close();
				fis.close();
	        } catch(Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if(bReader != null) bReader.close();
	            } catch(IOException e) {
	                e.printStackTrace();
	            }
	        }
	        System.out.println("===================================================");
	        System.out.println(buffer.toString());
	        System.out.println("===================================================");
	        DBSave dbSave = new DBSave();
	        dbSave.strParse(buffer.toString());
	        
	        
	        
		return null;
	}
	
	
	
	private String fileWrite(DataInputStream dis) throws Throwable {
		String result = null;
		
		try {
			System.out.println("File Receive start...");
			String fileNm = dis.readUTF();
			System.out.println("File Name : " + fileNm + " Receive SUCCESS");
			
			File file = new File(Constants.FILE_PATH + "\\" + fileNm);
			fos =  new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			System.out.println(fileNm + " File Made SUCCESS");
			
			int len;
			int size = 4096;
			byte[]  data = new byte[size];
			while((len = dis.read(data))!=-1) {
				bos.write(data,0,len);
			}
			bos.flush();
			result = "SUCCESS";
			System.out.println("FILE RECEIVE SUCCESS COMPLETE");
			System.out.println("FILE SIZE : " + file.length());
			
			UnzipUtil.decompress(Constants.FILE_PATH +"\\"+ fileNm, Constants.FILE_PATH +"\\unzipfiles");
			clientFileRead();
		} catch (Exception e) {
				e.printStackTrace();
				result = "ERROR";	
		} finally {
			try {
				bos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				dis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
