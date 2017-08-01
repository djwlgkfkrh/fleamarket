package org.flea.service;

import java.util.List;

import javax.inject.Inject;

import org.flea.domain.DealVO;
import org.flea.persistence.DealDAO;
import org.springframework.stereotype.Service;

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

	@Override
	public void remitMoney(Integer dealkey, Integer money) throws Exception {
		// TODO Auto-generated method stub
		dao.remitMoney(dealkey, money);
	}

	@Override
	public void updateDelivery(DealVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.updateDelivery(vo);
	}

	@Override
	public void complete(Integer dealkey) throws Exception {
		// TODO Auto-generated method stub
		dao.complete(dealkey);
	}

}
