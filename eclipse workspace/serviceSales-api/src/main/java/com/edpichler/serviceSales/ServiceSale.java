package com.edpichler.serviceSales;

import java.util.Date;

import com.edpichler.service.Service;

public interface ServiceSale {
	
	public Long getId();

		/**
	 * The total value of the products solds
	 * */
	public long getTotal();
	
	/**
	 * The date of product was sold
	 * */
	public Date getDateSold();

	public Service getService();

	public int getQuantityHours();
	
	
	public void setStatus(SaleStatus status);
	
	public SaleStatus getStatus();
	
}
