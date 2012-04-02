package com.edpichler.address;

import java.util.List;

public interface Country {
	
	public Long getId();

	public String getName();

	public String getSign();

	public void setId(Long id);

	public List<CountryState> getStates();
}
