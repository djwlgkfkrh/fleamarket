package org.flea.persistence;

import java.util.List;

import org.flea.domain.BoardVO;
import org.flea.domain.CartVO;
import org.flea.domain.SearchCriteria;
import org.flea.domain.UserVO;

public interface BoardDAO {

	public void updateViewCnt(Integer boardkey) throws Exception;

	public UserVO find(Integer userkey) throws Exception;

	public BoardVO read(Integer boardkey) throws Exception; // ±Û ÀÐ±â

	public int listSearchCount(SearchCriteria cri) throws Exception;

	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception;

	public int before(Integer boardkey) throws Exception;

	public int after(Integer boardkey) throws Exception;

	public void putcart(CartVO vo) throws Exception;

	public int getcart(Integer boardkey, Integer userkey) throws Exception;

	public void dealcart(Integer boardkey, Integer userkey) throws Exception;
	
	public List<CartVO> listCart(Integer userkey) throws Exception;
	
	public List<BoardVO> listAll() throws Exception;
	public List<BoardVO> popular()throws Exception;
}
