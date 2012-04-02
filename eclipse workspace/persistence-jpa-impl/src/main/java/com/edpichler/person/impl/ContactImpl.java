package com.edpichler.person.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import com.edpichler.person.Contact;

@RooJavaBean
@RooToString 
@Entity
public class ContactImpl implements Contact{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String serviceName, contact;
}
