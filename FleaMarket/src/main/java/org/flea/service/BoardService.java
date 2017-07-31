package org.flea.service;

import java.util.List;

import org.flea.domain.BoardVO;
import org.flea.domain.SearchCriteria;
import org.flea.domain.UserVO;

public interface BoardService {

	
	public BoardVO read(Integer boardkey) throws Exception; // viewcnt update, and read page
	public List<BoardVO> listMy(Integer userkey) throws Exception; 
	public int listCount(Integer userkey) throws Exception; 

	public UserVO find(Integer userkey) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;

	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception;

	public int before(Integer boardkey) throws Exception;

	public int after(Integer boardkey) throws Exception;
	
	public void createPost(BoardVO bvo) throws Exception;
	
	public int getboardKey(BoardVO bvo) throws Exception;
	
	public void deleteBoard(Integer boardkey) throws Exception;
	
	public void modifyBoard(BoardVO bvo) throws Exception;

}
