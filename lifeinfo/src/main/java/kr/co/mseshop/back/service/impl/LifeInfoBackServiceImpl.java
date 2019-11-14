package kr.co.mseshop.back.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import kr.co.mseshop.back.dao.NewsBackDao;
import kr.co.mseshop.back.service.LifeInfoBackService;
import kr.co.mseshop.criteria.BbsInfoCriteria;
import kr.co.mseshop.model.ArticleVO;
import kr.co.mseshop.model.FileVO;

@Service("lifeInfoBackService")
public class LifeInfoBackServiceImpl implements LifeInfoBackService {

	@Inject
	NewsBackDao newsBackDao;
	
	@Override
	public void add(ArticleVO articleVO) {
		newsBackDao.add(articleVO);
	}

	@Override
	public List<ArticleVO> list(BbsInfoCriteria criteria,RowBounds rowBounds) {
		return newsBackDao.list(criteria,rowBounds);
	}

	@Override
	public ArticleVO getDetail(String nsid) {
		
		ArticleVO articleVO = newsBackDao.getDetail(nsid);
		if (articleVO.getStart_date()!=null && articleVO.getExpire_date()!=null) {
		String[] start_date = articleVO.getStart_date().split(" ");
		String[] expire_date = articleVO.getExpire_date().split(" ");
		try {
			articleVO.setStart_date(start_date[0]);
			articleVO.setStart_time(start_date[1]);
			articleVO.setExpire_date(expire_date[0]);
			articleVO.setExpire_time(expire_date[1]);
		} catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		}
		return articleVO; 
	}

	@Override
	public void updateOrderByNO(String nsid, String idx) {
		HashMap<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("nsid", nsid);
		paramMap.put("idx", idx);

		newsBackDao.updateOrderByNO(paramMap);
	}

	@Override
	public void updateArticle(ArticleVO articleVO) {
		newsBackDao.updateArticle(articleVO);
	}

	@Override
	public void fileUpload(FileVO fileVO) {
		newsBackDao.fileUpload(fileVO);
	}

	@Override
	public void updateFile(FileVO fileVO) {
		newsBackDao.updateFile(fileVO);
	}

	@Override
	public int getRowCount(BbsInfoCriteria criteria) {
		return newsBackDao.getRowCount(criteria);
	}

	@Override
	public void deleteFile(String fno) {
		newsBackDao.deleteFile(fno);
	}

	@Override
	public int getNewsRowCount(BbsInfoCriteria criteria) {
		return newsBackDao.getNewsRowCount(criteria);
	}

	@Override
	public List<ArticleVO> getNewslist(BbsInfoCriteria criteria, RowBounds rowBounds) {
		return newsBackDao.getNewslist(criteria,rowBounds);
	}

	@Override
	public ArticleVO getNewsDetail(String nsid) {
		ArticleVO articleVO = newsBackDao.getNewsDetail(nsid);
		System.out.println("imgUrl: " + articleVO.getImgurl());
		if (articleVO.getImgurl()!=null && !articleVO.getImgurl().equals("")) {
			articleVO.setImgurl("이미지가 등록되어 있습니다.");
		} else {
			if (articleVO.getImgurl()==null || articleVO.getImgurl().equals("")) {
				articleVO.setImgurl("주요기사 이미지가 없습니다.파일첨부로 등록해주세요!");
			}
		}
		if (articleVO.getStart_date() != null && articleVO.getExpire_date() != null) {
			if (!articleVO.getStart_date().equals("") && !articleVO.getExpire_date().equals("")) {
				String[] start_date = articleVO.getStart_date().split(" ");
				String[] expire_date = articleVO.getExpire_date().split(" ");
				try {
					articleVO.setStart_date(start_date[0]);
					articleVO.setStart_time(start_date[1]);
					articleVO.setExpire_date(expire_date[0]);
					articleVO.setExpire_time(expire_date[1]);
				} catch(ArrayIndexOutOfBoundsException e) {
					e.printStackTrace();
				}
			}
		}
		
		return articleVO;
	}

	@Override
	public void updateNewsArticle(ArticleVO articleVO) {
		newsBackDao.updateNewsArticle(articleVO);
	}

	@Override
	public String isImgUrlChk(String nsid) {
		return newsBackDao.isImgUrlChk(nsid);
	}

	@Override
	public List<ArticleVO> getLineStatus() {
		return newsBackDao.getLineStatus();
	}

	@Override
	public List<ArticleVO> getImpList() {
		return newsBackDao.getImpList();
	}

	@Override
	public List<ArticleVO> getLifeMainList() {
		return newsBackDao.getLifeMainList();
	}





}
