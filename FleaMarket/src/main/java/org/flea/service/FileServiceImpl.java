package org.flea.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import org.flea.domain.FileVO;
import org.flea.persistence.FileDAO;

@Service
public class FileServiceImpl implements FileService {

	@Inject
	private FileDAO dao;

	@Override
	public void saveFile(FileVO vo) throws Exception {
	
		dao.saveFile(vo);
	}

	@Override
	public FileVO postFile(FileVO vo) throws Exception {
		
		return dao.postFile(vo);
	}

}
