package org.flea.service;

import java.util.List;

import org.flea.domain.BoardVO;
import org.flea.domain.CommentVO;
import org.flea.domain.UserVO;

public interface CommentService {

	void addReply(CommentVO vo)  throws Exception;

	List<CommentVO> commentRead(Integer boardkey) throws Exception;

	void deleteReply(CommentVO vo) throws Exception;

}
