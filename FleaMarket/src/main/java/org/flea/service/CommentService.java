package org.flea.service;

import java.util.List;

import org.flea.domain.BoardVO;
import org.flea.domain.CommentVO;
import org.flea.domain.UserVO;

public interface CommentService {

	void addReply(CommentVO vo) throws Exception;

	List<CommentVO> commentRead(Integer boardkey) throws Exception;

	void deleteReply(Integer commentkey) throws Exception;

	void modifyReply(CommentVO vo)throws Exception;

	void replySub(CommentVO vo)throws Exception;


	public List<CommentVO> listMy(Integer userkey) throws Exception;

	public int commentCount(Integer userkey) throws Exception;
}
