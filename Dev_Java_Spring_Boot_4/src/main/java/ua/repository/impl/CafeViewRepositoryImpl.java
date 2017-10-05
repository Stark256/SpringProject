package ua.repository.impl;

import static org.springframework.data.jpa.repository.query.QueryUtils.toOrders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import ua.entity.Cafe;
import ua.model.filter.CafeFilter;
import ua.model.view.CafeIndexView;
import ua.model.view.CafeView;
import ua.repository.CafeViewRepository;

@Repository
public class CafeViewRepositoryImpl implements CafeViewRepository{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Page<CafeView> findAll(CafeFilter filter, Pageable pageable) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CafeView> cq = cb.createQuery(CafeView.class);
		Root<Cafe> root = cq.from(Cafe.class);
		cq.multiselect(root.get("id"), root.get("rate"), root.get("name"), root.get("photoUrl"), root.get("version"), root.get("address"), root.get("shortDescription"), root.get("type"));
		PredicateBuilder builder = new PredicateBuilder(filter, cb, root);
		Predicate predicate = builder.toPredicate();
		if(predicate!=null) cq.where(predicate);
		cq.orderBy(toOrders(pageable.getSort(), root, cb));
		List<CafeView> content = em.createQuery(cq)
				.setFirstResult(pageable.getPageNumber())
				.setMaxResults(pageable.getPageSize())
				.getResultList();
		CriteriaQuery<Long> cqCount = cb.createQuery(Long.class);
		Root<Cafe> rootCount = cqCount.from(Cafe.class);
		cqCount.select(cb.count(rootCount));
		PredicateBuilder builderCount = new PredicateBuilder(filter, cb, rootCount);
		Predicate predicateCount = builderCount.toPredicate();
		if(predicateCount!=null) cqCount.where(predicateCount);
		return PageableExecutionUtils.getPage(content, pageable, ()->em.createQuery(cqCount).getSingleResult());
	}
	
	private static class PredicateBuilder{
		
		final CafeFilter filter;
		
		final CriteriaBuilder cb;
		
		final Root<Cafe> root;
		
		final List<Predicate> predicates = new ArrayList<>();

		public PredicateBuilder(CafeFilter filter, CriteriaBuilder cb, Root<Cafe> root) {
			this.filter = filter;
			this.cb = cb;
			this.root = root;
		}
		
		void findByMinRate() {
			if(!filter.getMinRate().isEmpty()) {
				predicates.add(cb.ge(root.get("rate"), new BigDecimal(filter.getMinRate().replace(',', '.'))));
			}
		}
		
		void findByMaxRate() {
			if(!filter.getMaxRate().isEmpty()) {
				predicates.add(cb.le(root.get("rate"), new BigDecimal(filter.getMaxRate().replace(',', '.'))));
			}
		}
		
		void findByTypes() {
			if(!filter.getTypes().isEmpty()) {
				predicates.add(root.get("type").in(filter.getTypes()));
			}
		}
		
		void findMinOpen() {
			if(!filter.getMinOpen().isEmpty()){
				predicates.add(root.get("open").in(filter.getMinOpen()));
			}
		}
		
		void findMaxOpen() {
			if(!filter.getMaxOpen().isEmpty()){
				predicates.add(root.get("open").in(filter.getMaxOpen()));
			}
		}
		
		void findMinClose() {
			if(!filter.getMinClose().isEmpty()){
				predicates.add(root.get("close").in(filter.getMinClose()));
			}
		}
		
		void findMaxClose() {
			if(!filter.getMaxClose().isEmpty()){
				predicates.add(root.get("close").in(filter.getMaxClose()));
			}
		}
		
		Predicate toPredicate() {
			findByMinRate();
			findByMaxRate();
			findByTypes();
			findMinOpen();
			findMaxOpen();
			findMinClose();
			findMaxClose();
			return cb.and(predicates.stream().toArray(Predicate[]::new));
		}
	}
}
