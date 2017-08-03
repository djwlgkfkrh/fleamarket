package org.flea.persistence;

import java.util.List;

import org.flea.domain.BoardVO;
import org.flea.domain.CartVO;
import org.flea.domain.SearchCriteria;
import org.flea.domain.UserVO;

public interface BoardDAO {

	public void updateViewCnt(Integer boardkey) throws Exception;

	public UserVO find(Integer userkey) throws Exception;

	public BoardVO read(Integer boardkey) throws Exception; // �� �б�

	public List<BoardVO> listMy(Integer userkey) throws Exception;

	public int listCount(Integer userkey) throws Exception;

	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;

	// sale Board, saleList
	public void createSale(Integer boardkey) throws Exception;

	public List<BoardVO> salelistSearch(SearchCriteria cri) throws Exception;

	public int salelistSearchCount(SearchCriteria cri) throws Exception;

	// buy Board , buyList
	public void createBuy(Integer boardkey) throws Exception;

	public List<BoardVO> buylistSearch(SearchCriteria cri) throws Exception;

	public int buylistSearchCount(SearchCriteria cri) throws Exception;

	public int before(Integer boardkey) throws Exception;

	public int after(Integer boardkey) throws Exception;

	public void createPost(BoardVO vo) throws Exception;

	public int getboardKey(BoardVO vo) throws Exception;

	public void deleteBoard(Integer boardkey) throws Exception;

	public void deleteBuy(Integer boardkey) throws Exception;

	public void deleteSale(Integer boardkey) throws Exception;

	public void modifyBoard(BoardVO vo) throws Exception;

	public int getSaleState(Integer boardkey) throws Exception;

	public int getBuyState(Integer boardkey) throws Exception;

	public void updateCommentCnt(Integer boardkey, int amount)throws Exception;
	
	public void complete(Integer boardkey) throws Exception;

	public void putcart(CartVO vo) throws Exception;

	public int getcart(Integer boardkey, Integer userkey) throws Exception;

	public void dealcart(Integer boardkey, Integer userkey) throws Exception;

}
