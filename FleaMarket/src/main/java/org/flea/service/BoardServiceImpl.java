package org.flea.service;


import org.springframework.stereotype.Service;
import org.flea.domain.BoardVO;
import org.flea.domain.SearchCriteria;
import org.flea.persistence.BoardDAO;

import java.util.List;

import javax.inject.Inject;


@Service
public class BoardServiceImpl implements BoardService{
//sdf
	@Inject
	private BoardDAO dao;
	
	@Override
	public BoardVO read(Integer boardkey) throws Exception {
		// TODO Auto-generated method stub
		dao.updateViewCnt(boardkey);
		return dao.read(boardkey);
		
	}
	

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listSearchCount(cri);
	}
	
	@Override
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception {

		return dao.listSearch(cri);
	}

}
