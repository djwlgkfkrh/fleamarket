package org.flea.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.flea.domain.MemberVO;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOimpl implements MemberDAO {
	 @Inject
	  private SqlSession session;

	  private static String namespace = "org.flea.mappers.memberMapper";
	@Override
	public void create(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace + ".create", vo);
	}

}
