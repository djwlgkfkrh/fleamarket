package org.flea.domain;

import org.springframework.web.multipart.MultipartFile;

public class FileVO {
	
/** * ���ε��� �̹��� ������ ����� ��� */ 
	
	public static final String IMAGE_DIR = "D:/images/"; // ����� ��� 


	private String fileid; // ���� id

	private String oname; //  ����  �����̸�
	private String fname; //  ���� ������̸�
	
	private String filepath; // ���ϰ��
	private String filetype; // Ȯ����
	private int filesize; // filesize
	
	private MultipartFile file; // ����
	byte[ ] fileData; // ���� stream ������ 
	
	
	
	
	public String getFileid() {
		return fileid;
	}
	public void setFileid(String fileid) {
		this.fileid = fileid;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public int getFilesize() {
		return filesize;
	}
	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	
	//@Override
	//  public String toString() {
	//    return "BoardVO [bno=" + bno + ", title=" + title + ",  "]";
	//  }
	
	
	

}
