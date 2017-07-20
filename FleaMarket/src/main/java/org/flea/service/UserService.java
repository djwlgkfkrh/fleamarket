package org.flea.service;

import java.util.List;

import org.flea.domain.UserVO;

public interface UserService {
	public void join(UserVO user) throws Exception;
	public UserVO login(UserVO user) throws Exception;
	public void update(UserVO user) throws Exception;
}
