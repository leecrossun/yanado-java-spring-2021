package com.yanado.dao;

public interface AucDAO {
	boolean isParticipate(String userId);  // 경매 참여 자격이 있나 검사 - 로그인?  
	
	List<Auc> getAllAucList(); // 모든 경매 리스트
	
	Auc getAuc(int aucNo); //경매 물품 생성한 것 번호
	
	void regAuction(Auc auc); // 경매 물품 생성 + createProduct 필요
	
	List<Auc> findAucById(String aucId); //경매 ID 리스트
	
	List<Auc> findAucByProduct(String productId); //경매 물품 이름 리스트
	
	List<Auc> getMyAuc(String userNo); // 사용자가 참여한 경매 리스트
	
	List<User> getBuyerListByAucNo(int aucNo); // 경매 참여한 사람들 리스트
	
	void sendAlarm(Alarm alarm);
	
	void changeStatus(String aucNo);
	
	Product findProductByAuc(String aucId); // 경매 상품 찾기

}
