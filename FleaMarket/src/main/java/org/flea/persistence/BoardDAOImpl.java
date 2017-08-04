package org.flea.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.flea.domain.BoardVO;
import org.flea.domain.CartVO;
import org.flea.domain.SearchCriteria;
import org.flea.domain.UserVO;
// import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {
	@Inject
	private SqlSession session;

	private static String namespace = "org.flea.mappers.BoardMapper";

	@Override
	public void updateViewCnt(Integer boardkey) throws Exception {
		session.update(namespace + ".updateViewCnt", boardkey);
	}

	@Override
	public UserVO find(Integer userkey) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".find", userkey);
	}

	@Override
	public BoardVO read(Integer boardkey) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".read", boardkey);

	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".listSearchCount", cri);
	}

	@Override
	public void complete(Integer boardkey) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace + ".complete",boardkey);
	}

	@Override
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception {

		return session.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int before(Integer boardkey) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".before", boardkey);
	}

	@Override
	public int after(Integer boardkey) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".after", boardkey);
	}

	@Override
	public void putcart(CartVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		 session.insert(namespace + ".putcart", vo);
	}

	@Override
	public int getcart(Integer boardkey,Integer userkey) throws Exception {
		// TODO Auto-generated method stub
		   Map<String, Integer> map = new HashMap<String, Integer>();
           map.put("boardkey", boardkey);
           map.put("userkey", userkey);
           
		return session.selectOne(namespace + ".getcart", map);
	}

	@Override
	public void dealcart(Integer boardkey, Integer userkey) throws Exception {
		// TODO Auto-generated method stub
		 Map<String, Integer> map = new HashMap<String, Integer>();
         map.put("boardkey", boardkey);
         map.put("userkey", userkey);
		session.delete(namespace + ".dealcart", map);
	}

	@Override
	public List<CartVO> listCart(Integer userkey) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".listCart", userkey);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".listAll");
	}

	@Override
	public List<BoardVO> popular() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".popular");
	}
	

}
