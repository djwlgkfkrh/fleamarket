package org.flea.domain;


import java.util.Date;

public class BoardVO {

	int boardkey; // 게시글 키
	int userkey; // 작성자 키

	int salekey; // 팝니다 게시글 키
	int buykey; // 삽니다 게시글 키

	int group1; // 분류1
	int group2; // 분류2

	String title; // 글제목
	String text; // 글내용
	Date regdate; // 작성일
	int viewcnt; // 조회수
	int salestate; // 판매상태

	String gpsX; // GPS 위도 경도
	String gpsY; // (float로 하면 정확하게 저장이 안됨)
	String nickname;
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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public int getSalestate() {
		return salestate;
	}

	public void setSalestate(int salestate) {
		this.salestate = salestate;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/*
	 * @Override public String toString() { return "BoardVO [boardkey=" +
	 * boardkey + ",userkey=" + userkey + "]"; }
	 */

}
