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
	public List<DealVO> getDeal(Integer userkey) throws Exception {
		// TODO Auto-generated method stub
		return dao.getDeal(userkey);
	}

}
