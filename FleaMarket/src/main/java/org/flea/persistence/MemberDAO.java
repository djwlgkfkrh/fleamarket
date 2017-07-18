package org.flea.persistence;

<<<<<<< HEAD
import org.flea.domain.MemberVO;

public interface MemberDAO {
public void create(MemberVO vo) throws Exception;

}
=======
import java.util.List;

import org.flea.domain.MemberVO;

public interface MemberDAO {
	public void join(MemberVO member) throws Exception;
	public MemberVO login(MemberVO member) throws Exception;
	}

>>>>>>> branch 'master' of https://github.com/djwlgkfkrh/fleamarket.git
