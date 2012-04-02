package com.edpichler.inventory.process;

import java.util.Date;
import java.util.List;

import com.edpichler.inventory.ProductMovment;
import com.edpichler.product.Product;

public interface InventoryService {

	/**
	 * Do a movment.
	 * */
	public abstract void doInvetoryMovment(ProductMovment a);
	
	/**@return the quantity of the product on inventory.*/
	public int getQuantityInventory(Product p, Date date);
	
	/**@return the quantity of the product on inventory in the actual date.*/
	public int getQuantityInventory(Product p);
	
	public <T> List<T> findAll(Class<T> entity, int startIndex, int maxResults);

	public <T> List<T> findAll(Class<T> entity, int maxResults);
	
	public abstract <T> T findById(Class<T> entity, long id);

}
