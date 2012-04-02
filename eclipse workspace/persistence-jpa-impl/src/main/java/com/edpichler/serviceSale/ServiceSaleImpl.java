package com.edpichler.serviceSale;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import com.edpichler.service.Service;
import com.edpichler.serviceSales.SaleStatus;
import com.edpichler.serviceSales.ServiceSale;

@RooToString
@RooJavaBean
@Entity
public class ServiceSaleImpl implements ServiceSale {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private long total;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateSold;
	private Service service;

	private int quantityHours;
	private SaleStatus status;
	
}
