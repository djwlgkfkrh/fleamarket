package org.flea.persistence;

import org.flea.domain.MemberVO;

public interface MemberDAO {
	public void join(MemberVO member) throws Exception;
}
