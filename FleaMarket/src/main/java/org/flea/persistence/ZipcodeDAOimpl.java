package org.flea.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.flea.domain.ZipcodeVO;
import org.springframework.stereotype.Repository;
@Repository
public class ZipcodeDAOimpl implements ZipcodeDAO {
	
	@Inject
	private SqlSession session;

	private static String namespace = "org.flea.mappers.ZipcodeMapper";

	@Override
	public List<ZipcodeVO> readZip(String dong) throws Exception {
		
		return session.selectList(namespace + ".readZip", dong);

	}

}
