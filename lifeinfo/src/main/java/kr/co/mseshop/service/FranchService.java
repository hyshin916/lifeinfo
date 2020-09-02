package kr.co.mseshop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;

import kr.co.mseshop.criteria.EventCriteria;
import kr.co.mseshop.criteria.RentalSearchCriteria;
import kr.co.mseshop.model.FranchAdminVO;
import kr.co.mseshop.model.FranchEvtVO;
import kr.co.mseshop.model.FranchSellerVO;
import kr.co.mseshop.model.RentalVO;
import kr.co.mseshop.model.StatisVO;

public interface FranchService {

	int compareIDChk(String userID, String userPassword);

	void addFranchInfo(String userID, String franch);

	int compareIDChkByID(String userID);

	FranchAdminVO getLimitCnt(String sellerCd);

	int getUseCnt(HashMap<String, String> franchMap);

	FranchAdminVO getPasswd(String view_num);

	int getUseFranchInfo(String userID, String view_num);

	List<FranchSellerVO> getFranchList();

	List<StatisVO> getStatistics();

	void addFranchSellerInfo(FranchSellerVO franchSellerVO);

	FranchSellerVO getViewSellerInfo(String no);

	void updateSellerInfo(FranchSellerVO franchSellerVO);

	void deleteSellerInfo(String no);

	int getUseTotalFranchInfo(String view_num);

	List<FranchSellerVO> getFranchTotalUseCntList();

	List<FranchEvtVO> getFranchEvent();

	List<FranchEvtVO> getFranchEvent(String startDate, String endDate);

	List<FranchEvtVO> getFranchSuggestList(ArrayList<String> suggestEvt);

	int getAllUsersCnt();

	int getAllUseCnt();

	List<FranchEvtVO> getFranchDatePickerEvent(String startDate, String endDate, RowBounds rowBounds);

	int __getAllUsersCnt(String startDate, String endDate);

	int __getAllUseCnt(String startDate, String endDate);

	int getEvtRowCount(EventCriteria criteria);

	void addRentalInfo(RentalVO rentalVO);

	int getRentalRowCount(RentalSearchCriteria rentalSearchCriteria);

	List<RentalVO> getRentalSvcList(RentalSearchCriteria rentalSearchCriteria, RowBounds rowBounds);


	
}
