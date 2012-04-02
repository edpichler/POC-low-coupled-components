package com.edpichler.jpa;

import java.util.List;

import com.edpichler.address.crud.AddressCrudService;

public class AddressServiceImpl extends JPAServiceBase implements AddressCrudService {

	@Override
	public void persist(Object a) {
		super.persist(a);
	}

	@Override
	public void remove(Object a) {
		super.remove(a);

	}

	@Override
	public void merge(Object o) {
		super.persist(o);

	}
	@Override
	public <T> List<T> findAll(Class<T> entity, int startIndex, int maxResults) {
		return super.findAll(entity, startIndex, maxResults);
	}

	@Override
	public <T> List<T> findAll(Class<T> entity, int maxResults) {
		return super.findAll(entity, 0, maxResults);
	}

	@Override
	public <T> List<T> find(String anyValue, int startIndex, int maxResults) {
		return super.find(anyValue, startIndex, maxResults);
	}

	@Override
	public <T> List<T> find(String anyValue, int maxResults) {
		return super.find(anyValue, 0, maxResults);
	}

	@Override
	public <T> T findById(Class<T> entity, long id) {
		return super.findById(entity, id);
	}
}
