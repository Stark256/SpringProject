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
@Table(name="meal_comment")
public class MealComment  extends AbstractEntity{
	@Lob
	private String comment;
	
	@ManyToOne
	private MealComment parentComment;
	
	@OneToMany(mappedBy="parentComment")
	private List<MealComment> childComment = new ArrayList<MealComment>();
	
	private int likee;
	
	private int dislike;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;

	@ManyToOne(fetch=FetchType.LAZY)
	private Meal meal;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public MealComment getParentComment() {
		return parentComment;
	}

	public void setParentComment(MealComment parentComment) {
		this.parentComment = parentComment;
	}

	public List<MealComment> getChildComment() {
		return childComment;
	}

	public void setChildComment(List<MealComment> childComment) {
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

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}
	
	
}
