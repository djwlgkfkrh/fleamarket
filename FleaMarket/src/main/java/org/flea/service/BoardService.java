package org.flea.service;

import java.util.List;

import org.flea.domain.BoardVO;
import org.flea.domain.CartVO;
import org.flea.domain.SearchCriteria;
import org.flea.domain.UserVO;

public interface BoardService {

	public BoardVO read(Integer boardkey) throws Exception; // viewcnt update,
															// and read page

	public List<BoardVO> listMy(Integer userkey) throws Exception;

	public int listCount(Integer userkey) throws Exception;

	public UserVO find(Integer userkey) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;

	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception;

	// sale board
	public void createSale(Integer boardkey) throws Exception;

	public List<BoardVO> salelistSearchCriteria(SearchCriteria cri) throws Exception;

	public int salelistSearchCount(SearchCriteria cri) throws Exception;

	// buy board
	public void createBuy(Integer boardkey) throws Exception;

	public List<BoardVO> buylistSearchCriteria(SearchCriteria cri) throws Exception;

	public int buylistSearchCount(SearchCriteria cri) throws Exception;

	public int before(Integer boardkey) throws Exception;

	public int after(Integer boardkey) throws Exception;

	public void complete(Integer boardkey) throws Exception;

	public void putcart(CartVO vo) throws Exception;

	public int getcart(Integer boardkey, Integer userkey) throws Exception;

	public void dealcart(Integer boardkey, Integer userkey) throws Exception;

	public List<CartVO> listCart(Integer userkey) throws Exception;

	public List<BoardVO> listAll() throws Exception;

	public void createPost(BoardVO bvo) throws Exception;

	public int getboardKey(BoardVO bvo) throws Exception;

	public void deleteBoard(Integer boardkey) throws Exception;

	public void deleteBuy(Integer boardkey) throws Exception;

	public void deleteSale(Integer boardkey) throws Exception;

	public void modifyBoard(BoardVO bvo) throws Exception;

	public int getSaleState(Integer boardkey) throws Exception;

	public int getBuyState(Integer boardkey) throws Exception;

	public List<BoardVO> popular() throws Exception;
	
	public void changeBoardState(Integer boardkey) throws Exception;

}
