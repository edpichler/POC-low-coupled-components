package com.edpichler.person.crud;

import java.util.List;

public interface PersonService {

	//persist
	public abstract void persist(Object a);
	
	//delete
	public  void  remove(Object a);	
	
	//update
	public abstract void merge(Object o);
	
	//find methods
	public <T> List<T> findAll(Class<T> entity, int startIndex, int maxResults);
	public <T> List<T> findAll(Class<T> entity, int maxResults);
	
	/**
	 * Will do a search in all fields using the parameter anyValue.
	 * */
	public <T> List<T> find(String anyValue, int startIndex, int maxResults);
	/**
	 * Will do a search in all fields using the parameter anyValue.
	 * */
	public <T> List<T> find(String anyValue, int maxResults);
	
		
	public abstract <T> T findById(Class<T> entity, long id);
	
}
