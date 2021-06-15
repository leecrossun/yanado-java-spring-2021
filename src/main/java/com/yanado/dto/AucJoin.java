package com.yanado.dto;

public class AucJoin {
	string aucNo;
	String userId;
	int bidPrice;
	int bidCount;
	
	public AucJoin(String aucNo, String userId, int bidPrice, int bidCount) {
		this.aucNo = aucNo;
		this.userId = userId;
		this.bidPrice = bidPrice;
		this.bidCount = bidCount;
	}
	public AucJoin(String aucNo, String userId, int bidPrice, int bidCount) {
		this.aucNo = aucNo;
		this.userId = userId;
		this.bidPrice = bidPrice;
	}
	
	public String getaucNo() {
		return aucNo;
	}
	public void setaucNo(String aucNo) {
		this.aucNo = aucNo;
	}
	
	public String getuserId() {
		return userId;
	}
	public void setuserId(String userId) {
		this.userId = userId;
	}
	
	public int getbidPrice() {
		return bidPrice;
	}
	public void setbidPrice(int bidPrice) {
		this.bidPrice = bidPrice;
	}
}
