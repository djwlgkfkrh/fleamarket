package org.flea.persistence;

import org.flea.domain.UserVO;

public interface UserDAO {
	public void join(UserVO user) throws Exception;

	public UserVO login(UserVO user) throws Exception;

	public boolean checkId(String id) throws Exception;

	public void update(UserVO user) throws Exception;

	public void updatePw(UserVO user) throws Exception;

	public void delete(String id) throws Exception;

	public boolean checkPw(String id, String pw) throws Exception;
	
	public void addInfo(UserVO user) throws Exception;
	
	public void deposit(UserVO user) throws Exception;
	
	public int checkMoney(UserVO vo) throws Exception;
}
