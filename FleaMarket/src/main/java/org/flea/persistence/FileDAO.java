package org.flea.persistence;

import org.flea.domain.FileVO;

public interface FileDAO {
	
	
	public void saveFile(FileVO vo) throws Exception;
	public FileVO postFile(FileVO vo) throws Exception;
	

}
