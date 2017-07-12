package org.flea.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.flea.domain.MemberVO;
import org.springframework.stereotype.Repository;
@Repository
public class MemberDAOImpl implements MemberDAO {
	 @Inject
	  private SqlSession session;

	  private static String namespace = "org.flea.mappers.MemberMapper";

	@Override
	public void join(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		 session.insert(namespace + ".join", member);
	}

}
