package ua.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Table;
import ua.repository.TableRepository;
import ua.service.TableService;

@Service
public class TableServiceImpl extends CrudServiceImpl<Table, Integer> implements TableService {
	private final TableRepository repository;

	@Autowired
	public TableServiceImpl(TableRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public List<String> findAllCafes() {
		return repository.findAllCafe();
	}

}