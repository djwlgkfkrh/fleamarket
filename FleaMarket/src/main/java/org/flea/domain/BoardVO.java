package org.flea.domain;

import java.util.Date;

public class BoardVO {

	int boardkey; // �Խñ� Ű
	int userkey; // �ۼ��� Ű

	int salekey; // �˴ϴ� �Խñ� Ű
	int buykey; // ��ϴ� �Խñ� Ű
	int commentcnt;
	String title; // ������
	String text; // �۳���
	Date regdate; // �ۼ���
	int viewcnt; // ��ȸ��
	int salestate; // �ǸŻ���
	String group1; // �з�1
	String group2; // �з�2

	String nickname;
	boolean report;
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

	public int getCommentcnt() {
		return commentcnt;
	}

	public void setCommentcnt(int commentcnt) {
		this.commentcnt = commentcnt;
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

	public String getGroup1() {
		return group1;
	}

	public void setGroup1(String group1) {
		this.group1 = group1;
	}

	public String getGroup2() {
		return group2;
	}

	public void setGroup2(String group2) {
		this.group2 = group2;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public boolean isReport() {
		return report;
	}

	public void setReport(boolean report) {
		this.report = report;
	}

	/*
	 * @Override public String toString() { return "BoardVO [boardkey=" +
	 * boardkey + ",userkey=" + userkey + "]"; }
	 */

}
