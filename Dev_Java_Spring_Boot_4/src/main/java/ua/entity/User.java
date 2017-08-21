package ua.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User  extends AbstractEntity{

	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String photoUrl;
	
	private String login;
	
	private String password;
	
	private LocalDate birthday;
	
	@OneToMany(mappedBy="user")
	private List<CafeComment> cafeComment=new ArrayList<CafeComment>();
	
	@OneToMany(mappedBy="user")
	private List<MealComment> mealComment=new ArrayList<MealComment>();

	
	
	public User() {
	}

	
	
	public User(String firstName, String lastName, String email, String login, String password, LocalDate birthday) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.login = login;
		this.password = password;
		this.birthday = birthday;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
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
