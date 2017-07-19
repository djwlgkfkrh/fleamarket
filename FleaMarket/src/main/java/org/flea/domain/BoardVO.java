package org.flea.domain;

import java.util.Calendar;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	
	
	int boardkey; // �Խñ� Ű
	int userkey; // �ۼ��� Ű
	
	int salekey; // �˴ϴ� �Խñ� Ű
	int buykey; // ��ϴ� �Խñ� Ű 
	
	int group1; // �з�1
	int group2; // �з�2
	
	String title; // ������
	String text; // �۳���
	Calendar regdate; // �ۼ���
	int viewcnt; //��ȸ��
	int state; //�ǸŻ���
	
	String gpsX; // GPS ���� �浵 
	String gpsY; //(float�� �ϸ� ��Ȯ�ϰ� ������ �ȵ�)
	
	
	
	
	
	public int getSalekey() {
		return salekey;
	}



	public void setSalekey(int salekey) {
		this.salekey = salekey;
	}



	public int getBuykey() {
		return buykey;
	}



	public void setBuykey(int buykey) {
		this.buykey = buykey;
	}


	
	
	
	public int getBoardkey() {
		return boardkey;
	}



	public void setBoardkey(int boardkey) {
		this.boardkey = boardkey;
	}



	public int getUserkey() {
		return userkey;
	}



	public void setUserkey(int userkey) {
		this.userkey = userkey;
	}



	public int getGroup1() {
		return group1;
	}



	public void setGroup1(int group1) {
		this.group1 = group1;
	}



	public int getGroup2() {
		return group2;
	}



	public void setGroup2(int group2) {
		this.group2 = group2;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getText() {
		return text;
	}



	public void setText(String text) {
		this.text = text;
	}



	public Calendar getRegdate() {
		return regdate;
	}



	public void setRegdate(Calendar regdate) {
		this.regdate = regdate;
	}



	public int getViewcnt() {
		return viewcnt;
	}



	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}



	public int getState() {
		return state;
	}



	public void setState(int state) {
		this.state = state;
	}



	public String getGpsX() {
		return gpsX;
	}



	public void setGpsX(String gpsX) {
		this.gpsX = gpsX;
	}



	public String getGpsY() {
		return gpsY;
	}



	public void setGpsY(String gpsY) {
		this.gpsY = gpsY;
	}



	/*@Override
	public String toString() {
		return "BoardVO [boardkey=" + boardkey + ",userkey=" + userkey +  "]";
	}
	*/


}
