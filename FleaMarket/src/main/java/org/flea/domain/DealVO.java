package org.flea.domain;

import java.util.Date;

public class DealVO {
	private Integer dealkey;
	private Integer buyuserkey;
	private Integer saleuserkey;
	private Integer boardkey;
	private Integer deliverykey;
	private Integer money;
	private Integer remittance;
	private Integer salestate;
	private String reason;
	private Date regdate;
	private String title;
	private String nickname;

	public Integer getDealkey() {
		return dealkey;
	}

	public void setDealkey(Integer dealkey) {
		this.dealkey = dealkey;
	}

	public Integer getBuyuserkey() {
		return buyuserkey;
	}

	public void setBuyuserkey(Integer buyuserkey) {
		this.buyuserkey = buyuserkey;
	}

	public Integer getSaleuserkey() {
		return saleuserkey;
	}

	public void setSaleuserkey(Integer saleuserkey) {
		this.saleuserkey = saleuserkey;
	}

	public Integer getBoardkey() {
		return boardkey;
	}

	public void setBoardkey(Integer boardkey) {
		this.boardkey = boardkey;
	}

	public Integer getDeliverykey() {
		return deliverykey;
	}

	public void setDeliverykey(Integer deliverykey) {
		this.deliverykey = deliverykey;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public Integer getRemittance() {
		return remittance;
	}

	public void setRemittance(Integer remittance) {
		this.remittance = remittance;
	}

	public Integer getSalestate() {
		return salestate;
	}

	public void setSalestate(Integer salestate) {
		this.salestate = salestate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
