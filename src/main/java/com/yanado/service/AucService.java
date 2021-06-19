package com.yanado.service;

import com.yanado.dao.AucDAO;
import com.yanado.dto.Auc;

public class AucService {
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
}
