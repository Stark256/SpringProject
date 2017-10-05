package ua.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.model.filter.CafeFilter;
import ua.model.view.CafeIndexView;
import ua.model.view.CafeView;

public interface CafeViewRepository {

	Page<CafeView> findAll(CafeFilter filter, Pageable pageable);
}
