package ua.model.request;

import java.math.BigDecimal;

import ua.entity.Cafe;
import ua.entity.CafeComment;


public class CafeCommentRequest {

	private Integer id;

	private String comment;
	
	private String user;
	
	private BigDecimal rate;
	
	private Cafe cafe;
	
	private CafeComment parentComment;
	
	

	public CafeComment getParentComment() {
		return parentComment;
	}

	public void setParentComment(CafeComment parentComment) {
		this.parentComment = parentComment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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


	public Cafe getCafe() {
		return cafe;
	}

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	
	
}
