package ua.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comments")
public class CafeComment extends AbstractEntity{
	@Lob
	private String comment;
	
	private String name;
	
	private String email;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Cafe cafe;
	
	private int commComm;

	
	
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Cafe getCafe() {
		return cafe;
	}

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}

	public int getCommComm() {
		return commComm;
	}

	public void setCommComm(int commComm) {
		this.commComm = commComm;
	}
	
	
}
