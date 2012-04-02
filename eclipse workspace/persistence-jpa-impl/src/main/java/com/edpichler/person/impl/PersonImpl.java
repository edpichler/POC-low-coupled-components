package com.edpichler.person.impl;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import com.edpichler.address.Address;
import com.edpichler.address.impl.AddressImpl;
import com.edpichler.person.CivilStatus;
import com.edpichler.person.Contact;
import com.edpichler.person.Person;

@RooToString
@RooJavaBean
@Entity
public class PersonImpl implements Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name, job;

	private String lastName;

	private String email;

	@OneToOne(fetch = FetchType.EAGER, targetEntity = AddressImpl.class, cascade = CascadeType.ALL)
	private Address address;
	
	@OneToMany(fetch = FetchType.EAGER, targetEntity = ContactImpl.class, cascade = CascadeType.ALL)
	private List<Contact> contacts;

	private CivilStatus civilStatus = CivilStatus.UNKNOWN;
}
