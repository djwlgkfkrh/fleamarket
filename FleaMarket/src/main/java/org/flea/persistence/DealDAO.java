package org.flea.persistence;

import java.util.List;

import org.flea.domain.DealVO;

public interface DealDAO {
	public void createDeal(DealVO vo) throws Exception;

	public DealVO read(Integer dealkey) throws Exception;
	
	public List<DealVO> getDeal(Integer userkey) throws Exception;
	
	public int checkMoney(String dealkey,String money) throws Exception;
	
	public void remitMoney(Integer dealkey,Integer money) throws Exception;
	
	public void updateDelivery(DealVO vo) throws Exception;
	
	public void complete(Integer dealkey) throws Exception;
	
	public void returncomplete(Integer dealkey) throws Exception;
	
	public void returngoods(DealVO vo) throws Exception;
	
	public void makedeal(DealVO vo) throws Exception;
	
}
