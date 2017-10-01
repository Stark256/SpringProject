package ua.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Order;
import ua.entity.Table;
import ua.model.request.OrderRequest;
import ua.model.view.OrderView;
import ua.repository.OrderRepository;
import ua.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	private final OrderRepository repository;

	 @Autowired
	  public OrderServiceImpl(OrderRepository repository) {
	    this.repository = repository;
	  }

	@Override
	public void save(OrderRequest request) {
		Order order=new Order();
		order.setId(request.getId());
		order.setMeals(request.getMeals());
		order.setTable(request.getTable());
		repository.save(order);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

	@Override
	public OrderRequest findOne(Integer id) {
		Order order=repository.findOneRequest(id);
		OrderRequest request = new OrderRequest();
		request.setId(order.getId());
		request.setMeals(order.getMeals());
		request.setTable(order.getTable());
		return request;
	}
	
	

	@Override
	public List<OrderView> findAllViews() {
		return repository.findAllViews();
	}
	
	@Override
	public List<String> findAllMealByCafeId(Integer id) {
		return repository.findAllMealByCafeId(id);
	}
	
	
	
	 @Override
	@Transactional(readOnly=true)
	public List<OrderView> findAllOrdersByCafeId(Integer id) {
		List<OrderView> views = repository.findAllOrdersByCafeId(id);
		views.forEach(this::loadMeals);
		return views;
	}
	
	private void loadMeals(OrderView view) {
		view.setMeals(repository.findAllMealsByOrderId(view.getId()));
		//view.setIngredients(repository.findAllIngredientsByMealId(view.getId()));
	}



	@Override
	public Table findOneTable(Integer id) {
		return repository.findOneTable(id);
	}

	@Override
	public Order findOneOrderByTableId(Integer id) {
		return repository.findOneOrderByTableId(id);
	}

	

	

}
