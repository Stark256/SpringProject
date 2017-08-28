package ua.service;

import java.util.List;

import ua.model.request.CafeRequest;
import ua.model.view.CafeView;

public interface CafeService {

	
	List<String> findAllOpenClose();
	
	List<CafeView> findAllViews();
	
	void save(CafeRequest request);
	
	CafeRequest findOne(Integer id);
	
	void delete(Integer id);
}
