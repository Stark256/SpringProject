package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User extends AbstractEntity {

	private String email;

	private String password;

	private Role role;

	@OneToMany(mappedBy = "user")
	private List<CafeComment> cafeComment = new ArrayList<CafeComment>();

	@OneToMany(mappedBy = "user")
	private List<MealComment> mealComment = new ArrayList<MealComment>();

	@OneToMany(mappedBy = "user")
	private List<Cafe> cafes = new ArrayList<Cafe>();

	public User() {
	}

	public User(String email, String password, Role role) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Cafe> getCafes() {
		return cafes;
	}

	public void setCafes(List<Cafe> cafes) {
		this.cafes = cafes;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<CafeComment> getCafeComment() {
		return cafeComment;
	}

	public void setCafeComment(List<CafeComment> cafeComment) {
		this.cafeComment = cafeComment;
	}

	public List<MealComment> getMealComment() {
		return mealComment;
	}

	public void setMealComment(List<MealComment> mealComment) {
		this.mealComment = mealComment;
	}

}
