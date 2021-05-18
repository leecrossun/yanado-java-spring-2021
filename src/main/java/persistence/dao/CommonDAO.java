package persistence.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import service.dto.Common;
import service.dto.CommonJoin;
import service.dto.Search;

public interface CommonDAO {

	public int getCount();

	// Common CRUD

	public String insertCommon(Common common);

	public int updateCommon(Common common);

	public int deleteCommonByCommonId(String commonId);

	// List<Common> findAllCommon() {}

	public List<Common> findAllCommon(int start, int end);

	public List<Common> findCommonBySearch(Search search);

	public Common findCommonByCommonId(String commonId);


	// 필드 한개만 변경될 시

	public int increaseJoin(String commonId);

	public int decreaseJoin(String commonId);

	public int changeStatus(@Param("commonId") String commonId, @Param("status") int status);

	// CommonJoin
	
	public String joinCommon(CommonJoin commonJoin);

	public int cancelCommon(CommonJoin commonJoin);

	public List<CommonJoin> findAllCommonJoinByCommonId(String commonId);
	
	public List<CommonJoin> notPayment(String commonId);

	// My Page
	public List<Common> findCommonByUserId(String userId);

}
