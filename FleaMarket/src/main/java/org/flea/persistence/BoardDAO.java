package org.flea.persistence;

import java.util.List;

import org.flea.domain.BoardVO;

public interface BoardDAO {

	// public List<BoardVO> show(int userkey) throws Exception; // 글 리스트 출력용

	public void read(BoardVO vo) throws Exception; //글 읽기

	public void create(BoardVO vo) throws Exception; // 글 작성

	public void modify(BoardVO vo) throws Exception; // 글 수정

	public void delete(BoardVO vo) throws Exception; // 글 삭제

}
