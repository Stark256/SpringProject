package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cafe_comment")
public class CafeComment extends AbstractEntity{
	
	@Lob
	private String comment;
	
	@ManyToOne
	private CafeComment parentComment;
	
	@OneToMany(mappedBy="parentComment")
	private List<CafeComment> childComment = new ArrayList<CafeComment>();
	
	private int likee;
	
	private int dislike;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Cafe cafe;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public CafeComment getParentComment() {
		return parentComment;
	}

	public void setParentComment(CafeComment parentComment) {
		this.parentComment = parentComment;
	}

	public List<CafeComment> getChildComment() {
		return childComment;
	}

	public void setChildComment(List<CafeComment> childComment) {
		this.childComment = childComment;
	}

	public int getLike() {
		return likee;
	}

	public void setLike(int like) {
		this.likee = like;
	}

	public int getDislike() {
		return dislike;
	}

	public void setDislike(int dislike) {
		this.dislike = dislike;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Cafe getCafe() {
		return cafe;
	}

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}
	
	
}
