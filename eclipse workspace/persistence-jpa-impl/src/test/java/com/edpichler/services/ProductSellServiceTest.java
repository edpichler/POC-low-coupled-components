package com.edpichler.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import com.edpichler.inventory.MovmentType;
import com.edpichler.inventory.process.InventoryService;
import com.edpichler.jpa.InventoryServiceImpl;
import com.edpichler.jpa.ProductSellServiceImpl;
import com.edpichler.productSale.impl.ProductSaleImpl;
import com.edpichler.productSales.ProductSale;
import com.edpichler.productSales.ProductSellService;
import com.edpichler.productSales.SaleStatus;
import com.edpichler.productSales.dto.ProductSellDTO;
import com.edpichler.services.util.Utils;

public class ProductSellServiceTest {

	@Test
	/*
	 * Test a sell. The sell must remove a item quantity from inventory.
	 */
	public void testDoSell() {
		ProductSellService serv = new ProductSellServiceImpl();
		InventoryService iserv = new InventoryServiceImpl();
		
		ProductSellDTO dto = getProductSellDTO();
		
		int qtAntes = iserv.getQuantityInventory(dto.getProduct());
		
		ProductSale sell = serv.doSell(dto);

		int qtDepois = iserv.getQuantityInventory(dto.getProduct());
		
		ProductSale found = serv.findById(ProductSaleImpl.class, sell.getId());
				
		assertNotNull(found);
		assertEquals(MovmentType.OUT, found.getProductMovment().getMovmentType());
		assertEquals(SaleStatus.ACTIVE, found.getStatus());
		
		int qtVendida = dto.getQuantity();
		assertEquals("Estoque não foi baixado =[", qtAntes - qtVendida  , qtDepois);

	}

	private ProductSellDTO getProductSellDTO() {
		ProductSellDTO dto = new ProductSellDTO();
		dto.setDateOcurried(new Date());
		dto.setProduct(Utils.createProduct());
		dto.setQuantity((int) (Math.random() * 100));
		dto.setValueTotal((long) (Math.random() * 1000));
		return dto;
	}

	

	/*
	 * Test canceling a sell.
	 * The inventory must be restaured.
	 */
	@Test
	public void testCancelSell() {
		ProductSellService serv = new ProductSellServiceImpl();
		InventoryService iserv = new InventoryServiceImpl();
		
		ProductSellDTO dto = getProductSellDTO();
		
		int qtAntes = iserv.getQuantityInventory(dto.getProduct());
		
		ProductSale sell = serv.doSell(dto);

		int qtDepois = iserv.getQuantityInventory(dto.getProduct());
		
		assertTrue( qtAntes != qtDepois);
		
		ProductSale found = serv.findById(ProductSaleImpl.class, sell.getId());
		serv.cancelSale(found);
		int qtAgora = iserv.getQuantityInventory(dto.getProduct());
		assertEquals("Precisava voltar a quantidade original.", qtAntes, qtAgora);
				
		assertNotNull(found);
		
		assertEquals(SaleStatus.CANCELED, found.getStatus());		
		
	}
}