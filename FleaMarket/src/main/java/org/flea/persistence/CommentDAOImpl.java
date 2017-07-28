package org.flea.persistence;


import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.flea.domain.BoardVO;
import org.flea.domain.CommentVO;
import org.flea.domain.UserVO;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAOImpl implements CommentDAO {
	@Inject
	private SqlSession session;

	private static String namespace = "org.flea.mappers.CommentMapper";

	@Override
	public void addReply(CommentVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace + ".addReply", vo);
	}

	@Override
	public List<CommentVO> commentRead(Integer boardkey) throws Exception {
		// TODO Auto-generated method stub
		
		return session.selectList(namespace + ".commentRead", boardkey);
		
		
	}

	@Override
	public void deleteReply(Integer commentkey) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace + ".deleteReply", commentkey);
	}

	@Override
	public void modifyReply(CommentVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace + ".modifyReply", vo);
	}

	@Override
	public void replySub(CommentVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace + ".replySub", vo);
	}

	@Override
	public List<CommentVO> listMy(Integer userkey) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".listMy", userkey);
	}

	@Override
	public int commentCount(Integer userkey) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".commentMyCount", userkey);
	}

}
