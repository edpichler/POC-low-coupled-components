package com.edpichler.address;

/**
 * Endereço.
 * */
public interface Address {

	public String getStreet();

	public String getComplemento();

	public String getPostalCode();

	public int getLatitude();

	public int getLongitude();

	public City getCity();

	public Long getId();

	public Integer getVersion();
}
