package com.edpichler.productSales;

import java.util.List;

import com.edpichler.productSales.dto.ProductSellDTO;

public interface ProductSellService {

	public ProductSale doSell(ProductSellDTO p);

	/**
	 * Cancel the sale and refund the product in the inventory.
	 * */
	public void cancelSale(ProductSale a);

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
