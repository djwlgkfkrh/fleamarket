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
	public void update(UserVO user) throws Exception {
		// TODO Auto-generated method stub
		dao.update(user);
	}

}
