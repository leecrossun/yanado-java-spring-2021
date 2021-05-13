package persistence.dao;

import java.util.List;

import service.dto.Common;
import service.dto.CommonJoin;

public interface CommonDao {

	// Common CRUD

	public String createCommon(Common common);

	public int updateCommon(Common common);

	public int deleteCommonByCommonId(String commonId);

	// List<Common> findAllCommon() {}

	public List<Common> findAllCommon(int start, int end);

	public List<Common> findCommonBySearch(String condition, String search, int start, int end);

	public Common findCommonByCommonId(String commonId);

	public List<CommonJoin> notPayment(String commonId);
	
	
	// CommonJoin
	public int updateCommonStatus(String commonId, int status);

	public String joinCommon(CommonJoin commonJoin);

	public int cancelCommon(String commonId, String userId);

	public List<CommonJoin> findAllCommonJoinByCommonId(String commonId);

	
	// My Page
	public List<Common> findCommonByUserId(String userId);

}
