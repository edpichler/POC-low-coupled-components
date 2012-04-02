package com.edpichler.address.impl;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import com.edpichler.address.Address;
import com.edpichler.address.City;

@RooJavaBean
@RooToString
@Entity
public class AddressImpl implements Address {

	private String street, complemento, postalCode;
	private int latitude;
	private int longitude;

	@ManyToOne(targetEntity = CityImpl.class, cascade = CascadeType.PERSIST, optional = false)
	private City city;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer version;
}
