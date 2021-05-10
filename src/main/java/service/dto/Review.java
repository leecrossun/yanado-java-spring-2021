package service.dto;

import java.util.Date;

public class Review {
	String reviewId;
	String shoppingId;
	String userId;
	String content;
	int rating;
	Date published;
	
	
	public Review() {
		super();
	}

	public Review(String reviewId, String shoppingId, String userId, String content, int rating, Date published) {
		super();
		this.reviewId = reviewId;
		this.shoppingId = shoppingId;
		this.userId = userId;
		this.content = content;
		this.rating = rating;
		this.published = published;
	}
	
	public String getReviewId() {
		return reviewId;
	}
	public String getShoppingId() {
		return shoppingId;
	}
	public String getUserId() {
		return userId;
	}
	public String getContent() {
		return content;
	}
	public int getRating() {
		return rating;
	}
	public Date getPublished() {
		return published;
	}
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}
	public void setShoppingId(String shoppingId) {
		this.shoppingId = shoppingId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public void setPublished(Date published) {
		this.published = published;
	}

}
