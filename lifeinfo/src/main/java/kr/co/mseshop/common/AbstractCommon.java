package kr.co.mseshop.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import kr.co.mseshop.model.ArticleVO;

public abstract class AbstractCommon<T> implements Action {

	public String viewName;
	public T obj;
	public String path;

	public URL url;
	public URLConnection uc;
	public Document doc;

	public HashMap<String, Object> objMap;
	public ArrayList<T> objList;
	public Model model;
	public String method;

	Logger logger = Logger.getLogger(this.getClass());

	String mode;

	public AbstractCommon(String method, T articleVO) {
		this.obj = articleVO;
		this.method = method;
	}

	public AbstractCommon(Model model, String viewName, T obj, String newsMethod) {
		this.model = model;
		this.viewName = viewName;
		this.obj = obj;
		this.method = newsMethod;

		objMap = new HashMap<String, Object>();
		objList = new ArrayList<T>();
	}

	@Override
	public void execute(String location, String filePath, String agentMode) {
		xmlHandler(location, filePath, agentMode);
	}

	BufferedReader br = null;
	String value = null;
	StringBuffer buffer = null;

	public void xmlHandler(String location, String filePath, String agentMode) {

		try {

			if (method.equals("HTTP")) {

				url = new URL(Constants.LIFEINFO_NEWS_PATH);

				uc = url.openConnection();

				uc.setConnectTimeout(30000);
				uc.setReadTimeout(30000);

				br = new BufferedReader(new InputStreamReader(uc.getInputStream()));

				buffer = new StringBuffer();
				while ((value = br.readLine()) != null) {
					buffer.append(value);
				}
				xmlCommonLogic(buffer);

			} else if (method.equals("TCP")) {
				File dir = new File(filePath);

				findDirFiles(dir, agentMode);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void findDirFiles(File dir, String agentMode) {
		FileInputStream fis = null;
		if (dir.isDirectory()) {
			File[] tempFile = dir.listFiles();

			for (File list : tempFile) {
				if (list.isFile()) {
					System.out.println("list search:" + list.getParent());

					String tempPath = list.getParent();
					String tempFileName = list.getName();
					System.out.println("Path=" + tempPath);
					System.out.println("FileName=" + tempFileName);
					if (tempFileName.equals(".bash_profile") || tempFileName.equals(".bash_history") || tempFileName.equals(".bashrc") || tempFileName.equals(".bash_logout") ) {
						continue;
					}
					try {
						fis = new FileInputStream(tempPath + Constants.NEWS_ETC_OS + tempFileName);
						InputStreamReader isr = new InputStreamReader(fis, "euc-kr");
						br = new BufferedReader(isr);
						buffer = new StringBuffer();
						while ((value = br.readLine()) != null) {
							buffer.append(value);
						}
						xmlCommonLogic(buffer);
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
				findDirFiles(list, "");
			}
		} else {
			System.out.println("파일입니다." + dir.getPath());
			System.out.println("파일입니다." + dir.getName());
			
			if ( !(dir.getName().equals(".bash_profile") || dir.getName().equals(".bash_history") || dir.getName().equals(".bashrc") || dir.getName().equals(".bash_logout")) ) {
			
				if (agentMode.equals("standAlone")) {
					try {
						fis = new FileInputStream(dir.getPath());
						InputStreamReader isr = new InputStreamReader(fis, "euc-kr");
						br = new BufferedReader(isr);
						buffer = new StringBuffer();
						while ((value = br.readLine()) != null) {
							buffer.append(value);
						}
						xmlCommonLogic(buffer);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
		}

	}

	public void xmlCommonLogic(StringBuffer buffer) throws SAXException, IOException, ParserConfigurationException {
		InputSource is = new InputSource(new StringReader(buffer.toString()));

		doc = (Document) DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
		doc.getDocumentElement().normalize();

		createXML();
	}

	public abstract void createXML();

}
