package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.CafeComment;

public interface CafeCommentRepository extends JpaRepository<CafeComment, Integer> {

}
