package com.edpichler.services.util;

import java.util.Date;

import com.edpichler.inventory.MovmentType;
import com.edpichler.inventory.ProductMovment;
import com.edpichler.inventory.impl.ProductMovmentImpl;
import com.edpichler.jpa.ProductServiceImpl;
import com.edpichler.jpa.ServiceServicesImpl;
import com.edpichler.product.Product;
import com.edpichler.product.impl.ProductImpl;
import com.edpichler.service.Service;
import com.edpichler.service.impl.ServiceImpl;

public class Utils {

	public static Product createProduct() {
		ProductImpl impl = new ProductImpl();
		impl.setBarcode("Bar");
		impl.setDescription("desc");
		impl.setName("product name");
		new ProductServiceImpl().persist(impl);
		return impl;
	}

	public static ProductMovment createProductMovment() {

		ProductMovmentImpl retorno = new ProductMovmentImpl();
		retorno.setMovmentDate(new Date());
		retorno.setMovmentType(MovmentType.IN);
		retorno.setNotes("Some notas.");
		Product product = createProduct();
		retorno.setProduct(product);
		retorno.setQuantity((int) (100 * Math.random()));
		return retorno;

	}

	public static Long getRandomLong() {
		return (long) (Math.random() * 5);
	}

	public static int getRandomInt() {
		return (int) (Math.random() * 5);
	}

	public static Service createService() {
		ServiceImpl impl = new ServiceImpl();
		impl.setDescription("desc");
		impl.setName("product name");
		new ServiceServicesImpl().persist(impl);
		return impl;
	}

}
