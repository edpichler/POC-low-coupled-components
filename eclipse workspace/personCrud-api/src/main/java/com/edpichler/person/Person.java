package com.edpichler.person;

import java.util.List;

import com.edpichler.address.Address;


public interface Person {
	
	public Long getId();

	public String getName();

	public String getLastName();

	public String getJob();
	
	public List<Contact> getContacts();
		
	public CivilStatus getCivilStatus();
	
	public Address getAddress();		
}
