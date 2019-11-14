package kr.co.mseshop.agent;

import java.util.HashMap;

public class TestClass {
	
	static HashMap<String,Object> newsMap = new HashMap<String,Object>();
	
	public static void main(String args[]) throws InstantiationException, IllegalAccessException, ClassNotFoundException, InterruptedException	 {
	
		AbstractNewsCommon kangwon = NewsAgent.getInstance(args[0], args[1],newsMap); //args[1] xml 최상위 PATH
		System.out.println("args:" + args[0] + ";" + args[1]);
		kangwon.start();
	//	domin.start();
/*		Thread.sleep(10000);
		NewsAgentThread na = (NewsAgentThread)newsMap.get("kangwon");
		na.setNewsAgentThread(true);
		
	
		Thread.sleep(10000);
		NewsAgentThread na1 = (NewsAgentThread)newsMap.get("domin");
		na1.setNewsAgentThread(true);*/
		
	}
}
