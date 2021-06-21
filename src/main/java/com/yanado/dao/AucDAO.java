package com.yanado.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yanado.dto.Alarm;
import com.yanado.dto.Auc;
import com.yanado.dto.Product;
import com.yanado.dto.User;

@Mapper
public interface AucDAO {
	
	public int createAuc(Auc auc);
	public int updateAuc(Auc auc);
	public int deleteAuc(String aucNo);
	
	public List<Auc> findAucByAucNo(String AucNo); //경매 물품 이름 리스트
	
	List<Auc> getAllAucList(); // 모든 경매 리스트
	
	List<Auc> getMyAuc(String userId); // 사용자가 참여한 경매 리스트
	
//	List<Auc> findAucByaucNo(String aucNo); //경매 ID 리스트
	
	Product findProductByAuc(String aucNo);
	
	Auc getAuc(String aucNo); //경매 물품 생성한 것 번호
	
//	void regAuction(Auc auc); // 경매 물품 생성 + createProduct 필요

	
//	boolean isParticipate(String userId);  // 경매 참여 자격이 있나 검사 - 로그인?  
	
	// void changeStatus(String aucNo);
	public int changeStatus(@Param("aucId") String aucId, @Param("status") int status);
	
	List<User> getBuyerListByAucNo(int userId); // 경매 참여한 사람들 리스트
	
	List<Auc> getAucByUserId(String userId);
}
