package org.flea.service;

import java.util.List;

import org.flea.domain.BoardVO;

public interface BoardService {
	public List<BoardVO> show() throws Exception; // �� ����Ʈ ��¿�
	 public void read(BoardVO vo) throws Exception;
	 public void create(BoardVO vo) throws Exception;
/*	 public void modify(BoardVO vo) throws Exception; */
	 public void delete(BoardVO vo) throws Exception;

}
