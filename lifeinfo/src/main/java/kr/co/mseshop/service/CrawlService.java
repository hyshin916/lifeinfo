package kr.co.mseshop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.mseshop.model.CategoryCodeVO;
import kr.co.mseshop.model.ColorInfo;
import kr.co.mseshop.model.CrawlInfoVO;
import kr.co.mseshop.model.MadeCategoryCodeVO;
import kr.co.mseshop.model.RefindDataVO;
import kr.co.mseshop.model.SearchDataVO;

public interface CrawlService {
	public List<CrawlInfoVO> list();

	public List<String> getViewlist(String no);
/*	public List<String> viewList(CrawlInfoVO lists);
	public List<ColorInfo> colorList(CrawlInfoVO lists);*/

	public List<String> codeList();

	public List<String> categoryList(String param);

	public List<String> categoryListSmall(String param);

	public String getLastCode(MadeCategoryCodeVO codeVo);

	public List<String> categoryListDetailView(String param);

	public void updateRefindInfo(RefindDataVO refindVO);

	public List<RefindDataVO> getExportData();

	public void madeExcelData(Map<String, String> exportExcelParam);

	public List<RefindDataVO> getRefindData();

	public List<CrawlInfoVO> searchList(SearchDataVO searchVO);

	public void deleteExcelData();

	public List<CrawlInfoVO> searchListCode(SearchDataVO searchVO);

	public void refinddata();

	public List<Object> testpro(Map<String, Object> param);

}
