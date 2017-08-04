package org.flea.service;

import org.springframework.stereotype.Service;
import org.flea.domain.BoardVO;
import org.flea.domain.CartVO;
import org.flea.domain.CommentVO;
import org.flea.domain.SearchCriteria;
import org.flea.domain.UserVO;
import org.flea.persistence.BoardDAO;

import java.util.List;

import javax.inject.Inject;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;

	@Override
	public BoardVO read(Integer boardkey) throws Exception {
		// TODO Auto-generated method stub
		dao.updateViewCnt(boardkey);

		return dao.read(boardkey);
	}

	@Override
	public UserVO find(Integer userkey) throws Exception {
		// TODO Auto-generated method stub
		return dao.find(userkey);
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

	@Override
	public int before(Integer boardkey) throws Exception {
		// TODO Auto-generated method stub
		return dao.before(boardkey);
	}

	@Override
	public int after(Integer boardkey) throws Exception {
		// TODO Auto-generated method stub
		return dao.after(boardkey);
	}

	@Override
	public void putcart(CartVO vo) throws Exception {
		// TODO Auto-generated method stub
		 dao.putcart(vo);
	}

	@Override
	public int getcart(Integer boardkey,Integer userkey) throws Exception {
		// TODO Auto-generated method stub
		return  dao.getcart(boardkey,userkey);
	}

	@Override
	public void dealcart(Integer boardkey, Integer userkey) throws Exception {
		// TODO Auto-generated method stub
		dao.dealcart(boardkey,userkey);
	}

	@Override
	public List<CartVO> listCart(Integer userkey) throws Exception {
		// TODO Auto-generated method stub
		return dao.listCart(userkey);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.listAll();
	}

	@Override
	public List<BoardVO> popular() throws Exception {
		// TODO Auto-generated method stub
		return dao.popular();
	}
	

}
