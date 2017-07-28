package org.flea.persistence;

import java.util.List;

import org.flea.domain.FileVO;

public interface FileDAO {
	
	
	public void saveFile(FileVO vo) throws Exception;
	public List<FileVO> postFile(int boardkey) throws Exception;
	

}
