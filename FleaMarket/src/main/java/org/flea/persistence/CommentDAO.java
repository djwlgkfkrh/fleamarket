package org.flea.persistence;

import java.util.List;
import org.flea.domain.UserVO;
import org.flea.domain.BoardVO;
import org.flea.domain.CommentVO;

public interface CommentDAO {
	void addReply(CommentVO vo) throws Exception;

	List<CommentVO> commentRead(Integer boardkey) throws Exception;
	void deleteReply(Integer commentkey) throws Exception;
	void modifyReply(CommentVO vo)throws Exception;
	void replySub(CommentVO vo)throws Exception;
	public CommentVO find(Integer commentkey)  throws Exception ;
}
