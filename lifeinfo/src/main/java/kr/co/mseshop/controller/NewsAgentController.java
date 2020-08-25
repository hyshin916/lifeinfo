package kr.co.mseshop.controller;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.mseshop.agent.AbstractNewsCommon;
import kr.co.mseshop.agent.ChkThreadAlive;
import kr.co.mseshop.agent.LineNewsAgent;
import kr.co.mseshop.agent.NewsAgent;
import kr.co.mseshop.agent.NewsAgentThread;
import kr.co.mseshop.common.PathClass;

@Controller
public class NewsAgentController {
	static HashMap<String, Object> newsMap = new HashMap<String, Object>();

	@RequestMapping(value = "news/control", method = RequestMethod.GET)
	public String newsAgentControl(@RequestParam String caption, @RequestParam String os, @RequestParam String path) {

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

	LineNewsAgent lineAgent;
	ChkThreadAlive cta;

	@RequestMapping(value = "/back/news/lineNews", method = RequestMethod.GET)
	public String makelineNews(Model model, HttpServletResponse response,
			@RequestParam(value = "execute", required = false) String execute,
			@RequestParam(value = "interval", required = false) String interval,
			@RequestParam(value = "flag", required = false) String flag) {

		FileReader reader;
		String result = "";
		try {
			reader = new FileReader(PathClass.getDeamon_status());
			Properties initProp = new Properties();
			initProp.load(reader);
			result = initProp.getProperty("chkDaemon");
			model.addAttribute("daemonStatus", result);
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		if (flag != null && flag != "" && flag.equals("manual")) {
			String interval_cnt = "60000";
			if (interval != "") {
				interval_cnt = interval;
			}
			System.out.println("[interval] : " + interval_cnt);
			runNewsDaemon(execute, interval_cnt, flag);

		} else if (flag != null && flag != "" && flag.equals("auto")) {
			System.out.println("[execute]" + execute);
			System.out.println("[interval]" + interval);
			System.out.println("[flag]" + flag);
			JSONObject jObj = new JSONObject();
			try {
				runNewsDaemon(execute, interval, flag);
				jObj.put("resultFlag", execute);
				PrintWriter pw = response.getWriter();
				pw.println(jObj);
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return "newsControl";
	}

	public void runNewsDaemon(String execute, String interval_cnt, String flag) {
		try {
			if (execute.equals("start")) {
				lineAgent = new LineNewsAgent();
				lineAgent.setExecute(true, interval_cnt);
				Thread lineThread = new Thread(lineAgent, "line-Thread");
				lineThread.start();

				cta = new ChkThreadAlive(lineThread);
				cta.setChkThread(true);
				Thread chkThread = new Thread(cta, "chkThread");
				chkThread.start();
				Properties prop = new Properties();
				prop.remove("chkDaemon");
				prop.setProperty("chkDaemon", "true");
				prop.store(new FileOutputStream(PathClass.getDeamon_status()), "daemonStatus");

			} else if (execute.equals("stop")) {
				lineAgent.setExecute(false, null);
				// cta.setChkThread(false);

			} else {
				throw new Exception("[command error ... ]");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
