package org.flea.persistence;

import javax.inject.Inject;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import org.flea.domain.FileVO;


@Repository
public class FileDAOImpl implements FileDAO{
	
	@Inject
	  private SqlSession session;

	  private static String namespace = "org.flea.mappers.FileMapper";

	@Override
	public void saveFile(FileVO vo) throws Exception {
		
		session.insert(namespace + ".addFile", vo);
	}

	@Override
	public List<FileVO> postFile(int boardkey) throws Exception {
	
		return session.selectList(namespace + ".getFile", boardkey);
	}

	@Override
	public void modifyFile(FileVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace + ".modifyFile", vo);
		
	}

	@Override
	public int getFileId(int boardkey) throws Exception {
		return session.selectOne(namespace + ".getFileId", boardkey);
		
	}

}
