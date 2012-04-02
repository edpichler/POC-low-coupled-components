package com.edpichler.person;

public interface Contact {
	public Long getId();
	/** Examples: Email,Telephone, MSN, Gtalk, etc. */
	public String getServiceName();

	public String getContact();
}
