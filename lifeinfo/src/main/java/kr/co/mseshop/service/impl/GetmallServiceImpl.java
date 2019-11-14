package kr.co.mseshop.service.impl;

import javax.inject.Inject;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import kr.co.mseshop.dao.GetmallDao;
import kr.co.mseshop.service.GetmallService;

@Service
public class GetmallServiceImpl implements GetmallService {

	@Inject
	GetmallDao getmallDao;

	@Override
	public int getUserchk(String userid, String cpasswd) {

		String lpasswd = "";

		lpasswd = getmallDao.getUserchk(userid);

		System.out.println("lpasswd:" + lpasswd);

		return comparePasswd(cpasswd, lpasswd);
	}

	public int comparePasswd(String cpasswd, String lpasswd) {

		if (lpasswd == null || cpasswd == null) {
			return 0;
		} else {
			if (BCrypt.checkpw(cpasswd, lpasswd)) {
				System.out.println("패스워드가 같습니다.");
				return 1;
			} else {
				return 0;
			}
		}
	}

}
