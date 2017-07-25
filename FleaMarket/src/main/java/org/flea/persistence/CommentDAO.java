package org.flea.persistence;

import java.util.List;

import org.flea.domain.CommentVO;


public interface CommentDAO {
	void addReply(CommentVO vo) throws Exception;

	 List<CommentVO> commentRead(int boardkey) throws Exception;

}
