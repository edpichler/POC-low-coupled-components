package com.edpichler.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

class JPAServiceBase  {
	
	public void persist(Object o) {
		EntityManager ent = createEntityManager();
		ent.getTransaction().begin();
		ent.persist(o);
		ent.getTransaction().commit();
		ent.close();
	}
	
	public void remove(Object o) {
		EntityManager ent = createEntityManager();
		EntityTransaction transaction = ent.getTransaction();
		transaction.begin();

		if (!ent.contains(o)) {
			o = ent.merge(o);
		}
		ent.remove(o);

		transaction.commit();
		ent.close();
	}

	
	public void merge(Object o) {
		// JPA Entity Manager
		EntityManager ent = createEntityManager();
		ent.getTransaction().begin();
		ent.merge(o);
		ent.getTransaction().commit();
		ent.close();

	}

	
	public <T> List<T> findAll(Class<T> entity, int firstResult, int maxResults) {
		EntityManager ent = createEntityManager();
		TypedQuery<T> query = ent.createQuery(
				" SELECT a FROM " + entity.getSimpleName() + " a", entity);
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResults);
		List<T> resultList = query.getResultList();
		return resultList;
	}

	public <T> List<T> findAll(Class<T> entity, int maxResults) {
		return findAll(entity, 0, maxResults);
	}

	public <T> List<T> find(String anyValue, int startIndex, int maxResults) {
		throw new RuntimeException("Not implemented yet");
	}

	public <T> T findById(Class<T> entity, long id) {
		return createEntityManager().find(entity, id);
	}

	protected EntityManager createEntityManager() {
		return JPAUtil.createEntityManager();
	}

	public <T> List<T> find(String anyValue, int maxResults) {
		throw new RuntimeException("Not implemented yet");
	}
}