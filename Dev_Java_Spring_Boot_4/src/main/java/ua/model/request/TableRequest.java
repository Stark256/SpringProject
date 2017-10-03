package ua.model.request;

import ua.entity.Cafe;
import ua.entity.OpenClose;

public class TableRequest {

	private Integer id;

	private OpenClose timeReserv;

	private int countOfPeople;

	private boolean isFree;

	private String user;

	private String userPhone;

	private Cafe cafe;

	private int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public OpenClose getTimeReserv() {
		return timeReserv;
	}

	public void setTimeReserv(OpenClose timeReserv) {
		this.timeReserv = timeReserv;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCountOfPeople() {
		return countOfPeople;
	}

	public void setCountOfPeople(int countOfPeople) {
		this.countOfPeople = countOfPeople;
	}

	public boolean getIsFree() {
		return isFree;
	}

	public void setIsFree(boolean isFree) {
		this.isFree = isFree;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Cafe getCafe() {
		return cafe;
	}

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}

}
