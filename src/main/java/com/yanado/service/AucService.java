package com.yanado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yanado.dao.AucDAO;
import com.yanado.dto.Auc;

@Service
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
}



