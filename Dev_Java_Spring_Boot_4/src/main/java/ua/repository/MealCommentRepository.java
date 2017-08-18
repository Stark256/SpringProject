package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.MealComment;

public interface MealCommentRepository extends JpaRepository<MealComment, Integer>{

}
