package service.dto;

public class Criteria {

	// 사용법 - UI
	// 처음 객체 생성시 현재 페이지와, 전체 데이터 수 입력
	// setPagenum으로 현재 페이지 번호만 바꾸어서 사용
	// get이 모두 계산해서 반환하게 만듬

	// 사용법 - DAO
	// getStartIndex()와 getEndIndex() 가져와서 query에 넣기

	private int totalcount; // 페이징에 적용할 전체 데이터 갯수
	private int pagenum; // 현재 페이지 번호

	private int contentnum = 10; // 한페이지에 몇개 표시할지
	private int startIndex = 0;
	private int endIndex;

	private int startblock = 1; // 현재 페이지 시작 블록
	private int endblock = 5; // 현재 페이지 블럭의 마지막 블록
	
	private boolean prev; // 이전 페이지로 가는 화살표
	private boolean next; // 다음 페이지로 가는 화살표
	
	private int currentblock; // 현재 페이지 블록
	private int lastblock; // 마지막 페이지 블록

	public Criteria(int pagenum, int totalcount) {
		this.pagenum = pagenum;
		this.totalcount = totalcount;
		prevnext(pagenum);
	}

	public void prevnext(int pagenum) {
		// 이전 , 다음 페이지 블록
		if (calcpage(totalcount, contentnum) < 6) {
			setPrev(false);
			setNext(false);
		} else if (pagenum > 0 && pagenum < 6) {
			setPrev(false);
			setNext(true);
		} else if (getLastblock() == getCurrentblock()) {
			setPrev(true);
			setNext(false);
		} else {
			setPrev(true);
			setNext(true);
		}
	}

	public int calcpage(int totalcount, int contentnum) { // 전체페이지 수를 계산하는 함수

		int totalpage = totalcount / contentnum;
		if (totalcount % contentnum > 0) {
			totalpage++;
		}
		return totalpage;
	}

	public int getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}

	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
		prevnext(pagenum);
	}

	public int getStartIndex() {
		startIndex = contentnum * (pagenum - 1) + 1;
		return startIndex;
	}

	public int getEndIndex() {
		endIndex = getStartIndex() + contentnum - 1;
		return endIndex;
	}

	public int getContentnum() {
		return contentnum;
	}

	public int getStartblock() {
		startblock = (getCurrentblock() * 5) - 4;
		return startblock;
	}

	public int getEndblock() {

		if (getLastblock() == getCurrentblock()) {
			endblock = calcpage(getTotalcount(), getContentnum()); // 전체페이지 개수가 오는곳
		} else {
			endblock = getStartblock() + 4;
		}
		return endblock;
	}

	public int getCurrentblock() {
		currentblock = pagenum / 5;

		if (pagenum % 5 > 0) {
			currentblock++;
		}

		return currentblock;
	}

	public int getLastblock() {
		lastblock = totalcount / (5 * contentnum);

		if (totalcount % (5 * this.contentnum) > 0) {
			lastblock++;
		}

		return lastblock;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

}