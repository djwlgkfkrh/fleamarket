package org.flea.service;

import java.util.List;

import javax.inject.Inject;

import org.flea.domain.BoardVO;
import org.flea.domain.CommentVO;
import org.flea.domain.UserVO;
import org.flea.persistence.CommentDAO;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
	@Inject
	private CommentDAO dao;

	@Override
	public void addReply(CommentVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.addReply(vo);
	}

	@Override
	public List<CommentVO> commentRead(Integer boardkey) throws Exception {
		// TODO Auto-generated method stub
		return dao.commentRead(boardkey);
	}

	@Override
	public void deleteReply(Integer commentkey) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteReply(commentkey);
	}

	@Override
	public void modifyReply(CommentVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.modifyReply(vo);
	}

	@Override
	public void replySub(CommentVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.replySub(vo);
	}

}
