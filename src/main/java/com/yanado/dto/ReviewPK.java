package com.yanado.dto;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class ReviewPK implements Serializable{
	private String reviewId;
	private String shoppingId;
	
	public ReviewPK() {}
	
	public ReviewPK(String reviewId, String shoppingId) {
		this.reviewId = reviewId;
		this.shoppingId = shoppingId;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		ReviewPK reviewPK = (ReviewPK) o;
		return reviewId.equals(reviewPK.reviewId) &&
				shoppingId.equals(reviewPK.shoppingId);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(reviewId, shoppingId);
	}
	

}
