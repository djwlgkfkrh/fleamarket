package org.flea.service;

import java.util.List;

import org.flea.domain.UserVO;

public interface UserService {
	public void join(UserVO user) throws Exception;
	public UserVO login(UserVO user) throws Exception;
	public boolean checkId(String id) throws Exception;
	public boolean checkNick(String nick) throws Exception;
	public void addInfo(UserVO user) throws Exception;

	public void deposit(UserVO user) throws Exception;
	
	public int checkMoney(UserVO vo) throws Exception ;
	public UserVO find(Integer userkey)  throws Exception;
	public boolean checkBoard(Integer boardkey) throws Exception;
}
