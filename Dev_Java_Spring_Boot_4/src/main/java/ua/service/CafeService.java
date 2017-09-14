package ua.service;

import java.time.LocalTime;
import java.util.List;

import ua.entity.Type;
import ua.model.request.CafeRequest;
import ua.model.view.CafeIndexView;
import ua.model.view.CafeView;

public interface CafeService {
	
	//extends CrudService<Cafe, Integer>
	List<Type> findAllTypes();

	List<LocalTime> findAllOpenCloses();

	List<CafeView> findAllViews();

	void save(CafeRequest request);

	CafeRequest findOne(Integer id);

	void delete(Integer id);
	
	CafeRequest findOneDesc(Integer id);

}
