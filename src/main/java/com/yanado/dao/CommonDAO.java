package com.yanado.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yanado.dto.Common;
import com.yanado.dto.CommonJoin;
import com.yanado.dto.Product;
import com.yanado.dto.Search;

@Mapper
public interface CommonDAO {
	
	//나중에 삭제
	public Product findProduct(String productId);

	public int getCount();

	// Common CRUD

	public void insertCommon(Common common);

	public int updateCommon(Common common);

	public int deleteCommonByCommonId(String commonId);

	// List<Common> findAllCommon() {}

	public List<Common> findAllCommon(int start);

	public List<Common> findCommonBySearch(Search search);

	public Common findCommonByCommonId(String commonId);


	// 필드 한개만 변경될 시

	public int increaseJoin(String commonId);

	public int decreaseJoin(String commonId);

	public int changeStatus(@Param("commonId") String commonId, @Param("status") int status);

	// CommonJoin
	
	public int joinCommon(CommonJoin commonJoin);

	public int cancelCommon(CommonJoin commonJoin);

	public List<CommonJoin> findAllCommonJoinByCommonId(String commonId);
	
	public int findCommonJoin(CommonJoin commonJoin);
	
	public List<CommonJoin> notPayment(String commonId);

	// My Page
	public List<Common> findCommonByUserId(String userId);

}
