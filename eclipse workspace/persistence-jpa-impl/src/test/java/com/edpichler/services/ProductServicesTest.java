package com.edpichler.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.edpichler.jpa.ProductServiceImpl;
import com.edpichler.product.crud.ProductService;
import com.edpichler.product.impl.ProductImpl;

public class ProductServicesTest {

	@Test
	/* Persist the Person and the related objects */
	public void testPersist() {
		ProductService serv = new ProductServiceImpl();
		ProductImpl c = new ProductImpl();
		c.setName("Product Name");
		serv.persist(c);
		
		ProductImpl found = serv.findById(ProductImpl.class, c.getId());
		assertNotNull(found);

	}

	@Test
	/* Delete the Person but not the city */
	public void testDelete() {
		ProductService serv = new ProductServiceImpl();
		ProductImpl c = new ProductImpl();
		c.setName("Product Name");
		serv.persist(c);

		ProductImpl found = serv.findById(ProductImpl.class, c.getId());
		assertNotNull(found);

		serv.remove(found);

		found = serv.findById(ProductImpl.class, found.getId());
		assertNull(found);

	}

	@Test
	/*
	 * Insert some Persones and found them, the city must be populated
	 * automaticaly.
	 */
	public void testFindAllClass() {
		ProductService serv = new ProductServiceImpl();
		int qt = 3;
		for (int i = 0; i < qt; i++) {
			ProductImpl c = new ProductImpl();
			c.setName("Product Name");
			serv.persist(c);
		}
		List<ProductImpl> found = serv.findAll(ProductImpl.class, 100);
		assertTrue(found.size() >= qt);

	}

}
