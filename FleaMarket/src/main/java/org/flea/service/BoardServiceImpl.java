package org.flea.service;

import java.util.List;

import javax.inject.Inject;

import org.flea.domain.BoardVO;
import org.flea.domain.CartVO;
import org.flea.domain.ReportVO;
import org.flea.domain.SearchCriteria;
import org.flea.domain.UserVO;
import org.flea.persistence.BoardDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;

	@Override
	public BoardVO read(Integer boardkey) throws Exception {
		// TODO Auto-generated method stub
		dao.updateViewCnt(boardkey);

		return dao.read(boardkey);
	}

	@Override

	public List<BoardVO> listMy(Integer userkey) throws Exception {
		// TODO Auto-generated method stub
		return dao.listMy(userkey);
	}

	@Override
	public int listCount(Integer userkey) throws Exception {
		// TODO Auto-generated method stub
		return dao.listCount(userkey);
	}

	public UserVO find(Integer userkey) throws Exception {
		// TODO Auto-generated method stub
		return dao.find(userkey);

	}

	// Search List
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

	@Override
	public int reportSearchCount(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.reportlistSearchCount(cri);
	}

	@Override
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}

	// sale Board
	@Override
	public void createSale(Integer boardkey) throws Exception {
		dao.createSale(boardkey);
	}
	
	

	@Override
	public List<BoardVO> salelistSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.salelistSearch(cri);
	}

	@Override
	public List<BoardVO> reportSearchCriteria(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.reportlistSearch(cri);
	}

	@Override
	public int salelistSearchCount(SearchCriteria cri) throws Exception {
		return dao.salelistSearchCount(cri);
	}

	// buy Board
	@Override
	public void createBuy(Integer boardkey) throws Exception {
		dao.createBuy(boardkey);
	}

	@Override
	public List<BoardVO> buylistSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.buylistSearch(cri);
	}

	@Override
	public int buylistSearchCount(SearchCriteria cri) throws Exception {
		return dao.buylistSearchCount(cri);
	}

	@Override
	public int before(Integer boardkey) throws Exception {

		return dao.before(boardkey);
	}

	@Override
	public int after(Integer boardkey) throws Exception {

		return dao.after(boardkey);
	}

	@Transactional
	@Override
	public void complete(Integer boardkey) throws Exception {
		// TODO Auto-generated method stub
		dao.complete(boardkey);
	}
	
	@Transactional
	@Override
	public void returncomplete(Integer boardkey) throws Exception {
		// TODO Auto-generated method stub
		dao.returncomplete(boardkey);
	}

	@Override
	public void putcart(CartVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.putcart(vo);
	}

	@Override
	public int getcart(Integer boardkey, Integer userkey) throws Exception {
		// TODO Auto-generated method stub
		return dao.getcart(boardkey, userkey);
	}

	@Override
	public void dealcart(Integer boardkey, Integer userkey) throws Exception {
		// TODO Auto-generated method stub
		dao.dealcart(boardkey, userkey);
	}

	@Override
	public List<CartVO> listCart(Integer userkey) throws Exception {
		// TODO Auto-generated method stub
		return dao.listCart(userkey);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.listAll();
	}

	@Override
	public void createPost(BoardVO bvo) throws Exception {

		dao.createPost(bvo);

	}

	@Override
	public int getboardKey(BoardVO bvo) throws Exception {

		return dao.getboardKey(bvo);
	}

	// Modify
	@Override
	public void modifyBoard(BoardVO bvo) throws Exception {

		dao.modifyBoard(bvo);

	}

	// Delete
	@Override
	public void deleteBoard(Integer boardkey) throws Exception {
		dao.deleteBoard(boardkey);
	}

	@Override
	public void deleteBuy(Integer boardkey) throws Exception {

		dao.deleteBuy(boardkey);
	}

	@Override
	public void deleteSale(Integer boardkey) throws Exception {

		dao.deleteSale(boardkey);

	}

	@Override
	public int getSaleState(Integer boardkey) throws Exception {

		return dao.getSaleState(boardkey);
	}

	@Override
	public int getBuyState(Integer boardkey) throws Exception {

		return dao.getBuyState(boardkey);

	}

	@Override
	public List<BoardVO> popular() throws Exception {
		// TODO Auto-generated method stub
		return dao.popular();
	}

	@Override
	public void changeBoardState(Integer boardkey) throws Exception {
		// TODO Auto-generated method stub
		dao.changeBoardState(boardkey);
	}

	@Override
	public void report(ReportVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.report(vo);
		dao.boardReport(vo.getBoardkey());
	}

	@Override
	public boolean distinguish(Integer boardkey) throws Exception {
		// TODO Auto-generated method stub
		return dao.distinguish(boardkey);
	}

	@Override
	public void adminreturn(int boardkey) throws Exception {
		// TODO Auto-generated method stub
		dao.adminreturn(boardkey);
	}

	@Override
	public int countboard() throws Exception {
		// TODO Auto-generated method stub
		return dao.countboard();
	}

}
