package org.flea.domain;

public class UserVO {
	private Integer userkey ;
	private String id;
	private String pw;
	private String name;
	private Integer point;
	private String nickname ;
	private Integer cheater;
	private Integer admin;
	public Integer getUserkey() {
		return userkey ;
	}
	public void setUserkey(Integer userkey ) {
		this.userkey  = userkey ;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public String getNickname() {
		return nickname ;
	}
	public void setNickname(String nickname ) {
		this.nickname  = nickname ;
	}
	public Integer getCheater() {
		return cheater;
	}
	public void setCheater(Integer cheater) {
		this.cheater = cheater;
	}
	public Integer getAdmin() {
		return admin;
	}
	public void setAdmin(Integer admin) {
		this.admin = admin;
	}
}
