package com.edpichler.address.impl;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import com.edpichler.address.Country;
import com.edpichler.address.CountryState;

@RooJavaBean
@RooToString
@Entity
public class CountryStateImpl implements CountryState {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String sign, name;
	
	@ManyToOne(targetEntity=CountryImpl.class, cascade=CascadeType.PERSIST, fetch=FetchType.EAGER, optional=false )
	private Country country;
}