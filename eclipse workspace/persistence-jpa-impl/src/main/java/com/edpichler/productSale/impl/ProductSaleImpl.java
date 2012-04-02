package com.edpichler.productSale.impl;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import com.edpichler.inventory.ProductMovment;
import com.edpichler.inventory.impl.ProductMovmentImpl;
import com.edpichler.productSales.ProductSale;
import com.edpichler.productSales.SaleStatus;


@RooToString
@Entity
@RooJavaBean
public class ProductSaleImpl implements ProductSale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(targetEntity = ProductMovmentImpl.class, cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "productMovment")	
	private ProductMovment productMovment;
	
	private long total;
	
	@Column(nullable = false)
	@Basic(optional = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateSold;
	
	@Column(nullable = false)
	private SaleStatus status;

}
