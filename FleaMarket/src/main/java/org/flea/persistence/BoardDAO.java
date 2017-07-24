package org.flea.persistence;

import java.util.List;

import org.flea.domain.BoardVO;
import org.flea.domain.SearchCriteria;

public interface BoardDAO {
	
	public void updateViewCnt(Integer boardkey) throws Exception;
	
	

	public BoardVO read(Integer boardkey) throws Exception; //�� �б�
	public List<BoardVO> listMy(Integer userkey) throws Exception; 
	public int listCount(Integer userkey) throws Exception; 

	public int listSearchCount(SearchCriteria cri)throws Exception;
	 public List<BoardVO> listSearch(SearchCriteria cri)throws Exception;
}
