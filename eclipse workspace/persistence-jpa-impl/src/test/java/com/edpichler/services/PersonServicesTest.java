package com.edpichler.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.edpichler.address.Address;
import com.edpichler.address.City;
import com.edpichler.address.Country;
import com.edpichler.address.CountryState;
import com.edpichler.address.impl.AddressImpl;
import com.edpichler.address.impl.CityImpl;
import com.edpichler.address.impl.CountryImpl;
import com.edpichler.address.impl.CountryStateImpl;
import com.edpichler.jpa.PersonServiceImpl;
import com.edpichler.person.CivilStatus;
import com.edpichler.person.Contact;
import com.edpichler.person.crud.PersonService;
import com.edpichler.person.impl.ContactImpl;
import com.edpichler.person.impl.PersonImpl;

public class PersonServicesTest {

	@Test
	/* Persist the Person and the related objects */
	public void testPersist() {
		PersonService serv = new PersonServiceImpl();
		PersonImpl c = new PersonImpl();
		c.setAddress(getAddress());
		serv.persist(c);
		c.setCivilStatus(CivilStatus.MARRIED);
		List<Contact> contacts = getContacts();
		c.setContacts(contacts);
		
		PersonImpl found = serv.findById(PersonImpl.class, c.getId());
		assertNotNull(found);

		Address s = (Address) serv.findById(AddressImpl.class, found.getId());
		assertNull(s);
	}

	private City getCity() {
		CityImpl a = new CityImpl();
		a.setName("Blumenau");
		a.setState(getState());
		return a;
	}

	private CountryState getState() {
		CountryStateImpl s = new CountryStateImpl();
		s.setName("Holy Catarina");
		s.setSign("SC");
		s.setCountry(getCountry());
		return s;
	}

	private Country getCountry() {
		CountryImpl c = new CountryImpl();
		c.setName("Germany");
		c.setSign("GER");
		return c;
	}

	@Test
	/* Delete the Person but not the city */
	public void testDelete() {
		PersonService serv = new PersonServiceImpl();
		PersonImpl c = new PersonImpl();
		c.setName("Juca");
		Address ad = getAddress();
		c.setAddress(ad);
		c.setCivilStatus(CivilStatus.MARRIED);
		List<Contact> contacts = getContacts();
		c.setContacts(contacts);

		serv.persist(c);

		PersonImpl found = serv.findById(PersonImpl.class, c.getId());
		assertNotNull(found);

		serv.remove(found);

		found = serv.findById(PersonImpl.class, found.getId());
		assertNull(found);

		assertNull(serv.findById(AddressImpl.class, ad.getId()));
		
		assertNull(serv.findById(ContactImpl.class, contacts.get(0).getId()));
	}

	private List<Contact> getContacts() {
		List<Contact> lis = new ArrayList<Contact>();

		for (int i = 0; i < 2; i++) {
			ContactImpl c = new ContactImpl();
			c.setContact(i + "gtalk@gtalk.com");
			c.setServiceName("gtalk");
			lis.add(c);
		}

		return lis;
	}

	private Address getAddress() {
		AddressImpl ad = new AddressImpl();
		ad.setCity(getCity());
		ad.setStreet("rua das bromélias");
		return ad;
	}

	@Test
	/*
	 * Insert some Persones and found them, the city must be populated
	 * automaticaly.
	 */
	public void testFindAllClass() {
		PersonService serv = new PersonServiceImpl();
		int qt = 3;
		for (int i = 0; i < qt; i++) {
			PersonImpl c = new PersonImpl();
			c.setName("Bradock");
			c.setAddress(getAddress());
			serv.persist(c);
		}
		List<PersonImpl> found = serv.findAll(PersonImpl.class, 100);
		assertTrue(found.size() >= qt);

		for (PersonImpl ci : found) {
			assertNotNull(ci.getAddress());
		}
	}

}
