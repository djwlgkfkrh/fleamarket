package org.flea.persistence;

import java.util.List;

import org.flea.domain.CommentVO;

public interface CommentDAO {
	void addReply(CommentVO vo) throws Exception;


	public List<CommentVO> listMy(Integer userkey) throws Exception;

	public int commentCount(Integer userkey) throws Exception;
	List<CommentVO> commentRead(Integer boardkey) throws Exception;
	void deleteReply(CommentVO vo) throws Exception;

}
