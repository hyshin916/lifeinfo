package kr.co.mseshop.server;

import java.io.IOException;

public class DBinsert {

	public static void main(String args[]) throws IOException, InterruptedException {
		Receiver receiver = new Receiver(null);
		receiver.clientFileRead();
		
	}
}
