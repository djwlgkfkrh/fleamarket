package org.flea.persistence;

import java.util.List;

import org.flea.domain.UserVO;

public interface UserDAO {
	public void join(UserVO user) throws Exception;
	public UserVO login(UserVO user) throws Exception;
	public void addInfo(UserVO user) throws Exception;

	public void deposit(UserVO user) throws Exception;

	public int checkMoney(UserVO vo) throws Exception;

	public UserVO find(Integer userkey) throws Exception;
	}

