package kr.co.mseshop.agent;

import java.util.HashMap;


import kr.co.mseshop.model.ArticleVO;
import kr.co.mseshop.parser.NewsParser;

public class NewsAgent extends AbstractNewsCommon {

	public static NewsAgent instance;
	public static HashMap<String, Object> newsMap;
	NewsAgentThread nat;
	public static String agentMode = "";
	
	public static void setAgentMode(String mode, String temp) {
		agentMode = mode;
		System.out.println("Del:" + temp);
	}
	

	public static String url ="jdbc:log4jdbc:mysql://183.111.169.187:3306/msmartlife?autoReconnect=true&serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
	public static String user = "msmartlife";
	public static String password = "!msmartlife987!";
	
	static {
		try {
			Class.forName("net.sf.log4jdbc.DriverSpy");
			System.out.println("JDBC Driver loading SUCCESS...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static NewsAgent getInstance(String location, String filePath, HashMap<String, Object> v_newsMap) {

		instance = new NewsAgent(location, filePath);
		newsMap = v_newsMap;

		return instance;
	}

	public NewsAgent(String location, String filePath) {
		super(location, filePath);
	}
	
	


	@Override
	void threadStart() {
		
		ArticleVO articleVO = new ArticleVO();
		NewsParser parser = new NewsParser("TCP",articleVO);
		
		parser.setDBParseMode(true);
		parser.execute(location,filePath,agentMode);
		if (!(agentMode.equals("standAlone"))) {
			
			System.out.println("########################################");
			System.out.println("[setAgentMode] " + agentMode);
			System.out.println("########################################");
			
			nat = new NewsAgentThread(location, filePath);
			Thread t = new Thread(nat, location);
			System.out.println("nat:" + nat);
			newsMap.put(location, nat);
			nat.setNewshashMap(newsMap);
			
			
			t.start();
		}
	}


}
