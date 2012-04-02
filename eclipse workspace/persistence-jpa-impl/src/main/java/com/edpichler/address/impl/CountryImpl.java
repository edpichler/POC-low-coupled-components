package com.edpichler.address.impl;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import com.edpichler.address.Country;
import com.edpichler.address.CountryState;

@RooToString
@RooJavaBean
@Entity
//@RooEntity
public class CountryImpl implements Country{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name, sign;
	
	@OneToMany(targetEntity=CountryStateImpl.class, cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)	
	private List<CountryState> states;
}
