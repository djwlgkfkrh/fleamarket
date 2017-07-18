package org.flea.service;

import java.util.List;

import javax.inject.Inject;

import org.flea.domain.MemberVO;
import org.flea.persistence.MemberDAO;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Inject
	private MemberDAO dao;

	@Override
	public void join(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		dao.join(member);
	}

	@Override
	public MemberVO login(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		return dao.login(member);
	}

}
