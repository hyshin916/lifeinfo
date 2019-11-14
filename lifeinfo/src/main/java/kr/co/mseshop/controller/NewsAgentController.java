package kr.co.mseshop.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.mseshop.agent.AbstractNewsCommon;
import kr.co.mseshop.agent.NewsAgent;
import kr.co.mseshop.agent.NewsAgentThread;

@Controller
public class NewsAgentController {
	static HashMap<String, Object> newsMap = new HashMap<String, Object>();

	@RequestMapping(value = "news/control",method = RequestMethod.GET)
	public String newsAgentControl(@RequestParam String caption,@RequestParam String os, @RequestParam String path) {
		
		String winPATH = "D:\\";
		String linuxPATH = "/";
		String resultPATH = "";
		
		System.gc();
		System.out.println("[현재메모리사용량] :" + Runtime.getRuntime().freeMemory());
		
		if (os.equals("win")) {
			resultPATH = winPATH + path;
		} else if (os.equals("linux")) {
			resultPATH = linuxPATH + path;
		}
		System.out.println("PATH:" + resultPATH);
		
		if (!path.equals("down")) {
			AbstractNewsCommon kangwon = NewsAgent.getInstance(caption, resultPATH, newsMap); // args[1] xml 최상위 PATH
			kangwon.start();
		}
		System.gc();
		System.out.println("[Object 메모리사용량] :" + Runtime.getRuntime().freeMemory());
		
		// domin.start();
		/*
		 * Thread.sleep(10000); NewsAgentThread na =
		 * (NewsAgentThread)newsMap.get("kangwon"); na.setNewsAgentThread(true);
		 * 
		 * Thread.sleep(10000); NewsAgentThread na1 =
		 * (NewsAgentThread)newsMap.get("domin"); na1.setNewsAgentThread(true);
		 */

		if (path.equals("down")) {
			NewsAgentThread na = (NewsAgentThread) newsMap.get("kangwon");
			na.setNewsAgentThread(true);
			System.out.println("[Thread Down...]");
		}
		return "news/control";
	}
}
