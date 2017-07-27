package org.flea.service;

import org.flea.domain.FileVO;

public interface FileService {
	
	
	public void saveFile(FileVO vo) throws Exception;
	public FileVO postFile(FileVO vo) throws Exception;
	

}
