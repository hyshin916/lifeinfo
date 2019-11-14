package kr.co.mseshop.server;

import java.net.ServerSocket;
import java.net.Socket;

public class ReceiveServer  {

	public static void main(String args[]) {
		new ReceiveServer().start();
	}

	public void start() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("Server Start...");
			
			while(true) {
				System.out.println("New Server connection wait...");
				
				socket = serverSocket.accept();
				System.out.println("Client Connection SUCCESS");
				Receiver receiver = new Receiver(socket);
				receiver.start();
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	

}
