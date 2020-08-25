package kr.co.mseshop.back.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.mseshop.back.service.LifeInfoBackService;
import kr.co.mseshop.common.Constants;
import kr.co.mseshop.common.PathClass;
import kr.co.mseshop.criteria.BbsInfoCriteria;
import kr.co.mseshop.model.ArticleVO;
import kr.co.mseshop.model.FileVO;
import kr.co.mseshop.model.PhotoVo;
import kr.co.mseshop.taglib.PageHolder;

@Controller
public class NewsController {
	
	@Inject
	LifeInfoBackService lifeInfoBackService;
	
	@RequestMapping(value="/back/news/write")
	public String addContent(Model model,@RequestParam(value="view",required=false) String view,@RequestParam(value="nsid",required=false) String nsid,@RequestParam(value="media",required=false) String media) {
		
		System.out.println("view:" + view);
		System.out.println("nsid:" + nsid);
		ArticleVO article = null;
		if (view!=null &&view.equals("true")) {
		
			if (media!=null &&media.equals("news")) {
				article = lifeInfoBackService.getNewsDetail(nsid);
				model.addAttribute("pageView","?media=news");
				model.addAttribute("media","news");
			} else {
				model.addAttribute("pageView","lifeinfo");
				article = lifeInfoBackService.getDetail(nsid);
				article.setContent(article.getContent().replace("./", "../../"));
				System.out.println("[youtubeYN] : " + article.isYoutubeYN());
			}
			model.addAttribute("detail",article);
			model.addAttribute("mode","update");
		}
		model.addAttribute("moreNewsURL",Constants.HOST_DOMAIN);
		return "back/news/write";
	}
	
	@RequestMapping(value="/back/news/list")
	public String list(Model model,HttpServletRequest request,BbsInfoCriteria criteria,@RequestParam(value="media",required=false) String media) {
		 PageHolder pageHolder = null;
		 List<ArticleVO> list = null;
		 System.out.println("[Session] back ..." + request.getSession().getAttribute("user"));
		 
		if (media!=null && media.equals("news")) {
			int rowCount = lifeInfoBackService.getNewsRowCount(criteria);
			
	        pageHolder = new PageHolder(rowCount, criteria.getPage(), criteria.getListSize());
	        model.addAttribute("pageHolder", pageHolder);
			
	        list = lifeInfoBackService.getNewslist(criteria,criteria.getRowBounds());
	        model.addAttribute("pageView","?media=news");
		} else {
			int rowCount = lifeInfoBackService.getRowCount(criteria);
			
	        pageHolder = new PageHolder(rowCount, criteria.getPage(), criteria.getListSize());
	        model.addAttribute("pageHolder", pageHolder);
	        model.addAttribute("pageView","lifeinfo");
	        list = lifeInfoBackService.list(criteria,criteria.getRowBounds());
		}
		model.addAttribute("moreNewsURL",Constants.HOST_DOMAIN);
		model.addAttribute("newsList",list);
		
		return "back/news/list";
	}
	
	
	
	
	@RequestMapping(value="/back/news/addArticle",method = RequestMethod.POST)
	public String addArticle(ArticleVO articleVO,Model model,HttpServletRequest request,HttpServletResponse response,@RequestParam(value="startTime",required=false) String startTime,@RequestParam(value="endTime",required=false) String endTime, @RequestParam("mediaFile") MultipartFile mediaFile) {
		String sourceFileName = mediaFile.getOriginalFilename();
		String sourceFileNameExtension = FilenameUtils.getExtension(sourceFileName).toLowerCase();
		String destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + sourceFileNameExtension;
		
		System.out.println("[OrderByNO ...] " + articleVO.getOrderbyNOLine());
		articleVO = getArticleVO("add", articleVO, startTime, endTime);
		lifeInfoBackService.add(articleVO);
		fileUpload(articleVO,mediaFile,sourceFileName,destinationFileName);


		return "redirect:list";
	}
	
	
	private void fileUpload(ArticleVO articleVO, MultipartFile mediaFile,String sourceFileName,String destinationFileName) {
		
			FileVO fileVO = new FileVO();
	       	
	        Integer fileSize = (int) mediaFile.getSize();
	        File destinationFile; 
	        String fileUrl = PathClass.getArticle_upload();
	        
	        do { 
	            destinationFile = new File(fileUrl + destinationFileName); 
	        } while (destinationFile.exists()); 
	        	destinationFile.getParentFile().mkdirs(); 
	        try {
			 mediaFile.transferTo(destinationFile);
			 fileVO.setBno(articleVO.getNsid());
			 fileVO.setFno(articleVO.getFno());
			 fileVO.setFileName(destinationFileName);
	         fileVO.setFileOriName(sourceFileName);
	         fileVO.setFileSize(fileSize);
	         fileVO.setFileUrl(fileUrl);
	         fileVO.setPressCd(articleVO.getPcode());
	        	 
	         lifeInfoBackService.fileUpload(fileVO);
	         
	        } catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
	}
	
	@RequestMapping(value="/fileDownload",method = RequestMethod.GET)
	public ModelAndView fileDownload(HttpServletRequest request,String fileName,String fileOriName) {
		File file = new File(PathClass.getArticle_upload() + fileName);
		request.setAttribute("fileOriName", fileOriName);
		return new ModelAndView("fileDownload","downloadFile",file);
	}
	

	@RequestMapping(value="/back/news/updateArticle",method = RequestMethod.POST)
	public String updateArticle(ArticleVO articleVO,Model model,HttpServletRequest request,HttpServletResponse response,@RequestParam(value="startTime",required=false) String startTime,@RequestParam(value="endTime",required=false) String endTime,@RequestParam("mediaFile") MultipartFile mediaFile,@RequestParam(value="media",required=false) String media) {
		System.out.println("articleVO:" + articleVO);
		 String sourceFileName =  mediaFile.getOriginalFilename(); 
		  String sourceFileNameExtension = FilenameUtils.getExtension(sourceFileName).toLowerCase(); 
		  String destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + sourceFileNameExtension; 
		
		  if (media!=null &&media.equals("news")) {
			articleVO = getArticleVO("update",articleVO,startTime,endTime);
			String imgUrlChk = lifeInfoBackService.isImgUrlChk(articleVO.getNsid());
			System.out.println("imgUrlChk:" + imgUrlChk);
				if (articleVO.getFno().equals("") &&  sourceFileName.equals("")) {
					System.out.println("[INFO] server image true");
				} else if (articleVO.getFno().equals("") &&  !sourceFileName.equals("")) {
					System.out.println("[INFO] server image change");
					articleVO.setImgurl("http://" + Constants.HOST_DOMAIN + ":8080/lifeinfo/resources/articleImg/"+ destinationFileName);
					fileUpload(articleVO,mediaFile,sourceFileName,destinationFileName);
				} else if (!articleVO.getFno().equals("") &&  !sourceFileName.equals("")) {
					articleVO.setImgurl("http://" + Constants.HOST_DOMAIN + ":8080/lifeinfo/resources/articleImg/"+ destinationFileName);
					lifeInfoBackService.deleteFile(articleVO.getFno());
					fileUpload(articleVO,mediaFile,sourceFileName,destinationFileName);	
				} else if (!articleVO.getFno().equals("") &&  sourceFileName.equals("")) {
					System.out.println("[INFO] server image keep status");
				}
			lifeInfoBackService.updateNewsArticle(articleVO);
			/*			if (sourceFileName!="" && !articleVO.getFno().equals("") && !(imgUrlChk.indexOf(Constants.HOST_DOMAIN)!=-1)) {
					System.out.println("execute no");
					lifeInfoBackService.deleteFile(articleVO.getFno());
					fileUpload(articleVO,mediaFile,sourceFileName,destinationFileName);
			}*/
			return "redirect:list?media=news";
		} else { 
			articleVO = getArticleVO("update",articleVO,startTime,endTime);
			lifeInfoBackService.updateArticle(articleVO);
			if (sourceFileName!="") {
				lifeInfoBackService.deleteFile(articleVO.getFno());
				fileUpload(articleVO,mediaFile,sourceFileName,destinationFileName);
			}
			return "redirect:list";
		}
		
	}
	
	public ArticleVO getArticleVO(String mode,ArticleVO articleVO,String startTime,String endTime) {
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		System.out.println(format.format(date));
		String dateStr = format.format(date);
		
		String cvtStartDate = articleVO.getStart_date().trim() + ' ' + startTime;
		String cvtExpireDate = articleVO.getExpire_date().trim() + ' ' + endTime;
		articleVO.setStart_date(cvtStartDate);
		articleVO.setExpire_date(cvtExpireDate);
		
		System.out.println("title:" + articleVO.getTitle());
		System.out.println("content:" + articleVO.getContent());
		if (mode.equals("update")) {
			articleVO.setUpdate_date(dateStr);
		} else if (mode.equals("add")) {
			articleVO.setDate(dateStr);
		}
		articleVO.setContent(articleVO.getContent().replace("../../", "./"));
		
		return articleVO;
	}
	
	
	@RequestMapping(value="/back/news/updateOrderByNO",method=RequestMethod.POST)
	public String updateOrderByNO(Model model,@RequestParam(value="nsid",required=false) String nsid,@RequestParam(value="idx",required=false) String idx) {
		
		System.out.println("nsid:" + nsid);
		System.out.println("idx:" + idx);
		
		lifeInfoBackService.updateOrderByNO(nsid,idx);
		
		return "redirect:list";
	}
	
	
	@RequestMapping("/back/news/photoUpload")
	public String photoUpload(HttpServletRequest request, PhotoVo vo){
	    String callback = vo.getCallback();
	    String callback_func = vo.getCallback_func();
	    String file_result = "";
	    try {
	        if(vo.getFiledata() != null && vo.getFiledata().getOriginalFilename() != null && !vo.getFiledata().getOriginalFilename().equals("")){
	            //파일이 존재하면
	            String original_name = vo.getFiledata().getOriginalFilename();
	            String ext = original_name.substring(original_name.lastIndexOf(".")+1);
	            //파일 기본경로
	            String defaultPath = request.getSession().getServletContext().getRealPath("/");
	            //파일 기본경로 _ 상세경로
	            String path = defaultPath + "resource" + File.separator + "photo_upload" + File.separator;             
	            File file = new File(path);
	            System.out.println("path:"+path);
	            //디렉토리 존재하지 않을경우 디렉토리 생성
	            if(!file.exists()) {
	                file.mkdirs();
	            }
	            //서버에 업로드 할 파일명(한글문제로 인해 원본파일은 올리지 않는것이 좋음)
	            String realname = UUID.randomUUID().toString() + "." + ext;
	        ///////////////// 서버에 파일쓰기 /////////////////
	            vo.getFiledata().transferTo(new File(path+realname));
	            file_result += "&bNewLine=true&sFileName="+original_name+"&sFileURL=/resource/photo_upload/"+realname;
	        } else {
	            file_result += "&errstr=error";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return "redirect:" + callback + "?callback_func="+callback_func+file_result;
	}

	//다중파일업로드
	@RequestMapping("/back/news/multiplePhotoUpload")
	public void multiplePhotoUpload(HttpServletRequest request, HttpServletResponse response){
	    try {
	         //파일정보
	         String sFileInfo = "";
	         //파일명을 받는다 - 일반 원본파일명
	         String filename = request.getHeader("file-name");
	         //파일 확장자
	         String filename_ext = filename.substring(filename.lastIndexOf(".")+1);
	         //확장자를소문자로 변경
	         filename_ext = filename_ext.toLowerCase();
	         //파일 기본경로 _ 상세경로
	         String filePath = PathClass.getPhoto_upload() + File.separator + "photo_upload" + File.separator;
	         System.out.println("filePath:" + filePath);
	         File file = new File(filePath);
	         if(!file.exists()) {
	            file.mkdirs();
	         }
	         String realFileNm = "";
	         SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
	         String today= formatter.format(new java.util.Date());
	         realFileNm = today+UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
	         String rlFileNm = filePath + realFileNm;
	         ///////////////// 서버에 파일쓰기 /////////////////
	         InputStream is = request.getInputStream();
	         OutputStream os=new FileOutputStream(rlFileNm);
	         int numRead;
	         byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
	         while((numRead = is.read(b,0,b.length)) != -1){
	            os.write(b,0,numRead);
	         }
	         if(is != null) {
	            is.close();
	         }
	         os.flush();
	         os.close();
	         ///////////////// 서버에 파일쓰기 /////////////////
	         // 정보 출력
	         sFileInfo += "&bNewLine=true";
	         // img 태그의 title 속성을 원본파일명으로 적용시켜주기 위함
	         sFileInfo += "&sFileName="+ filename;
	         sFileInfo += "&sFileURL="+"../../resources/photo_upload/"+realFileNm;
	         PrintWriter print = response.getWriter();
	         print.print(sFileInfo);
	         print.flush();
	         print.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	@RequestMapping("/back/news/statistics")
	public String statistics(Model model) {
		
		List<ArticleVO> artLineList = lifeInfoBackService.getLineStatus();
		List<ArticleVO> newsImpList = lifeInfoBackService.getImpList();
		List<ArticleVO> lifeMainList = lifeInfoBackService.getLifeMainList();
		
		model.addAttribute("artLineList",artLineList);
		model.addAttribute("newsImpList",newsImpList);
		model.addAttribute("lifeMainList",lifeMainList);
		
		model.addAttribute("pageView","statistics");
		return "back/news/statistics";
	}
	


}
