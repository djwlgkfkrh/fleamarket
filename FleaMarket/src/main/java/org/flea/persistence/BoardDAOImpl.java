package org.flea.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
// import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import org.flea.domain.BoardVO;
import org.flea.domain.SearchCriteria;

import javax.inject.Inject;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.session.SqlSession;



@Repository
public class BoardDAOImpl implements BoardDAO{
	@Inject
	private SqlSession session;
	

	private static String namespace = "org.flea.mappers.BoardMapper";
	
	  @Override
	  public void updateViewCnt(Integer boardkey) throws Exception {
		  session.update(namespace+".updateViewCnt", boardkey);
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
	  public List<BoardVO> listSearch(SearchCriteria cri) throws Exception {

	    return session.selectList(namespace + ".listSearch", cri);
	  }

}
