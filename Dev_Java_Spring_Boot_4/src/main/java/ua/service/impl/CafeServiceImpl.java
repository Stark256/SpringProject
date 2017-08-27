package ua.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Cafe;
import ua.entity.Type;
import ua.model.request.CafeRequest;
import ua.model.view.CafeView;
import ua.repository.CafeRepository;
import ua.service.CafeService;

@Service
public class CafeServiceImpl implements CafeService {

	private final CafeRepository repository;

	@Autowired
	public CafeServiceImpl(CafeRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<String> findAllOpenClose() {
		return repository.findAllOpenClose();
	}

	@Override
//	@Transactional(readOnly = true)
	public List<CafeView> findAllViews() {
		List<CafeView> views = repository.findAllViews();
		// views.forEach(this::loadOpenClose);
		return views;
	}

	// private void loadIngredients(MealView view) {
	// view.setIngredients(repository.findAllIngredientsByMealId(view.getId()));
	// }

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

	@Override
	public void save(CafeRequest request) {
		Cafe cafe=new Cafe();
		cafe.setName(request.getName());
		cafe.setId(request.getId());
		cafe.setRate(new BigDecimal(request.getRate()));
		cafe.setPhotoUrl(request.getPhotoUrl());
		cafe.setAddress(request.getAddress());
		cafe.setVersion(request.getVersion());
		cafe.setFullDescription(request.getFullDescription());
		cafe.setType(Type.valueOf(request.getType()));
		cafe.setPhone(request.getPhone());
		cafe.setEmail(request.getEmail());
		cafe.setOpen(request.getOpen());
		cafe.setClose(request.getClose());
		repository.save(cafe);
		
	}

	@Override
	public CafeRequest findOne(Integer id) {
		Cafe cafe=repository.findOne(id);
		CafeRequest request=new CafeRequest();
		request.setName(cafe.getName());
		request.setId(cafe.getId());
		request.setRate(String.valueOf(cafe.getRate()));
		request.setPhotoUrl(cafe.getPhotoUrl());
		request.setAddress(cafe.getAddress());
		request.setVersion(cafe.getVersion());
		request.setFullDescription(cafe.getFullDescription());
		request.setType(String.valueOf(cafe.getType()));
		request.setPhone(cafe.getPhone());
		request.setEmail(cafe.getEmail());
		request.setOpen(cafe.getOpen());
		request.setClose(cafe.getClose());		
		return request;
	}

	
}