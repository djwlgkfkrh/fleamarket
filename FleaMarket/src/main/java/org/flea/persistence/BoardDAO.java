package org.flea.persistence;

import java.util.List;

import org.flea.domain.BoardVO;
import org.flea.domain.SearchCriteria;

public interface BoardDAO {
	
	public void updateViewCnt(Integer boardkey) throws Exception;
	
	

	public BoardVO read(Integer boardkey) throws Exception; //±Û ÀÐ±â

	public int listSearchCount(SearchCriteria cri)throws Exception;
	 public List<BoardVO> listSearch(SearchCriteria cri)throws Exception;
}
