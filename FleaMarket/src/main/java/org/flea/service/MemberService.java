package org.flea.service;

import java.util.List;

import org.flea.domain.MemberVO;

public interface MemberService {
	public void join(MemberVO member) throws Exception;
	public MemberVO login(MemberVO member) throws Exception;
}
