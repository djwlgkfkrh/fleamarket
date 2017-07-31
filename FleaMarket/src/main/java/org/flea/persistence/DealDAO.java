package org.flea.persistence;

import java.util.List;

import org.flea.domain.DealVO;

public interface DealDAO {
	public void createDeal(DealVO vo) throws Exception;

	public List<DealVO> getDeal(Integer userkey) throws Exception;
	
	public int checkMoney(String dealkey,String money) throws Exception;
	
	public void remitMoney(Integer dealkey,Integer money) throws Exception;

}
