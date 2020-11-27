package kr.co.mseshop.dao.impl;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.mseshop.criteria.EventCriteria;
import kr.co.mseshop.criteria.RentalSearchCriteria;
import kr.co.mseshop.dao.FranchDao;
import kr.co.mseshop.model.FranchAdminVO;
import kr.co.mseshop.model.FranchEvtVO;
import kr.co.mseshop.model.FranchSellerVO;
import kr.co.mseshop.model.RentalVO;
import kr.co.mseshop.model.RentalVO2;
import kr.co.mseshop.model.StatisVO;

@Repository("franchDao")
public class FranchDaoImpl implements FranchDao {

	
	@Inject
	private SqlSession sqlSession;
	
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public int getCompareValue(HashMap<String, String> chkMap) {

		System.out.println("[dao]:" + chkMap.get("userID"));
		System.out.println("[dao]:" + chkMap.get("password"));
		
		int result = sqlSession.selectOne("franch.getCompareValue",chkMap);
		
		return result;
	}

	@Override
	public void addFranchInfo(HashMap<String, String> map) {
		sqlSession.insert("franch.addFranchInfo",map);
	}

	@Override
	public int compareIDChkByID(String userID) {
		return sqlSession.selectOne("franch.compareIDChkByID",userID);
	}

	@Override
	public FranchAdminVO getLimitCnt(String sellerCd) {
		return sqlSession.selectOne("franch.getLimitCnt",sellerCd);
	}

	@Override
	public int getUseCnt(HashMap<String, String> franchMap) {
		return sqlSession.selectOne("franch.getUseCnt",franchMap);
	}

	@Override
	public FranchAdminVO getPasswd(String view_num) {
		return sqlSession.selectOne("franch.getPasswd",view_num);
	}

	@Override
	public int getUseFranchInfo(HashMap<String, String> map) {
		return sqlSession.selectOne("franch.getUseFranchInfo",map);
	}

	@Override
	public List<FranchSellerVO> getFranchList() {
		return sqlSession.selectList("franch.getFranchList");
	}

	@Override
	public List<StatisVO> getStatistics() {
		return sqlSession.selectList("franch.getStatistics");
	}

	@Override
	public void addFranchSellerInfo(FranchSellerVO franchSellerVO) {
		sqlSession.insert("franch.addFranchSellerInfo", franchSellerVO);
	}

	@Override
	public FranchSellerVO getViewSellerInfo(String no) {
		return sqlSession.selectOne("franch.getViewSellerInfo",no);
	}

	@Override
	public void updateSellerInfo(FranchSellerVO franchSellerVO) {
		sqlSession.update("franch.updateSellerInfo",franchSellerVO);
	}

	@Override
	public void deleteSellerInfo(String no) {
		sqlSession.delete("franch.deleteSellerInfo",no);
	}

	@Override
	public int getUseTotalFranchInfo(String view_num) {
		return sqlSession.selectOne("franch.getUseTotalFranchInfo",view_num);
	}

	@Override
	public List<FranchSellerVO> getFranchTotalUseCntList() {
		return sqlSession.selectList("franch.getFranchTotalUseCntList");
	}

	@Override
	public List<FranchEvtVO> getFranchEvent(HashMap<String, String> dateMap) {
		return sqlSession.selectList("franch.getFranchEvent",dateMap);
	}

	@Override
	public List<FranchEvtVO> getFranchEvent() {
		return sqlSession.selectList("franch.getFranchEventList");
	}

	@Override
	public FranchEvtVO getNameByID(String id) {
		return sqlSession.selectOne("franch.getNameByID",id);
	}

	@Override
	public int getAllUsersCnt() {
		return sqlSession.selectOne("franch.getAllUsersCnt");
	}

	@Override
	public int getAllUseCnt() {
		return sqlSession.selectOne("franch.getAllUseCnt");
	}

	@Override
	public List<FranchEvtVO> getFranchDatePickerEvent(HashMap<String,String> map,RowBounds rowBounds) {
		return sqlSession.selectList("franch.getFranchDatePickerEvent",map,rowBounds);
	}

	@Override
	public int __getAllUsersCnt(HashMap<String, String> map) {
		return sqlSession.selectOne("franch.__getAllUsersCnt",map);
	}

	@Override
	public int __getAllUseCnt(HashMap<String, String> map) {
		return sqlSession.selectOne("franch.__getAllUseCnt",map);
	}

	@Override
	public int getEvtRowCount(EventCriteria criteria) {
		return sqlSession.selectOne("franch.getEvtRowCount",criteria);
	}

	@Override
	public void addRentalInfo(RentalVO rentalVO) {
		sqlSession.insert("franch.addRentalInfo",rentalVO);
	}

	@Override
	public int getRentalRowCount(RentalSearchCriteria rentalSearchCriteria) {
		return sqlSession.selectOne("franch.getRentalRowCount",rentalSearchCriteria);
	}

	@Override
	public List<RentalVO> getRentalSvcList(RentalSearchCriteria rentalSearchCriteria, RowBounds rowBounds) {
		return sqlSession.selectList("franch.getRentalSvcList",rentalSearchCriteria,rowBounds);
	}

	@Override
	public void addRentalInfo2(RentalVO2 rentalVO2) {
		sqlSession.insert("franch.addRentalInfo2",rentalVO2);
	}

	@Override
	public List<RentalVO2> getRentalSvcList2(RentalSearchCriteria rentalSearchCriteria, RowBounds rowBounds) {
		return sqlSession.selectList("franch.getRentalSvcList2",rentalSearchCriteria,rowBounds);
	}

	@Override
	public int getRentalRowCount2(RentalSearchCriteria rentalSearchCriteria) {
		return sqlSession.selectOne("franch.getRentalRowCount2",rentalSearchCriteria);
	}

	@Override
	public void addFranchTpInfo(HashMap<String, String> map) {
		sqlSession.insert("franch.addFranchTpInfo",map);
	}

	@Override
	public List<StatisVO> getTpStatistics() {
		return sqlSession.selectList("franch.getTpStatistics");
	}


}
