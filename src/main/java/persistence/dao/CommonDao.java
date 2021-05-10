package dao;

import java.util.List;

import dto.Common;
import dto.CommonJoin;

public interface CommonDao {

	// Common CRUD

	public void createCommon(Common common);

	public void updateCommon(Common common);

	public void deleteCommonByCommonId(String commonId);

	// List<Common> findAllCommon() {}

	public List<Common> findAllCommon(int page, int size);

	public List<Common> findCommonBySearch(String condition, String search, int page, int size);

	public Common findCommonByCommonId(String commonId);

	public List<CommonJoin> notPayment(String commonId);
	
	
	// CommonJoin
	public void updateCommonStatus(String commonId, int status);

	public Common joinCommon(CommonJoin commonJoin);

	public void cancelCommon(String commonId, String userId);

	public List<CommonJoin> findAllCommonJoinByCommonId(String commonId);

	
	// My Page
	public List<Common> findCommonByUserId(String userId);

}
