package org.flea.service;

import java.util.List;

import org.flea.domain.FileVO;

public interface FileService {
	
	
	public void saveFile(FileVO vo) throws Exception;
	public List<FileVO> postFile(int boardkey) throws Exception;

}
