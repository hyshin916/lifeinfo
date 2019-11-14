package kr.co.mseshop.agent;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;

import kr.co.mseshop.common.Constants;

public class NewsAgentThread implements Runnable {

	boolean start = false;
	String filePath;
	String location;

	HashMap<String, Object> newsMap;

	public void setNewsAgentThread(boolean start) {
		this.start = start;
	}

	public void setNewshashMap(HashMap<String, Object> tempNewsMap) {
		this.newsMap = tempNewsMap;
	}

	HashMap<String, String> chkFileMap = new HashMap<String, String>();
	
	
	@SuppressWarnings("unused")
	File dirFiles;
	File[] tempFile;

	public NewsAgentThread(String location, String filePath) {
		this.filePath = filePath;
		this.location = location;
		dirFiles = new File(filePath);
	}

	public void statusFileInfo(HashMap<String, Object> newsMap, String delFileName, String tempFileName) {
		System.out.println("tempName:" + tempFileName);
		
		AbstractNewsCommon kangwon = NewsAgent.getInstance(location, tempFileName, newsMap);
		NewsAgent.setAgentMode("standAlone", delFileName);
		kangwon.start();
	}

	public void statusFileInfo(HashMap<String, Object> newsMap) {
		AbstractNewsCommon kangwon = NewsAgent.getInstance(location, filePath, newsMap);
		NewsAgent.setAgentMode("standAlone", "");
		kangwon.start();
	}

	
	boolean isStart = false;
	
	HashMap<String,String> tempMap = new HashMap<String,String>();
	public void findDirFiles(File dirFiles) {
		
		if (cnt > 1) { 
			isStart = true;
		}
		
		if (dirFiles.isDirectory()) {
			
			tempFile = dirFiles.listFiles();

			for (File list : tempFile) {
				if (list.isFile()) {
					String tempPath = list.getParent();
					String tempFileName = list.getName();
					System.out.println("[File Check Complete] : " + chkFileMap.size());
					if (isStart) {
							if (chkFileMap.get(tempFileName) == null) {
								System.out.println("tempfilename:" + tempPath + Constants.NEWS_ETC_OS + tempFileName);
								tempMap.put(tempFileName,tempPath + Constants.NEWS_ETC_OS + tempFileName);
								System.out.println(tempMap.get(tempFileName));
							System.out.println("[Insert target]: " + tempFileName);
							statusFileInfo(newsMap,tempFileName.replace(".xml", ""), tempPath + Constants.NEWS_ETC_OS + tempFileName);
							}
					}
					if (chkFileMap.get(tempFileName) != null && !chkFileMap.get(tempFileName)
							.equals(updateChkFile(new File(tempPath + Constants.NEWS_ETC_OS + tempFileName)))) {
						String compareDateASIS = chkFileMap.get(tempFileName);
						String compareDateTOBE = updateChkFile(new File(tempPath + "\\" + tempFileName));
						System.out.println("compareDateASIS : 	" + compareDateASIS);
						System.out.println("compareDateTOBE : 	" + compareDateTOBE);

						if (!compareDateASIS.equals(compareDateTOBE)) {
							System.out.println("[NewsML]" + tempFileName + " 생성날짜가 다릅니다.");

							statusFileInfo(newsMap,tempFileName.replace(".xml", ""), tempPath + Constants.NEWS_ETC_OS + tempFileName);

						}
						
					}

					String result = updateChkFile(new File(tempPath + Constants.NEWS_ETC_OS + tempFileName));
					
					chkFileMap.put(tempFileName, result);
					//tempFile = dirFiles.listFiles();

				}
				findDirFiles(list);
				System.out.println("###########################");
				System.out.println("[File Check Complete] : " + chkFileMap.size());
				System.out.println("###########################");
			}
		}
		
	}
	int cnt = 0;
	public void run() {
		try {
		
			while (!start) {
				cnt++;
				Thread.sleep(60000);
				
			    long free  = Runtime.getRuntime().freeMemory();
			    long total = Runtime.getRuntime().totalMemory();
			    long max   = Runtime.getRuntime().maxMemory();

			    System.out.format("Total Memory : %6.2f MB%n", (double) total / (1024 * 1024));
			    System.out.format("Free  Memory : %6.2f MB%n", (double) free  / (1024 * 1024));
			    System.out.format("Max   Memory : %6.2f MB%n", (double) max   / (1024 * 1024));
			    
			    
    	    	findDirFiles(dirFiles);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String updateChkFile(File file) {

		String date = "";

		long lastModified = file.lastModified();

		String pattern = "yyyy-MM-dd hh:mm aa";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Date lastModifiedDate = new Date(lastModified);

		// System.out.println( "The file " + file + " was last modified on " +
		// simpleDateFormat.format( lastModifiedDate ) );
		date = simpleDateFormat.format(lastModifiedDate);

		return date;
	}

}