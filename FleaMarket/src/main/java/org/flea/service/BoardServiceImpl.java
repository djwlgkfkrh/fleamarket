package org.flea.service;


import org.springframework.stereotype.Service;
import org.flea.domain.BoardVO;
import org.flea.persistence.BoardDAO;

import javax.inject.Inject;


@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDAO dao;
	
	
	
	@Override
	public void create(BoardVO vo) throws Exception {
		
		dao.create(vo);
		
	}



	@Override
	public void delete(BoardVO vo) throws Exception {
	
		dao.delete(vo);
		
	}



	@Override
	public void read(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.read(vo);
	}

}
