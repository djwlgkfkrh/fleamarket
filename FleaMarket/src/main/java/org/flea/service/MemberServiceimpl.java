package org.flea.service;

import javax.inject.Inject;

import org.flea.domain.MemberVO;
import org.flea.persistence.MemberDAO;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceimpl implements MemberService {
	@Inject
	private MemberDAO dao;
	@Override
	public void create(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
dao.create(vo);
	}

}
