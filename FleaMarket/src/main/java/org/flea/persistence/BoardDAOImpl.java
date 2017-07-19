package org.flea.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
// import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import org.flea.domain.BoardVO;
import javax.inject.Inject;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.session.SqlSession;



@Repository
public class BoardDAOImpl implements BoardDAO{
	
	
	@Inject
	private SqlSession session;
	
	
	private static String namespace = "com.ex.Mapper.BoardMapper";
	
	

	@Override
	public void read(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace + ".read", vo);
		
	}

	@Override
	public void create(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace + ".create", vo);
		
	}

	@Override
	public void modify(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
