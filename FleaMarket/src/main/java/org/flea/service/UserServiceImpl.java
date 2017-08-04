package org.flea.service;

import java.util.List;

import javax.inject.Inject;

import org.flea.domain.UserVO;
import org.flea.persistence.UserDAO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Inject
	private UserDAO dao;

	@Override
	public void join(UserVO user) throws Exception {
		// TODO Auto-generated method stub
		dao.join(user);
	}

	@Override
	public UserVO login(UserVO user) throws Exception {
		// TODO Auto-generated method stub
		return dao.login(user);
	}
	@Override
	public void addInfo(UserVO user) throws Exception {
		// TODO Auto-generated method stub
		dao.addInfo(user);
	}
	
	@Override
	public void deposit(UserVO user) throws Exception {
		// TODO Auto-generated method stub
		dao.deposit(user);
	}

	@Override
	public int checkMoney(UserVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.checkMoney(vo);
	}

	@Override
	   public UserVO find(Integer userkey) throws Exception {
	      // TODO Auto-generated method stub
	      return dao.find(userkey);
	   }
}
