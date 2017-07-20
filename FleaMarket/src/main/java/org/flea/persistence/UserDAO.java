package org.flea.persistence;

import java.util.List;

import org.flea.domain.UserVO;

public interface UserDAO {
	public void join(UserVO user) throws Exception;
	public UserVO login(UserVO user) throws Exception;
	public void update(UserVO user) throws Exception;
	}

