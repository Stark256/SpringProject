package ua.model.view;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CafeCommentView {

	private String comment;
	
	
	private String user;
	
	private String time;
	
	private BigDecimal rate;

	public CafeCommentView(String comment, String user, LocalDateTime time,BigDecimal rate) {
		super();
		this.comment = comment;
		this.user = user;
		this.time = time.format(DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy"));
		this.rate=rate;
	}
	
	

	public BigDecimal getRate() {
		return rate;
	}



	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}



	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
 	
	
}
