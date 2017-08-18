package ua.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.CafeComment;
import ua.repository.CafeCommentRepository;
import ua.service.CafeCommentService;

@Service
public class CafeCommentServiceImpl extends CrudServiceImpl<CafeComment,Integer> implements CafeCommentService{

	@Autowired
	public CafeCommentServiceImpl(CafeCommentRepository repository) {
		super(repository);
	}

}
