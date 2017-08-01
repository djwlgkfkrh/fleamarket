package org.flea.service;

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
	public boolean checkId(String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.checkId(id);
	}

	@Override
	public void update(UserVO user) throws Exception {
		// TODO Auto-generated method stub
		dao.update(user);
	}

	@Override
	public void delete(String id) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public void updatePw(UserVO user) throws Exception {
		// TODO Auto-generated method stub
		dao.updatePw(user);
	}

	@Override
	public boolean checkPw(String id, String pw) throws Exception {
		// TODO Auto-generated method stub
		return dao.checkPw(id, pw);
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

}
