package org.flea.persistence;

import java.util.List;
import org.flea.domain.UserVO;
import org.flea.domain.BoardVO;
import org.flea.domain.CommentVO;

public interface CommentDAO {
	void addReply(CommentVO vo) throws Exception;

	List<CommentVO> commentRead(Integer boardkey) throws Exception;
	void deleteReply(Integer commentkey) throws Exception;
}
