package org.flea.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.flea.domain.BoardVO;
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
	public List<BoardVO> listMy(Integer userkey) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".listMy", userkey);
	}

	@Override
	public int listCount(Integer userkey) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".listCount", userkey);

	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".listSearchCount", cri);
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
	public void updateCommentCnt(Integer boardkey, int amount) throws Exception {
		// TODO Auto-generated method stub
		 Map<String, Object> paramMap = new HashMap<String, Object>();

		    paramMap.put("boardkey", boardkey);
		    paramMap.put("amount", amount);

		    session.update(namespace + ".updateCommentCnt", paramMap);
	}

	@Override
	public void complete(Integer boardkey) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace + ".complete",boardkey);
	}

	
}
