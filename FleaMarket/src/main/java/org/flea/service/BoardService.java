package org.flea.service;

import org.flea.domain.BoardVO;

public interface BoardService {
	
	 public void read(BoardVO vo) throws Exception;
	 public void create(BoardVO vo) throws Exception;
/*	 public void modify(BoardVO vo) throws Exception; */
	 public void delete(BoardVO vo) throws Exception;

}
