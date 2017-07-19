package org.flea.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.flea.domain.UserVO;
import org.springframework.stereotype.Repository;
@Repository
public class UserDAOImpl implements UserDAO {
	 @Inject
	  private SqlSession session;

	  private static String namespace = "org.flea.mappers.UserMapper";

	@Override
	public void join(UserVO user) throws Exception {
		// TODO Auto-generated method stub
		 session.insert(namespace + ".join", user);
	}

	@Override
	public UserVO login(UserVO user) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".login",user);
	}

}
