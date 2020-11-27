package kr.co.mseshop.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import kr.co.mseshop.criteria.EventCriteria;
import kr.co.mseshop.criteria.RentalSearchCriteria;
import kr.co.mseshop.dao.FranchDao;
import kr.co.mseshop.model.FranchAdminVO;
import kr.co.mseshop.model.FranchEvtVO;
import kr.co.mseshop.model.FranchSellerVO;
import kr.co.mseshop.model.RentalVO;
import kr.co.mseshop.model.RentalVO2;
import kr.co.mseshop.model.StatisVO;
import kr.co.mseshop.service.FranchService;

@Service("franchService")
public class FranchServiceImpl implements FranchService {

	
	@Inject
	FranchDao franchDao;
	
	
	@Override
	public int compareIDChk(String userID, String userPassword) {
		
		
		HashMap<String,String> chkMap = new HashMap<String,String>();
		chkMap.put("userID", userID);
		chkMap.put("password",userPassword);
		
		int result = franchDao.getCompareValue(chkMap);
		
		return result;
	}


	@Override
	public void addFranchInfo(String userID, String franch) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.format(date);
		
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("id", userID);
		map.put("sellerCd", franch);
		map.put("date", sdf.format(date));
		
		franchDao.addFranchInfo(map);
		
	}


	@Override
	public int compareIDChkByID(String userID) {
		
		int result = franchDao.compareIDChkByID(userID);
		return result;
	}


	@Override
	public FranchAdminVO getLimitCnt(String sellerCd) {
		return franchDao.getLimitCnt(sellerCd);
	}


	@Override
	public int getUseCnt(HashMap<String, String> franchMap) {
		return franchDao.getUseCnt(franchMap);
	}


	@Override
	public FranchAdminVO getPasswd(String view_num) {
		return franchDao.getPasswd(view_num);
	}


	@Override
	public int getUseFranchInfo(String userID, String view_num) {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("id", userID);
		map.put("sellerCd", view_num);
		
		if (view_num.equals("2426")) {
			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			map.put("date", df.format(date));
//			map.put("date", "2020-08-10");
			int cnt = franchDao.getUseFranchInfo(map);
			if (cnt > 0) {
				cnt = 3;
			}
			return cnt;
		} else {
			return franchDao.getUseFranchInfo(map);
		}
	}


	@Override
	public List<FranchSellerVO> getFranchList() {
		return franchDao.getFranchList();
	}


	@Override
	public List<StatisVO> getStatistics(String eventFlag) {
		
		if (String.valueOf(eventFlag)!="null") {
			return franchDao.getTpStatistics();
		} else {
			return franchDao.getStatistics();
		}
		
	}


	@Override
	public void addFranchSellerInfo(FranchSellerVO franchSellerVO) {
		franchDao.addFranchSellerInfo(franchSellerVO);
	}


	@Override
	public FranchSellerVO getViewSellerInfo(String no) {
		return franchDao.getViewSellerInfo(no);
	}


	@Override
	public void updateSellerInfo(FranchSellerVO franchSellerVO) {
		franchDao.updateSellerInfo(franchSellerVO);
	}


	@Override
	public void deleteSellerInfo(String no) {
		franchDao.deleteSellerInfo(no);
	}


	@Override
	public int getUseTotalFranchInfo(String view_num) {
		return franchDao.getUseTotalFranchInfo(view_num);
	}


	@Override
	public List<FranchSellerVO> getFranchTotalUseCntList() {
		return franchDao.getFranchTotalUseCntList();
	}


	@Override
	public List<FranchEvtVO> getFranchEvent(String startDate, String endDate) {
		HashMap<String,String> dateMap = new HashMap<String,String>();
		dateMap.put("startDate", startDate);
		dateMap.put("endDate", endDate);
		
		return franchDao.getFranchEvent(dateMap);
	}


	@Override
	public List<FranchEvtVO> getFranchEvent() {
		return franchDao.getFranchEvent();
	}


	@Override
	public List<FranchEvtVO> getFranchSuggestList(ArrayList<String> suggestEvt) {
		List<FranchEvtVO> nameIDList = new ArrayList<FranchEvtVO>();
		for (String id : suggestEvt) {
			System.out.println("[Flist]" + (FranchEvtVO)franchDao.getNameByID(id));
			nameIDList.add((FranchEvtVO)franchDao.getNameByID(id));
		}
		
		return nameIDList;
	}


	@Override
	public int getAllUsersCnt() {
		return franchDao.getAllUsersCnt();
	}


	@Override
	public int getAllUseCnt() {
		return franchDao.getAllUseCnt();
	}


	@Override
	public List<FranchEvtVO> getFranchDatePickerEvent(String startDate, String endDate,RowBounds rowBounds) {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		return franchDao.getFranchDatePickerEvent(map,rowBounds);
	}


	@Override
	public int __getAllUsersCnt(String startDate, String endDate) {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		
		return franchDao.__getAllUsersCnt(map);
	}


	@Override
	public int __getAllUseCnt(String startDate, String endDate) {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		return franchDao.__getAllUseCnt(map);
	}


	@Override
	public int getEvtRowCount(EventCriteria criteria) {
		return franchDao.getEvtRowCount(criteria);
	}


	@Override
	public void addRentalInfo(RentalVO rentalVO) {
		franchDao.addRentalInfo(rentalVO);
	}


	@Override
	public int getRentalRowCount(RentalSearchCriteria rentalSearchCriteria) {
		return franchDao.getRentalRowCount(rentalSearchCriteria);
	}


	@Override
	public List<RentalVO> getRentalSvcList(RentalSearchCriteria rentalSearchCriteria, RowBounds rowBounds) {
		return franchDao.getRentalSvcList(rentalSearchCriteria,rowBounds);
	}


	@Override
	public void addRentalInfo2(RentalVO2 rentalVO2) {
		franchDao.addRentalInfo2(rentalVO2);
	}


	@Override
	public List<RentalVO2> getRentalSvcList2(RentalSearchCriteria rentalSearchCriteria, RowBounds rowBounds) {
		return franchDao.getRentalSvcList2(rentalSearchCriteria,rowBounds);
	}


	@Override
	public int getRentalRowCount2(RentalSearchCriteria rentalSearchCriteria) {
		return franchDao.getRentalRowCount2(rentalSearchCriteria);
	}


	@Override
	public void addFranchTpInfo(String userID, String franch, String eventNm) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.format(date);
		
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("id", userID);
		map.put("sellerCd", franch);
		map.put("date", sdf.format(date));
		map.put("eventNm", eventNm);
		
		franchDao.addFranchTpInfo(map);
	}

	
}
