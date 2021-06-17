package com.yanado.dto;

public class Search {
	String search;
	int searchInt = 0;
	int start;
	int end;
	int block = 12;
	int page;

	public Search() {
	}

	public Search(String search, int page) {
		this.search = search;
		this.page = page;
		this.start =  (page - 1)  * block;
		this.end = page * block;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSearchInt() {
		return searchInt;
	}

	public void setSearchInt(int searchInt) {
		this.searchInt = searchInt;
	}
	
	

}
