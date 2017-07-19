package org.flea.persistence;

import java.util.List;

import org.flea.domain.BoardVO;

public interface BoardDAO {

	// public List<BoardVO> show(int userkey) throws Exception; // �� ����Ʈ ��¿�

	public void readMain(BoardVO vo) throws Exception; //�� �б�
	public void readSale(BoardVO vo) throws Exception; //�� �б�
	public void readBuy(BoardVO vo) throws Exception; //�� �б�

	public void create(BoardVO vo) throws Exception; // �� �ۼ�

	public void modify(BoardVO vo) throws Exception; // �� ����

	public void delete(BoardVO vo) throws Exception; // �� ����

}
