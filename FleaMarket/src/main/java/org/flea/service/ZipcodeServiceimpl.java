package org.flea.service;

import java.util.List;

import javax.inject.Inject;

import org.flea.domain.ZipcodeVO;
import org.flea.persistence.ZipcodeDAO;
import org.springframework.stereotype.Service;

@Service
public class ZipcodeServiceimpl implements ZipcodeService {
	@Inject
	private ZipcodeDAO dao;

	@Override
	public List<ZipcodeVO> readZip(String dong) throws Exception {
		// TODO Auto-generated method stub
		return dao.readZip(dong);
	}

}
