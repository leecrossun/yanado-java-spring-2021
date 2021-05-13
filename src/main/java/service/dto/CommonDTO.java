package service.dto;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Range;

public class CommonDTO {

	@NotNull
	String commonId;

	@NotNull
	String userId; // 게시자

	@NotNull
	Product product;

	@PositiveOrZero
	int participants;
	@Positive
	int min;

	@Range(min = 0, max = 5)
	int status; // 0 : 진행 전, 1 : 진행, 2 : 정원 미달, 3 : 최소인원 넘음, 4 : 파기, 5: 성공 (및 종료)

	@NotNull
	Date regDate;
	@NotNull
	Date startDate;
	@NotNull
	Date endDate;
	@NotNull
	Date deadline;

	List<Alarm> alarmList;
	List<CommonJoin> joinList;

	public CommonDTO() {
	};

	public CommonDTO(@NotNull String commonId, @NotNull String userId, @NotNull Product product,
			@PositiveOrZero int participants, @Positive int min, @Range(min = 0, max = 5) int status,
			@NotNull Date regDate, @NotNull Date startDate, @NotNull Date endDate, @NotNull Date deadline,
			List<Alarm> alarmList, List<CommonJoin> joinList) {
		super();
		this.commonId = commonId;
		this.userId = userId;
		this.product = product;
		this.participants = participants;
		this.min = min;
		this.status = status;
		this.regDate = regDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.deadline = deadline;
		this.alarmList = alarmList;
		this.joinList = joinList;
	}

	public CommonDTO(@NotNull String commonId, @NotNull String userId, @NotNull Product product,
			@PositiveOrZero int participants, @Positive int min, @Range(min = 0, max = 5) int status,
			@NotNull Date regDate, @NotNull Date startDate, @NotNull Date endDate, @NotNull Date deadline) {
		super();
		this.commonId = commonId;
		this.userId = userId;
		this.product = product;
		this.participants = participants;
		this.min = min;
		this.status = status;
		this.regDate = regDate;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

	public List<Alarm> getAlarmList() {
		return alarmList;
	}

	public void setAlarmList(List<Alarm> alarmList) {
		this.alarmList = alarmList;
	}

	public List<CommonJoin> getJoinList() {
		return joinList;
	}

	public void setJoinList(List<CommonJoin> joinList) {
		this.joinList = joinList;
	}

}
