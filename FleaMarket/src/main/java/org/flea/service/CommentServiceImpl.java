package org.flea.service;

import java.util.List;

import javax.inject.Inject;

import org.flea.domain.CommentVO;
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
	public List<CommentVO> commentRead(int boardkey) throws Exception {
		// TODO Auto-generated method stub
		return dao.commentRead(boardkey);
	}

	@Override
	public List<CommentVO> listMy(Integer userkey) throws Exception {
		// TODO Auto-generated method stub
		return dao.listMy(userkey);
	}

	@Override
	public int commentCount(Integer userkey) throws Exception {
		// TODO Auto-generated method stub
		return dao.commentCount(userkey);
	}

}
