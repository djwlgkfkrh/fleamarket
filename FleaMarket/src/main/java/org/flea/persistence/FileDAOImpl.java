package org.flea.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import org.flea.domain.FileVO;


@Repository
public class FileDAOImpl implements FileDAO{
	
	@Inject
	  private SqlSession session;

	  private static String namespace = "com.ex.mappers.FileMapper";

	@Override
	public void saveFile(FileVO vo) throws Exception {
		
		session.insert(namespace + ".addFile", vo);
	}

	@Override
	public FileVO postFile(FileVO vo) throws Exception {
	
		return session.selectOne(namespace + ".getFile", vo);
	}

}
