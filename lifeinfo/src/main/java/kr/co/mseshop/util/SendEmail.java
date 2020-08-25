package kr.co.mseshop.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	public static void main(String[] args) {
		String host = "smtp.naver.com";
		final String user = "hygjlove012@naver.com";
		final String password = "sotkfkdgj!1";

		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			InternetAddress[] addArray = new InternetAddress[2];
			addArray[0] = new InternetAddress("hyshin916@gmail.com");
			addArray[1] = new InternetAddress("cerris86@gmail.com");
			/*addArray[2] = new InternetAddress("ktko2@ktko2.com");
			addArray[3] = new InternetAddress("ktko3@ktko3.com");
			addArray[4] = new InternetAddress("ktko4@ktko4.com");*/
			message.addRecipients(Message.RecipientType.TO, addArray);
			
			//message.addRecipient(Message.RecipientType.TO, new InternetAddress("ktko@ktko.com"));
			message.setSubject("[MS상품배송] 테스트 메일 입니다.");
			message.setText("MS 전산팀 화이팅!!!");
			Transport.send(message);
			System.out.println("Success Message Send");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}