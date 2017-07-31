package org.flea.persistence;

import java.util.List;

import org.flea.domain.BoardVO;
import org.flea.domain.SearchCriteria;
import org.flea.domain.UserVO;

public interface BoardDAO {

	public void updateViewCnt(Integer boardkey) throws Exception;

	public UserVO find(Integer userkey) throws Exception;

	public BoardVO read(Integer boardkey) throws Exception; // �� �б�

	public List<BoardVO> listMy(Integer userkey) throws Exception;

	public int listCount(Integer userkey) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;

	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception;

	public int before(Integer boardkey) throws Exception;

	public int after(Integer boardkey) throws Exception;

	public void createPost(BoardVO vo) throws Exception;
	
	public int getboardKey(BoardVO vo) throws Exception;
	
	public void deleteBoard(Integer boardkey) throws Exception;
	
	public void modifyBoard(BoardVO vo) throws Exception;
	
	
}
