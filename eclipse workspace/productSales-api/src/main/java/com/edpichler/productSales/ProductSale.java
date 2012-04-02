package com.edpichler.productSales;

import java.util.Date;

import com.edpichler.inventory.ProductMovment;

public interface ProductSale {
	
	public Long getId();

		/**
	 * The total value of the products solds
	 * */
	public long getTotal();
	
	/**
	 * The date of product was sold
	 * */
	public Date getDateSold();

	public ProductMovment getProductMovment();

	public void setStatus(SaleStatus status);
	
	public SaleStatus getStatus();
	
}
