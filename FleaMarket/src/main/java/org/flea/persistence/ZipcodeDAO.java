package org.flea.persistence;

import java.util.List;

import org.flea.domain.ZipcodeVO;

public interface ZipcodeDAO {
	public List<ZipcodeVO> readZip(String dong) throws Exception;
}
