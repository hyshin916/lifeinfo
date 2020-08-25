package kr.co.mseshop.util;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QrMaker {

	public static void main(String args[]) {
	        try {
	            File file = null;
	            // 큐알이미지를 저장할 디렉토리 지정
	            String path = "D:\\qrtest\\신규바코드_0310";
	            file = new File(path);
	            if(!file.exists()) {
	                file.mkdirs();
	            }
	            // 코드인식시 링크걸 URL주소
	            
	            
	           String codeurl = new String("http://183.111.169.187:8080/lifeinfo/franch?franch=1379".getBytes("UTF-8"), "ISO-8859-1");
	          //  String codeurl = new String("http://ms-eshop.co.kr/m/board_list.php?board=webzine".getBytes("UTF-8"), "ISO-8859-1");
	            // 큐알코드 바코드 생상값
	            int qrcodeColor =   000000;
	            // 큐알코드 배경색상값
	            int backgroundColor = 0xFFFFFFFF;
	             
	            QRCodeWriter qrCodeWriter = new QRCodeWriter();
	            // 3,4번째 parameter값 : width/height값 지정
	            BitMatrix bitMatrix = qrCodeWriter.encode(codeurl, BarcodeFormat.QR_CODE,4000, 4000);
	            //
	            MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(qrcodeColor,backgroundColor);
	            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix,matrixToImageConfig);
	            // ImageIO를 사용한 바코드 파일쓰기
	            
	            ImageIO.write(bufferedImage, "png", new File(path + "\\길인배시술원.png"));
	             
	        } catch (Exception e) {
	            e.printStackTrace();
	        }  


	}
}
