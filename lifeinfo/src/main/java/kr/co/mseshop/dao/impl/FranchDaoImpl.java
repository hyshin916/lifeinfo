package kr.co.mseshop.dao.impl;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.mseshop.criteria.EventCriteria;
import kr.co.mseshop.dao.FranchDao;
import kr.co.mseshop.model.FranchAdminVO;
import kr.co.mseshop.model.FranchEvtVO;
import kr.co.mseshop.model.FranchSellerVO;
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
	public List<FranchEvtVO> getFranchEvent(HashMap<String, String> dateMap,RowBounds rowBounds) {
		return sqlSession.selectList("franch.getFranchEvent",dateMap,rowBounds);
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


}