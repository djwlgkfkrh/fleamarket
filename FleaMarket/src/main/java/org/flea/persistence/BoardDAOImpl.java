package org.flea.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.flea.domain.BoardVO;
import org.flea.domain.CartVO;
import org.flea.domain.ReportVO;
import org.flea.domain.SearchCriteria;
import org.flea.domain.UserVO;
// import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {
	@Inject
	private SqlSession session;

	private static String namespace = "org.flea.mappers.BoardMapper";

	@Override
	public void updateViewCnt(Integer boardkey) throws Exception {
		session.update(namespace + ".updateViewCnt", boardkey);
	}

	@Override
	public UserVO find(Integer userkey) throws Exception {

		return session.selectOne(namespace + ".find", userkey);
	}

	@Override
	public BoardVO read(Integer boardkey) throws Exception {

		return session.selectOne(namespace + ".read", boardkey);

	}

	@Override
	public List<BoardVO> listMy(Integer userkey) throws Exception {

		return session.selectList(namespace + ".listMy", userkey);
	}

	@Override
	public int listCount(Integer userkey) throws Exception {

		return session.selectOne(namespace + ".listCount", userkey);

	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {

		return session.selectOne(namespace + ".listSearchCount", cri);
	}

	@Override
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception {

		return session.selectList(namespace + ".listSearch", cri);
	}

	@Override /* sale Board List */
	public List<BoardVO> salelistSearch(SearchCriteria cri) throws Exception {

		return session.selectList(namespace + ".salelistSearch", cri);
	}

	@Override
	public List<BoardVO> reportlistSearch(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".reportlistSearch", cri);
	}

	@Override /* sale Board List */
	public int salelistSearchCount(SearchCriteria cri) throws Exception {

		return session.selectOne(namespace + ".salelistSearchCount", cri);
	}

	@Override /* buy Board List */
	public List<BoardVO> buylistSearch(SearchCriteria cri) throws Exception {

		return session.selectList(namespace + ".buylistSearch", cri);
	}

	@Override /* buy Board List */
	public int buylistSearchCount(SearchCriteria cri) throws Exception {

		return session.selectOne(namespace + ".buylistSearchCount", cri);
	}

	@Override
	public int before(Integer boardkey) throws Exception {

		return session.selectOne(namespace + ".before", boardkey);
	}

	@Override
	public int after(Integer boardkey) throws Exception {

		return session.selectOne(namespace + ".after", boardkey);
	}

	@Override
	public void updateCommentCnt(Integer boardkey, int amount) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("boardkey", boardkey);
		paramMap.put("amount", amount);

		session.update(namespace + ".updateCommentCnt", paramMap);
	}

	@Override
	public void complete(Integer boardkey) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace + ".finish", boardkey);
	}

	public void putcart(CartVO vo) throws Exception {
		// TODO Auto-generated method stub

		session.insert(namespace + ".putcart", vo);
	}

	@Override
	public int getcart(Integer boardkey, Integer userkey) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("boardkey", boardkey);
		map.put("userkey", userkey);

		return session.selectOne(namespace + ".getcart", map);
	}

	@Override
	public void dealcart(Integer boardkey, Integer userkey) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("boardkey", boardkey);
		map.put("userkey", userkey);
		session.delete(namespace + ".dealcart", map);
	}

	@Override
	public List<CartVO> listCart(Integer userkey) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".listCart", userkey);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".listAll");
	}

	@Override /* Create Board */
	public void createPost(BoardVO vo) throws Exception {

		session.insert(namespace + ".create", vo);

	}

	@Override
	public List<BoardVO> popular() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".popular");
	}

	@Override /* Create Sale Table */
	public void createSale(Integer boardkey) throws Exception {

		session.insert(namespace + ".salecreate", boardkey);

	}

	@Override /* Create Buy Table */
	public void createBuy(Integer boardkey) throws Exception {

		session.insert(namespace + ".buycreate", boardkey);

	}

	@Override /* Board Key */
	public int getboardKey(BoardVO vo) throws Exception {

		return session.selectOne(namespace + ".getboardKey", vo);
	}

	@Override /* Board Modify */
	public void modifyBoard(BoardVO vo) throws Exception {

		session.update(namespace + ".modifyBoard", vo);

	}

	@Override /* Board Delete */
	public void deleteBoard(Integer boardkey) throws Exception {

		session.delete(namespace + ".deleteBoard_Comment", boardkey);
		session.delete(namespace + ".deleteBoard_File", boardkey);
		session.delete(namespace + ".deleteBoard", boardkey);
	}

	@Override
	public void deleteBuy(Integer boardkey) throws Exception {
		session.delete(namespace + ".deleteBoard_Comment", boardkey);
		session.delete(namespace + ".deleteBoard_File", boardkey);
		session.delete(namespace + ".deleteBuy", boardkey);
		session.delete(namespace + ".deleteBoard", boardkey);

	}

	@Override
	public void deleteSale(Integer boardkey) throws Exception {

		session.delete(namespace + ".deleteBoard_Comment", boardkey);
		session.delete(namespace + ".deleteBoard_File", boardkey);
		session.delete(namespace + ".deleteSale", boardkey);
		session.delete(namespace + ".deleteBoard", boardkey);

	}

	@Override /* getSaleState */
	public int getSaleState(Integer boardkey) throws Exception {
		return session.selectOne(namespace + ".getSaleState", boardkey);
	}

	@Override
	public int getBuyState(Integer boardkey) throws Exception {
		return session.selectOne(namespace + ".getBuyState", boardkey);
	}

	@Override
	public void forSearch() throws Exception {
		// TODO Auto-generated method stub

		for (int i = 1; i < 6; i++) {
			session.selectOne(namespace + ".forSearch", i);
		}

	}

	@Override
	public void changeBoardState(Integer boardkey) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace + ".changeBoardState", boardkey);
	}

	@Override
	public void report(ReportVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace + ".report", vo);
	}

	@Override
	public void boardReport(Integer boardkey) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace + ".boardReport", boardkey);
	}

	@Override
	public boolean distinguish(Integer boardkey) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".distinguish", boardkey);
	}

	@Override
	public void adminreturn(int boardkey) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace + ".adminreturn", boardkey);
	}

}
