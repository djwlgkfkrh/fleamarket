package org.flea.persistence;

import java.util.List;

import org.flea.domain.DealVO;

public interface DealDAO {
	public void createDeal(DealVO vo) throws Exception;

	public List<DealVO> getDeal(Integer userkey) throws Exception;

}
