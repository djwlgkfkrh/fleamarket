package org.flea.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public DealVO read(Integer dealkey) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".read", dealkey);
	}

	@Override
	public List<DealVO> getDeal(Integer userkey) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".getDealList", userkey);
	}

	@Override
	public int checkMoney(String dealkey, String money) throws Exception {
		// TODO Auto-generated method stub
		 Map<String, String> map = new HashMap<String, String>();
	        map.put("dealkey", dealkey);
	        map.put("money", money);
	        int count = session.selectOne(namespace+".checkMoney", map);
	        return count;
	}

	@Override
	public void remitMoney(Integer dealkey,Integer money) throws Exception {
		// TODO Auto-generated method stub
		 Map<String, Integer> map = new HashMap<String, Integer>();
	        map.put("dealkey", dealkey);
	        map.put("money", money);
		session.update(namespace+".remitMoney", map);
	}

	@Override
	public void updateDelivery(DealVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace+".update",vo);
	}

	@Override
	public void complete(Integer dealkey) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace+".complete",dealkey);
	}

	
}
