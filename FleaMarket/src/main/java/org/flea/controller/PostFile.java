package org.flea.controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.flea.domain.FileVO;

public class PostFile {

	/**
	 * 파일로부터 byte 배열 읽어오기
	 */
	public byte[] readFile(String fileName) throws IOException {
		String path = FileVO.IMAGE_DIR + fileName;

		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
		int length = bis.available();
		byte[] bytes = new byte[length];
		bis.read(bytes);
		bis.close();

		return bytes;
	}

	/**
	 * 응답 OutputStream에 파일 내용 쓰기
	 */
	public void write(HttpServletResponse res, byte[] bytes) throws IOException {
		OutputStream output = res.getOutputStream();
		output.write(bytes);
		output.flush();
	}

}
