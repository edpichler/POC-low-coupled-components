package com.edpichler.inventory.impl;

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

import com.edpichler.inventory.MovmentType;
import com.edpichler.inventory.ProductMovment;
import com.edpichler.product.Product;
import com.edpichler.product.impl.ProductImpl;

@RooJavaBean
@RooToString
@Entity()
public class ProductMovmentImpl implements ProductMovment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	@ManyToOne(targetEntity = ProductImpl.class, cascade = CascadeType.REFRESH, optional = false, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "product")
	private Product product;

	@Basic(optional = false)
	@Column(nullable = false)
	private MovmentType movmentType;

	//TODO NAO ACEITAR QUANTIDADE NEGATIVAS
	private int quantity;

	@Basic(optional = false)
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date movmentDate;

	private String notes;

}
