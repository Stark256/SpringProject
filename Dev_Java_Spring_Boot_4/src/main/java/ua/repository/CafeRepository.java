package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Cafe;
import ua.model.view.CafeView;

public interface CafeRepository extends JpaRepository<Cafe, Integer>{

//	@Query("FROM Cafe WHERE name=?1")
//	Cafe findByName(String name);
	
	@Query("SELECT new ua.model.view.CafeView(c.id, c.rate, c.name, c.photoUrl, c.version, c.address,c.fullDescription, c.type, c.phone, c.email, open.open, close.close) FROM Cafe c JOIN c.open open JOIN c.close close")
	List<CafeView> findAllViews();
	
	@Query("SELECT t.time FROM OpenCloce t")
	List<String> findAllOpenClose();
	
	@Query("SELECT o.time FROM OpenCloce o JOIN i.meals m WHERE m.id=?1")
	List<String> findAllTimesByOpenCloceId(Integer id);
	
//	@Query("SELECT i.name FROM Ingredient i JOIN i.meals m WHERE m.id=?1")
//	List<String> findAllIngredientsByMealId(Integer id);
	
	@Query("SELECT DISTINCT c FROM Cafe c JOIN FETCH c.open LEFT JOIN FETCH c.close WHERE c.id=?1")
	Cafe findOneRequest(Integer id);
}
