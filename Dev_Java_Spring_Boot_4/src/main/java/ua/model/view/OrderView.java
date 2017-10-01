package ua.model.view;

import java.util.ArrayList;
import java.util.List;


public class OrderView {

	private Integer id;
	
	private List<String> meals = new ArrayList<>();
	
	private int table;

	public OrderView(Integer id, int table) {
		this.id = id;
		this.table = table;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<String> getMeals() {
		return meals;
	}

	public void setMeals(List<String> meals) {
		this.meals = meals;
	}

	public int getTable() {
		return table;
	}

	public void setTable(int table) {
		this.table = table;
	}

	
	
	
}
