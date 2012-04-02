package com.edpichler.address.modelo;

public interface CountryView {
		
	public String getName() ;

	public String getSign() ;
	
	//crud
	public void save();
	public void cancel();
	public void delete();
	
	//TODO FAZER a tela de procura do Country
	
}
