package com.edpichler.address.impl;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import com.edpichler.address.City;
import com.edpichler.address.CountryState;

@RooJavaBean
@RooToString
@Entity
public class CityImpl implements City {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	
	@ManyToOne(targetEntity=CountryStateImpl.class, cascade=CascadeType.PERSIST)
	private CountryState state;

}
