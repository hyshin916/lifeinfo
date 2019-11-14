package kr.co.mseshop.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.mseshop.model.CrawlInfoVO;
import kr.co.mseshop.model.MadeCategoryCodeVO;
import kr.co.mseshop.model.RefindDataVO;
import kr.co.mseshop.model.SearchDataVO;

public interface CrawlDao {

	public List<CrawlInfoVO> list();

	public List<String> getViewlist(String no);

	public List<String> codeList();

	public List<String> categoryList(String param);

	public List<String> categoryListSmall(String param);

	public String getLastCode(MadeCategoryCodeVO codeVo);

	public List<String> categoryListDetailView(String param);

	public void insert(RefindDataVO refindVo);

	public void updateRefindInfo(RefindDataVO refindVO);

	public List<RefindDataVO> getExportData();

	public int dbInsertChk();


	public List<RefindDataVO> getRefindData();

	public void insertExcelData(Map<String, String> exportExcelParam);

	public List<CrawlInfoVO> searchList(SearchDataVO searchVO);

	public void deleteExcelData();

	public List<CrawlInfoVO> searchListCode(SearchDataVO searchVO);

	public List<CrawlInfoVO> refindList();

	public void deleteRefind();

	public List<Object> testpro(Map<String, Object> param);

}
