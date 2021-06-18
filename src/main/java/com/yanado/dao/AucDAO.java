package com.yanado.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

@Mapper
public interface AucDAO extends JpaRepository {
	
	public void createAuc(Auc auc);
	public int updateAuc(Auc auc);
	public deleteAuc(String aucNo);
	
	Auc getAuc(int aucNo); //경매 물품 생성한 것 번호
	
	void regAuction(Auc auc); // 경매 물품 생성 + createProduct 필요
	
	boolean isParticipate(String userId);  // 경매 참여 자격이 있나 검사 - 로그인?  
	
	List<Auc> getMyAuc(String userId); // 사용자가 참여한 경매 리스트
	
	List<User> getBuyerListByAucNo(int aucNo); // 경매 참여한 사람들 리스트
	
	void changeStatus(String aucNo);
	
	Product findProductByAuc(String aucId); // 경매 상품 찾기

	List<Auc> findAucById(String aucId); //경매 ID 리스트
	
	List<Auc> findAucByProduct(String productId); //경매 물품 이름 리스트
	
	List<Auc> getAllAucList(); // 모든 경매 리스트
	
	void sendAlarm(Alarm alarm);
}
