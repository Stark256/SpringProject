package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.User;
import ua.repository.UserRepository;
import ua.service.UserService;

@Service
public class UserServiceImpl extends CrudServiceImpl<User,Integer> implements UserService{
@Autowired
	public UserServiceImpl(UserRepository repository) {
		super(repository);
	}

}
