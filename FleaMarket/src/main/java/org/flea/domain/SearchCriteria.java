package org.flea.domain;

public class SearchCriteria extends Criteria{

	private String searchType;
	private String keyword;
	private String group1;
	private String group2;
	
	
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
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
	
	
	
	@Override
	public String toString() {
		return super.toString() + " SearchCriteria [searchType=" + searchType + ", keyword="
				+ keyword + "]";
	}
	
}


