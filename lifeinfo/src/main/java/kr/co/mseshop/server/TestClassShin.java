package kr.co.mseshop.server;

public class TestClassShin {

	
	public static void main(String args[]) {
		
		String[] arr = {"a","b","c","d"};
		
		
		for (String a : arr) {
			
			try {
				System.out.println(a);
				if (a.equals("c")) {
					throw new Exception("error ...");
				}
			}catch (Exception e) {
				System.out.println("에러발생");
				e.printStackTrace();
				continue;
			}
			
		}
	}
}
