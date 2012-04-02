package com.edpichler.inventory;

import java.util.Date;

import com.edpichler.product.Product;

public interface ProductMovment {

	public Long getId();

	/**
	 * The Product sold.
	 * */
	public Product getProduct();

	/**
	 * Moviment type.
	 * */
	public MovmentType getMovmentType();

	/** The quantity. */
	public int getQuantity();

	/**
	 * The date of product was sold.
	 **/
	public Date getMovmentDate();
	
	/**Notes about the moviment.*/
	public String getNotes();

	/** The quantity. */
	public void setQuantity(int qt);
}
