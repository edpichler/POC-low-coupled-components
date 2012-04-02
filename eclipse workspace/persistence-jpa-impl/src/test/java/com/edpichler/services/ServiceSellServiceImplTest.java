package com.edpichler.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

import com.edpichler.jpa.ServiceSellServiceImpl;
import com.edpichler.serviceSale.ServiceSaleImpl;
import com.edpichler.serviceSales.SaleStatus;
import com.edpichler.serviceSales.ServiceSale;
import com.edpichler.serviceSales.dto.ServiceSellDTO;
import com.edpichler.services.util.Utils;

public class ServiceSellServiceImplTest {

	@Test
	/* Verifica se vende */
	public void testDoSale() {
		ServiceSellServiceImpl ser = new ServiceSellServiceImpl();
		ServiceSale sold = ser.doSale(getDTO());
		ServiceSaleImpl found = ser.findById(ServiceSaleImpl.class,
				sold.getId());
		assertNotNull(found);

		assertEquals(SaleStatus.ACTIVE, found.getStatus());
	}

	private ServiceSellDTO getDTO() {
		ServiceSellDTO dto = new ServiceSellDTO();
		dto.setDateOcurried(new Date());
		dto.setQuantityHours(Utils.getRandomInt());
		dto.setValueTotal(Utils.getRandomLong());
		dto.setService(Utils.createService());
		return dto;
	}

	@Test
	/* Verifica se cancela */
	public void testCancelSale() {
		ServiceSellServiceImpl ser = new ServiceSellServiceImpl();
		ServiceSale sold = ser.doSale(getDTO());
		ServiceSaleImpl found = ser.findById(ServiceSaleImpl.class,
				sold.getId());
		assertNotNull(found);

		ser.cancelSale(found);

		found = ser.findById(ServiceSaleImpl.class, sold.getId());
		assertEquals(SaleStatus.CANCELED, found.getStatus());
	}
}
