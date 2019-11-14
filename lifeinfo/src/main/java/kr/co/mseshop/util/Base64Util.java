package kr.co.mseshop.util;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class Base64Util {

	public Base64Util instance;
	
	public static Base64Util getInstance() {
		return new Base64Util();
	}
	
	public String enCoder(String text) {
		
		byte[] targetBytes = text.getBytes();
		Encoder encoder = Base64.getEncoder();
		byte[] encodedBytes = encoder.encode(targetBytes);
		
		return new String(encodedBytes);
	}
	
	public String deCoder(String text) {
		Decoder deCoder = Base64.getDecoder();
		byte[] decodeBytes = deCoder.decode(text);
		return new String(decodeBytes);
	}
	
	
}
