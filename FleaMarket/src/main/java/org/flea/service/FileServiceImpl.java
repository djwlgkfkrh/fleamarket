package org.flea.service;

import java.util.List;

import javax.inject.Inject;

import org.flea.domain.FileVO;
import org.flea.persistence.FileDAO;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {

	@Inject
	private FileDAO dao;

	@Override
	public void saveFile(FileVO vo) throws Exception {
	
		dao.saveFile(vo);
	}

	@Override
	public List<FileVO> postFile(int boardkey) throws Exception {

		return dao.postFile(boardkey);
	}

	@Override
	public void modifyFile(FileVO vo) throws Exception {
		
		dao.modifyFile(vo);
		
	}

	@Override
	public int getFileId(int boardkey) throws Exception {

		return dao.getFileId(boardkey);
	}
	
	@Override
	public FileVO getOneFile (int boardkey) throws Exception{
		
		return dao.getOneFile(boardkey);
	}



}
