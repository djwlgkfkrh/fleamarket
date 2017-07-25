package org.flea.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.flea.domain.CommentVO;
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
	public List<CommentVO> commentRead(int boardkey) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".commentRead", boardkey);
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
