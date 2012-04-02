package com.edpichler.address.modelo;

import com.edpichler.address.Country;
//import com.edpichler.address.impl.CountryImpl;

public class CountryController {
	
	private CountryView view;
	
	private CountryModel model = new CountryModel();
	
	public CountryController(CountryView view){
		this.view = view;
	}
	
	public void save(){
		Country country = getCountry();
		model.save(country);		
	}
	
	public void delete(){
		Country country = getCountry();
		model.remove(country);		
	}
		
	public Country getCountry(){		
//		CountryImpl imp = new Country
//		imp.setName(view.getName());
//		imp.setSign(view.getSign());		
//		return imp;
		return null;
	}
}
