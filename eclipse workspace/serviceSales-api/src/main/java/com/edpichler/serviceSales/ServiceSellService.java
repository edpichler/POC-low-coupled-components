package com.edpichler.serviceSales;

import java.util.List;

import com.edpichler.serviceSales.dto.ServiceSellDTO;

public interface ServiceSellService {

	public ServiceSale doSale(ServiceSellDTO service);

	/**
	 * Cancel the service.
	 * */
	public void cancelSale(ServiceSale param);

	// find methods
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
