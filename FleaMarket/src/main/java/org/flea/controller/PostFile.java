package org.flea.controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.flea.domain.FileVO;

public class PostFile {

	/**
	 * ���Ϸκ��� byte �迭 �о����
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
	 * ���� OutputStream�� ���� ���� ����
	 */
	public void write(HttpServletResponse res, byte[] bytes) throws IOException {
		OutputStream output = res.getOutputStream();
		output.write(bytes);
		output.flush();
	}

}
