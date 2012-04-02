package com.edpichler.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.edpichler.jpa.ServiceServicesImpl;
import com.edpichler.service.crud.ServiceServices;
import com.edpichler.service.impl.ServiceImpl;

public class ServiceServicesTest {

	@Test
	/* Persist the Service and the related objects */
	public void testPersist() {
		ServiceServices serv = new ServiceServicesImpl();
		ServiceImpl c = new ServiceImpl();
		c.setName("Product Name");
		c.setDescription("Description");

		serv.persist(c);
		ServiceImpl found = serv.findById(ServiceImpl.class, c.getId());
		assertNotNull(found);

	}

	@Test
	/* Delete the Service but not the city */
	public void testDelete() {
		ServiceServices serv = new ServiceServicesImpl();
		ServiceImpl c = new ServiceImpl();
		c.setName("Product Name");
		c.setDescription("Description");

		serv.persist(c);
		ServiceImpl found = serv.findById(ServiceImpl.class, c.getId());
		assertNotNull(found);

		serv.remove(found);

		found = serv.findById(ServiceImpl.class, found.getId());
		assertNull(found);

	}

	@Test
	/*
	 * Insert some Servicees and found them, the city must be populated
	 * automaticaly.
	 */
	public void testFindAllClass() {
		ServiceServices serv = new ServiceServicesImpl();
		int qt = 3;
		for (int i = 0; i < qt; i++) {
			ServiceImpl c = new ServiceImpl();
			c.setName("Product Name");
			serv.persist(c);
		}
		List<ServiceImpl> found = serv.findAll(ServiceImpl.class, 100);
		assertTrue(found.size() >= qt);

	}

}
