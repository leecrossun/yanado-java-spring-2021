package com.yanado.dto;

public class User {

	private String userId;		//아이디
	private String password;	// 비밀번호
	private String userName;	// 이름
	private String gender;		// 성별
	private String birth;		// 주민등록 앞번호? 생년월일?
	private String address;		// 주소
	private String phoneNumber;	// 전화번호
	private String email;		// 이메일
	private int rankCount;		// (주문(+), 취소(-)), 리뷰 등록(+)
	
	// 등급 추가...?
	private String userMembership;
	private String inputStr;

	public User() {
		super();
	}
	
	// 회원등급 변경 시 사용
		public User(String userId, String inputStr) {
			super();
			this.userId = userId;
			this.inputStr = inputStr;
		}
		
	// 마이페이지에서 정보 수정 시 사용
	public User(String userId, String password, String phoneNumber, String email) {
		super();
		
		this.userId = userId;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	// 회원 가입 시 사용
	public User(String userId, String password, String userName, 
			String gender, String birth, String address, String phoneNumber, String email) {
		super();
		
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.gender = gender;
		this.birth = birth;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return phoneNumber;
	}

	public void setNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRankCount() {
		return rankCount;
	}

	public void setRankCount(int rankCount) {
		this.rankCount = rankCount;
	}
	
	public String getUserMembership() {
		return userMembership;
	}

	public void setUserMembership(String userMembership) {
		this.userMembership = userMembership;
	}
	
}
