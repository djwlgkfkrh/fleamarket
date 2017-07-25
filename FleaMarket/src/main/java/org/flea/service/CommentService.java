package org.flea.service;

import java.util.List;

import org.flea.domain.CommentVO;

public interface CommentService {

	void addReply(CommentVO vo) throws Exception;

	List<CommentVO> commentRead(int boardkey) throws Exception;

	public List<CommentVO> listMy(Integer userkey) throws Exception;

	public int commentCount(Integer userkey) throws Exception;
}
