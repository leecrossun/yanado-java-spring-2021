package service.dto;

import java.util.List;
import javax.validation.constraints.NotNull;

public class CommonDTO {

	@NotNull
	Common common;

	String userId;

	@NotNull
	Product product;

	List<CommonJoin> joinList;

	public CommonDTO() {
	}

	public CommonDTO(Common common, String userId, Product product) {
		this.userId = userId;
		this.common = common;
		this.product = product;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Common getCommon() {
		return common;
	}

	public void setCommon(Common common) {
		this.common = common;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<CommonJoin> getJoinList() {
		return joinList;
	}

	public void setJoinList(List<CommonJoin> joinList) {
		this.joinList = joinList;
	};

}
