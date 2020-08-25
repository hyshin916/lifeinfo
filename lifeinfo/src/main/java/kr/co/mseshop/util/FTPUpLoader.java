package kr.co.mseshop.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 * ftp서버 접속하여 파일을 업로드/다운로드 함
 * @author 조한중(hanjoongcho@gmail.com)
 *
 */
public class FTPUpLoader {
    /**
     * 
     * @param ip         ftp서버ip
     * @param port       ftp서버port
     * @param id         사용자id
     * @param password   사용자password 
     * @param folder     ftp서버에생성할폴더
     * @param files      업로드list
     * @return
     */
    public boolean sendFtpServer(String ip, int port, String id, String password,

                          String folder,String localPath, ArrayList<String> files) {
        boolean isSuccess = false;
        FTPClient ftp = null;
        int reply;
        try {
            ftp = new FTPClient();
            ftp.connect(ip, port);
            System.out.println("Connected to " + ip + " on "+ftp.getRemotePort());
            
            // After connection attempt, you should check the reply code to verify
            // success.
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                System.err.println("FTP server refused connection.");
                System.exit(1);
            }
            
            if(!ftp.login(id, password)) {
                ftp.logout();
                throw new Exception("ftp 서버에 로그인하지 못했습니다.");
            }
            
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            ftp.enterLocalPassiveMode();
            
/*
            System.out.println(ftp.printWorkingDirectory());
            try{
                ftp.makeDirectory(folder);
            }catch(Exception e){
                e.printStackTrace();
            }
            ftp.changeWorkingDirectory(folder);
            System.out.println(ftp.printWorkingDirectory());*/
            
            
            for(int i = 0; i < files.size(); i++) {
                //ftp서버에 한글파일을 쓸때 한글깨짐 방지
                String tempFileName = new String(files.get(i).getBytes("utf-8"),"iso_8859_1");
                String sourceFile = localPath + files.get(i);        
                File uploadFile = new File(sourceFile);
                FileInputStream fis = null;
                try {
                    fis = new FileInputStream(uploadFile);
                    System.out.println(sourceFile + " : 전송시작 = >");

                   

                     //tempFileName 업로드 될 타겟의 풀 경로가 들어가야 함.  ex) /A/A01/A001/aa.zip   파일명만 들어갈경우 unix에서 전송 실패하는 경우가 생김.
                    isSuccess = ftp.storeFile(tempFileName, fis);  
                    System.out.println(sourceFile + " : 전송결과 = >" + isSuccess);
                } catch(IOException e) {
                    e.printStackTrace();
                    isSuccess = false;
                } finally {
                    if (fis != null) {
                        try {fis.close(); } catch(IOException e) {}
                    }
                }//end try
            }//end for
            
            ftp.logout();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ftp != null && ftp.isConnected()) {
                try { ftp.disconnect(); } catch (IOException e) {}
            }
        }
        return isSuccess;
    }

}



