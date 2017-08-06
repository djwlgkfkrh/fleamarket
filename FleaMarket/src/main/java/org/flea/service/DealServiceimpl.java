package org.flea.service;

import java.util.List;

import javax.inject.Inject;

import org.flea.domain.DealVO;
import org.flea.persistence.DealDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DealServiceimpl implements DealService {
	@Inject
	private DealDAO dao;

	@Override
	public void createDeal(DealVO vo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public DealVO read(Integer dealkey) throws Exception {
		// TODO Auto-generated method stub
		return dao.read(dealkey);
	}

	@Override
	public List<DealVO> getDeal(Integer userkey) throws Exception {
		// TODO Auto-generated method stub
		return dao.getDeal(userkey);
	}

	@Override
	public int checkMoney(String dealkey, String money) throws Exception {
		// TODO Auto-generated method stub
		return dao.checkMoney(dealkey, money);
	}
	@Transactional
	@Override
	public void remitMoney(Integer dealkey, Integer money) throws Exception {
		// TODO Auto-generated method stub
		dao.remitMoney(dealkey, money);
	}
	@Transactional
	@Override
	public void updateDelivery(DealVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.updateDelivery(vo);
	}
	@Transactional
	@Override
	public void complete(Integer dealkey) throws Exception {
		// TODO Auto-generated method stub
		dao.complete(dealkey);
	}

	@Override
	public void returncomplete(Integer dealkey) throws Exception {
		// TODO Auto-generated method stub
		dao.returncomplete(dealkey);
	}

	@Override
	public void returngoods(DealVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.returngoods(vo);
	}

	@Override
	public void makedeal(DealVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.makedeal(vo);
	}

}
