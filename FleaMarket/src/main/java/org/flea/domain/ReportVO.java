package org.flea.domain;

public class ReportVO {
	int reportkey;
	int boardkey;
	String nickname;
	String reason;

	public int getReportkey() {
		return reportkey;
	}

	public void setReportkey(int reportkey) {
		this.reportkey = reportkey;
	}

	public int getBoardkey() {
		return boardkey;
	}

	public void setBoardkey(int boardkey) {
		this.boardkey = boardkey;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
