package org.flea.persistence;


import org.flea.domain.MemberVO;


import java.util.List;

import org.flea.domain.MemberVO;

public interface MemberDAO {
	public void join(MemberVO member) throws Exception;
	public MemberVO login(MemberVO member) throws Exception;
	}


