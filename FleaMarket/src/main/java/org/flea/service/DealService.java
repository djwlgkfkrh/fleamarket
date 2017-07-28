package org.flea.service;

import java.util.List;

import org.flea.domain.DealVO;

public interface DealService {
	public void createDeal(DealVO vo) throws Exception;

	public List<DealVO> getDeal(Integer userkey) throws Exception;
}
