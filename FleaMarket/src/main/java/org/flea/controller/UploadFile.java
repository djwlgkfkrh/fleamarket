package org.flea.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import org.flea.domain.FileVO;

public class UploadFile {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	public FileVO GetFile(MultipartFile multipartFile) throws Exception {


		FileVO vo = new FileVO();

		String genId = UUID.randomUUID().toString(); // UUID�� ������ �� ���� �� ����


		vo.setFile(multipartFile); // file
		vo.setFileData(multipartFile.getBytes()); // bytes
		vo.setFilesize((int) multipartFile.getSize());// filesize
		vo.setFiletype(multipartFile.getContentType()); // fileType
		vo.setOname(multipartFile.getOriginalFilename()); // oName
		vo.setFname(genId + "." + getExtension(vo.getOname())); // fname
		vo.setFilepath((vo.IMAGE_DIR + vo.getFname())); // path

		saveToFile(vo);

		logger.info("FileVO ���� : ======= GetFile �Ϸ� =========");

		return vo;
	}

	/**
	 * Multipart File�� ������ ���Ϸ� ����, ���� �� ����� ���� �̸��� ��ȯ
	 * 
	 */

	public void saveToFile(FileVO vo) throws Exception {

		/* ������ ��ο� ���ε��� ���� ���� */
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(vo.getFilepath()));
		bos.write(vo.getFileData());
		bos.flush();
		bos.close();
	}

	/**
	 * �����̸����κ��� Ȯ���ڸ� ��ȯ�ϴ� �޼��� �����̸��� Ȯ���� ������ ���� . ���ڰ� ���ų� . ���� ���� �ִ� ���� ���ڿ� ""��
	 * ����
	 */

	public String getExtension(String fileName) throws Exception {

		int dotPosition = fileName.lastIndexOf('.');
		if (-1 != dotPosition && fileName.length() - 1 > dotPosition) {
			return fileName.substring(dotPosition + 1);
		} else {
			return "";
		}

	}
}
