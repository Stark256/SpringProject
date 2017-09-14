package ua.repository;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import ua.entity.Cafe;
import ua.model.request.CafeRequest;
import ua.model.view.CafeIndexView;
import ua.model.view.CafeView;

public interface CafeRepository extends JpaNameRepository<Cafe>{

	
	@Query("SELECT new ua.model.view.CafeView(c.id, c.rate, c.name, c.photoUrl, c.version, c.address,c.fullDescription, c.type, c.phone, op.time, cl.time) FROM Cafe c JOIN c.open op JOIN c.close cl")
	List<CafeView> findAllViews();
	
	@Query("SELECT t.time FROM OpenClose t")
	List<LocalTime> findAllOpenClose();
	
	@Query("SELECT DISTINCT c FROM Cafe c JOIN FETCH c.open JOIN FETCH c.close WHERE c.id=?1")
	Cafe findOneRequest(Integer id);
	
	@Query("SELECT  c FROM Cafe c JOIN FETCH c.open JOIN FETCH c.close WHERE c.id=?1")
	Cafe findOneDesc(Integer id);
}
