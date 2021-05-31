package service.dto;
import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Range;

public class Alarm {
	
	String alarmId;
	@NotNull
	String typeId; // typeId = commonId or AuctionId
	@Range(min= 0, max=7)
	int type; // 1 : common result, 2 : common notice, 3 : common etc
			  // 4 : auction result, 5 : auction notice, 6 : auction etc
	@PositiveOrZero
	int price;
	String message;
	Date sendDate;
	Date deadline;
	
	public Alarm() {}

	public Alarm(String alarmId, String typeId, int type, int price, String message, Date sendDate, Date deadline) {
		this.alarmId = alarmId;
		this.typeId = typeId;
		this.type = type;
		this.price = price;
		this.message = message;
		this.sendDate = sendDate;
		this.deadline = deadline;
	}

	public Alarm(String typeId, int type, int price, String message, Date sendDate, Date deadline) {
		this.typeId = typeId;
		this.type = type;
		this.price = price;
		this.message = message;
		this.sendDate = sendDate;
		this.deadline = deadline;
	}

	public String getAlarmId() {
		return alarmId;
	}

	public void setAlarmId(String alarmId) {
		this.alarmId = alarmId;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

}
