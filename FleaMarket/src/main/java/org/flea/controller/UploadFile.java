package org.flea.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import org.flea.domain.FileVO;

public class UploadFile {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	public FileVO GetFile(String saveDir, MultipartFile multipartFile) throws Exception {


		FileVO vo = new FileVO();

		vo.setFileData(multipartFile.getBytes()); // bytes
		vo.setFilesize((int) multipartFile.getSize());// filesize
		vo.setFiletype(multipartFile.getContentType()); // fileType
		
		vo.setFile(duplicateFile(saveDir, multipartFile)); // file로 저장됨
		vo.setOname(multipartFile.getOriginalFilename()); // oName

		vo.setFname(vo.getFile().getName()); // fname
		vo.setFilepath((saveDir +"/"+ vo.getFname())); // path
		

		saveToFile(vo);
		
		logger.info("FileVO 상태 : ======= GetFile 완료 =========");

		return vo;
	}

	/**
	 * Multipart File의 내용을 파일로 저장, 저장 후 저장된 파일 이름을 반환
	 * 
	 */

	public void saveToFile(FileVO vo) throws Exception {

		/* 지정된 경로에 업로드한 파일 쓰기 */
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(vo.getFilepath()));
		bos.write(vo.getFileData());
		bos.flush();
		bos.close();
	}

	/**
	 * 파일이름으로부터 확장자를 반환하는 메서드
	 * 파일이름에 확장자 구분을 위한 . 문자가 없거나 . 가장 끝에 있는 경우는 빈문자열 ""을
	 * 리턴
	 */

	public String getExtension(String fileName) throws Exception {

		int dotPosition = fileName.lastIndexOf('.');
		if (-1 != dotPosition && fileName.length() - 1 > dotPosition) {
			return fileName.substring(dotPosition + 1);
		} else {
			return "";
		}

	}
	
	
	// 같은 이름의 파일이 존재하는 경우
	// 증가되는 숫가를 파일명 뒤에 붙여서 새로운 파일 객체로 만들어 주는 메소드
		public static File duplicateFile(String uploadPath, MultipartFile multipartFile) {
			
			String fileName = multipartFile.getOriginalFilename();
			String serverFileName = fileName;
			
			int cnt = 1;
			File file = null;
			
			do {
				file = new File(uploadPath, serverFileName);
				if (!file.exists())
					break;
				serverFileName = fileName.substring(0, fileName.lastIndexOf(".")) + (cnt++)
						+ fileName.substring(fileName.lastIndexOf("."));
			} while (true);
			
			return file;
			
		}// getFile
	
	
}
