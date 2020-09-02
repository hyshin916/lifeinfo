package kr.co.mseshop.dao;

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

public interface FranchDao {

	int getCompareValue(HashMap<String, String> chkMap);

	void addFranchInfo(HashMap<String, String> map);

	int compareIDChkByID(String userID);

	FranchAdminVO getLimitCnt(String sellerCd);

	int getUseCnt(HashMap<String, String> franchMap);

	FranchAdminVO getPasswd(String view_num);

	int getUseFranchInfo(HashMap<String, String> map);

	List<FranchSellerVO> getFranchList();

	List<StatisVO> getStatistics();

	void addFranchSellerInfo(FranchSellerVO franchSellerVO);

	FranchSellerVO getViewSellerInfo(String no);

	void updateSellerInfo(FranchSellerVO franchSellerVO);

	void deleteSellerInfo(String no);

	int getUseTotalFranchInfo(String view_num);

	List<FranchSellerVO> getFranchTotalUseCntList();

	List<FranchEvtVO> getFranchEvent();

	List<FranchEvtVO> getFranchEvent(HashMap<String, String> dateMap);

	FranchEvtVO getNameByID(String id);

	int getAllUsersCnt();

	int getAllUseCnt();

	List<FranchEvtVO> getFranchDatePickerEvent(HashMap<String,String> map, RowBounds rowBounds);

	int __getAllUsersCnt(HashMap<String, String> map);

	int __getAllUseCnt(HashMap<String, String> map);

	int getEvtRowCount(EventCriteria criteria);

	void addRentalInfo(RentalVO rentalVO);

	int getRentalRowCount(RentalSearchCriteria rentalSearchCriteria);

	List<RentalVO> getRentalSvcList(RentalSearchCriteria rentalSearchCriteria, RowBounds rowBounds);

}
