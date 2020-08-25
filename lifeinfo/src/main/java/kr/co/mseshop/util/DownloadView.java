package kr.co.mseshop.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String fileDownName = (String) request.getAttribute("fileOriName");
		
		File file = (File) paramMap.get("downloadFile");
		System.out.println("fileName:" + file.getPath());

		String downName = null;
		String browser = request.getHeader("User-Agent");
		// 파일 인코딩
		if (browser.contains("MSIE") || browser.contains("Trident") || browser.contains("Chrome")) {// 브라우저 확인 파일명
																									// encode

			downName = URLEncoder.encode(fileDownName, "UTF-8").replaceAll("\\+", "%20");

		} else {

			downName = new String(fileDownName.getBytes("UTF-8"), "ISO-8859-1");

		}

		//response.setContentType("application/download; charset=utf-8");
		response.setContentType("application/x-hwp; charset=utf-8"); // hwp 앱에서 한글 다운로드  
		response.setContentLength((int) file.length());
		response.setHeader("Content-Disposition", "attachment; filename=\"" + downName + "\";"); // 이부분에 파일이름 파라미터를 넣어주면
																									// 된다.
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("shin", "wowsin");
		OutputStream out = response.getOutputStream();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception e) {
				}
			}
		}

		out.flush();

	}

}
