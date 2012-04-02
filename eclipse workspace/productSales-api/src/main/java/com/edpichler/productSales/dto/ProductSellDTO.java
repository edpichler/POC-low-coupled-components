package com.edpichler.productSales.dto;

import java.util.Date;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import com.edpichler.product.Product;

@RooJavaBean
@RooToString
public class ProductSellDTO {
	private Product product;
	private int quantity;
	private Date dateOcurried;
	private Long valueTotal;
} 
