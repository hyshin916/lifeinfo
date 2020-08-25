package kr.co.mseshop.back.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.mseshop.back.dao.ActionLogDao;
import kr.co.mseshop.back.service.LogService;
import kr.co.mseshop.model.ActionLogVO;

@Service("logService")
public class LogServiceImpl implements LogService {

	@Resource
	ActionLogDao actionLogDao;
	
	@Override
	public void actionLog(ActionLogVO actionLogVO) {
		actionLogDao.addActionLog(actionLogVO);
	}

}
