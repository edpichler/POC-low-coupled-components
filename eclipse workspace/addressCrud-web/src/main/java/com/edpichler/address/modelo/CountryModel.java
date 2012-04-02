package com.edpichler.address.modelo;

import com.edpichler.address.Country;
import com.edpichler.address.crud.AddressCrudService;

public class CountryModel {
	
	private AddressCrudService persistence;//TODO MUST BE INJECTED
	
	public void save(Country country) {
		persistence.persist(country);
	}

	public void remove(Country country) {
		persistence.remove(country);		
	}	
}
