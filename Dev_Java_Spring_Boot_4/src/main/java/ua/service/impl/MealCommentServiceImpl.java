package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.entity.MealComment;
import ua.repository.MealCommentRepository;
import ua.service.MealCommentService;

@Service
public class MealCommentServiceImpl extends CrudServiceImpl<MealComment,Integer> implements MealCommentService{

	@Autowired
	public MealCommentServiceImpl(MealCommentRepository repository) {
		super(repository);
	}

}
