package org.flea.persistence;

import java.util.List;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

	@Override
	public void update(UserVO user) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace+".update",user);
	}

	@Override
	public void delete(String id) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace+".delete",id);
	}

	@Override
	public void updatePw(UserVO user) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace+".updatePw",user);
	}

	@Override
	public boolean checkPw(String mid, String mpw) throws Exception {
		 boolean result = false;
	        Map<String, String> map = new HashMap<String, String>();
	        map.put("mid", mid);
	        map.put("mpw", mpw);
	        int count = session.selectOne(namespace+".checkPw", map);
	        if(count == 1) result= true;
	        return result;
	}

}
