package org.flea.domain;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class FileVO {
	
/** * 업로드한 이미지 파일이 저장될 경로 */ 
	
	//public static final String IMAGE_DIR = "D:/images/"; // 저장될 경로 

	private int boardkey;
	private int filekey;
	
	private int fileid; // 파일 id //

	private String oname; //  파일  원래이름
	private String fname; //  파일 저장된이름
	
	private String filepath; // 파일경로
	private String filetype; // 확장자 //
	private int filesize; // filesize //
	
	private MultipartFile mfile[]; // MultipartFile
	
	private File file; // 파일
	byte[ ] fileData; // 파일 stream 데이터 
	
	
	
	
	public MultipartFile[] getMfile() {
		return mfile;
	}
	public void setMfile(MultipartFile[] mfile) {
		this.mfile = mfile;
	}
	
	
	public int getBoardkey() {
		return boardkey;
	}
	public void setBoardkey(int boardkey) {
		this.boardkey = boardkey;
	}
	public int getFilekey() {
		return filekey;
	}
	public void setFilekey(int filekey) {
		this.filekey = filekey;
	}
	public int getFileid() {
		return fileid;
	}
	public void setFileid(int fileid) {
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
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
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
