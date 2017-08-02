package org.flea.persistence;

import java.util.List;

import org.flea.domain.BoardVO;
import org.flea.domain.SearchCriteria;
import org.flea.domain.UserVO;

public interface BoardDAO {

	public void updateViewCnt(Integer boardkey) throws Exception;

	public UserVO find(Integer userkey) throws Exception;

	public BoardVO read(Integer boardkey) throws Exception;

	public List<BoardVO> listMy(Integer userkey) throws Exception;

	public int listCount(Integer userkey) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;

	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception;

	public int before(Integer boardkey) throws Exception;

	public int after(Integer boardkey) throws Exception;
	
	public void updateCommentCnt(Integer boardkey, int amount)throws Exception;
	
	public void complete(Integer boardkey) throws Exception;
}
