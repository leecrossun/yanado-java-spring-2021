package service.dto;

public class Search {
	String condition;
	String search;
	int start;
	int end;

	public Search() {
	}

	public Search(String condition, String search, int start, int end) {
		super();
		this.condition = condition;
		this.search = search;
		this.start = start;
		this.end = end;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
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

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}
