package com.edpichler.serviceSales.dto;

import java.util.Date;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import com.edpichler.service.Service;

@RooJavaBean
@RooToString
public class ServiceSellDTO {
	private Service service;
	private int quantityHours;
	private Date dateOcurried;
	private Long valueTotal;
}
