package org.flea.service;

import java.util.List;

import org.flea.domain.BoardVO;
import org.flea.domain.CommentVO;
import org.flea.domain.SearchCriteria;

public interface BoardService {
	
	public BoardVO read(Integer boardkey) throws Exception; // viewcnt update, and read page

	public int listSearchCount(SearchCriteria cri) throws Exception;
	 public List<BoardVO> listSearchCriteria(SearchCriteria cri) 
		      throws Exception;

	
}
