package com.yanado.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yanado.dao.AucDAO;
import com.yanado.dto.Auc;
import com.yanado.dto.AucJoin;

@Service
@Transactional
public class AucService {
	@Autowired
	private AucDAO aucDAO;
	
	public void createAuc(Auc auc) {
		aucDAO.createAuc(auc);
	}
	
	public int updateAuc(Auc auc) {
		return aucDAO.updateAuc(auc);
	}
	public int deleteAuc(String aucNo) {
		return aucDAO.deleteAuc(aucNo);
	}
	
	public List<Auc> findAucByaucNo(String aucNo){
		return aucDAO.findAucByAucNo(aucNo);
	}
	
	public Auc getAuc(String aucId) {
		return aucDAO.getAuc(aucId);
	}
	
	public List<AucJoin> getAucJoinByAucId(String aucId){
		return aucDAO.getAucJoinByAucId(aucId);
	}
	
	public List<Auc> getAllAucList(){
		return aucDAO.getAllAucList();
	}
	
	public List<Auc> getAucByUserId(String userId){
		return aucDAO.getAucByUserId(userId);
	}
	
	public int joinAuc(AucJoin aucJoin) {
		return aucDAO.joinAuc(aucJoin);
	}
	
	public List<Auc> filterAuc(int key){
		return aucDAO.filterAuc(key);
	}
	
	public Auc findAucByProductId(String productId) {
		return aucDAO.findAucByProductId(productId);
	}
}



