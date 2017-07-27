package org.flea.service;

import java.util.List;

import org.flea.domain.ZipcodeVO;

public interface ZipcodeService {
	public List<ZipcodeVO> readZip(String dong) throws Exception;
}
