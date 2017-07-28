package org.flea.domain;

import java.util.Date;

public class CommentVO {
	int userkey;
	int boardkey;
	int commentkey;
	String context;
	Date regdate;
	boolean secret;
	int parent_key;
	
	public int getUserkey() {
		return userkey;
	}
	public void setUserkey(int userkey) {
		this.userkey = userkey;
	}
	public int getBoardkey() {
		return boardkey;
	}
	public void setBoardkey(int boardkey) {
		this.boardkey = boardkey;
	}
	public int getCommentkey() {
		return commentkey;
	}
	public void setCommentkey(int commentkey) {
		this.commentkey = commentkey;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public boolean isSecret() {
		return secret;
	}
	public void setSecret(boolean secret) {
		this.secret = secret;
	}
	public int getParent_key() {
		return parent_key;
	}
	public void setParent_key(int parent_key) {
		this.parent_key = parent_key;
	}
	
}
