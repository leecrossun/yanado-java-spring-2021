package com.yanado.dto;

public class AucJoin {
	String aucNo;
	String userId;
	
	int bidPrice;
	int bidCount;
	
	public AucJoin() {
	}
	
	public AucJoin(String aucNo, String userId, int bidPrice) {
		this.aucNo = aucNo;
		this.userId = userId;
		this.bidPrice = bidPrice;
	}
	
	public AucJoin(String aucNo, String userId, int bidPrice, int bidCount) {
		this.aucNo = aucNo;
		this.userId = userId;
		this.bidPrice = bidPrice;
		this.bidCount = bidCount;
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
	public int getbidCount() {
		return bidPrice;
	}
	public void setbidCount(int bidCount) {
		this.bidCount = bidCount;
	}
}
