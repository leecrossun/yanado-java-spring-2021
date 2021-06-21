package com.yanado.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yanado.dto.Alarm;
import com.yanado.dto.Auc;
import com.yanado.dto.AucJoin;
import com.yanado.dto.CommonJoin;
import com.yanado.dto.User;

@Mapper
public interface AucDAO {
	
	public int createAuc(Auc auc);
	public int updateAuc(Auc auc);
	public int deleteAuc(String aucNo);
	
	public List<Auc> findAucByAucNo(String AucNo); //경매 물품 이름 리스트
	
	public Auc findAucByUserId(String userId);

	public Auc findAucHighestByAucNo(String AucNo);
	
	public int cancelAuc(AucJoin aucJoin);
	public int cancelAllAucJoin(String aucNo);
	public int AucJoin(AucJoin aucJoin);
}
