package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Table;

public interface TableRepository extends JpaRepository<Table,Integer> {
  
	@Query("SELECT c.name FROM Cafe c")
  List<String> findAllCafe();

}