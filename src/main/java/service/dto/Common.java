package service.dto;

import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Range;

import lombok.Getter;

@Getter
public class Common {
	String commonId;

	@NotNull
	String userId; // 게시자

	@NotNull
	String productId;
	@PositiveOrZero
	int participants;
	@Positive
	int min;

	@Range(min = 0, max = 5)
	int status; // 0 : 진행 전, 1 : 진행, 2 : 정원 미달, 3 : 최소인원 넘음, 4 : 파기, 5: 성공 (및 종료)

	Date regDate;

	@NotNull
	Date startDate;
	@NotNull
	Date endDate;
	@NotNull
	Date deadline;

	public Common() {
	}

	public Common(String commonId, String userId, String productId, int participants, int min, int status, Date regDate,
			Date startDate, Date endDate, Date deadline) {
		this.commonId = commonId;
		this.userId = userId;
		this.productId = productId;
		this.participants = participants;
		this.min = min;
		this.status = status;
		this.regDate = regDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.deadline = deadline;
	}

	public Common(String userId, String productId, int participants, int min, int status, Date regDate, Date startDate,
			Date endDate, Date deadline) {
		this.userId = userId;
		this.productId = productId;
		this.participants = participants;
		this.min = min;
		this.status = status;
		this.regDate = regDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.deadline = deadline;
	}

	public Common(String productId, int min, CommonJoin join, Date startDate, Date endDate, Date deadline) {
		super();
		this.productId = productId;
		this.min = min;
		this.startDate = startDate;
		this.endDate = endDate;
		this.deadline = deadline;
	}

	public String getCommonId() {
		return commonId;
	}

	public void setCommonId(String commonId) {
		this.commonId = commonId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getParticipants() {
		return participants;
	}

	public void setParticipants(int participants) {
		this.participants = participants;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

}
