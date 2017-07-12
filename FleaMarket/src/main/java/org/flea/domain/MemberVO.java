package org.flea.domain;

public class MemberVO {
	private Integer ukey;
	private String id;
	private String pw;
	private String name;
	private Integer point;
	private String nick;
	private Integer cheater;
	private Integer admin;
	
	public Integer getUkey() {
		return ukey;
	}
	public void setUkey(Integer ukey) {
		this.ukey = ukey;
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
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
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
