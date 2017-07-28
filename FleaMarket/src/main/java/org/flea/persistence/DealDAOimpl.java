package org.flea.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.flea.domain.DealVO;
import org.springframework.stereotype.Repository;

@Repository
public class DealDAOimpl implements DealDAO {
	@Inject
	private SqlSession session;

	private static String namespace = "org.flea.mappers.DealMapper";

	@Override
	public void createDeal(DealVO vo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<DealVO> getDeal(Integer userkey) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".getDealList", userkey);
	}

}
