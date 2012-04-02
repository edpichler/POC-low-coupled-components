package com.edpichler.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.Date;

import javax.persistence.RollbackException;

import org.junit.Test;

import com.edpichler.inventory.MovmentType;
import com.edpichler.inventory.impl.ProductMovmentImpl;
import com.edpichler.inventory.process.InventoryService;
import com.edpichler.jpa.InventoryServiceImpl;
import com.edpichler.product.Product;
import com.edpichler.services.util.Utils;

public class InventoryServiceTest {

	@Test
	/* 
	 * Test a movment.
	 *  */
	public void testDoMovment() {
		InventoryService serv = new InventoryServiceImpl();
		ProductMovmentImpl mov = getMovimento();
		serv.doInvetoryMovment(mov);
		
		ProductMovmentImpl found = serv.findById(ProductMovmentImpl.class, mov.getId());
		assertNotNull(found);

	}
	
	@Test(expected=RollbackException.class)
	/* 
	 * Test a movment without some data.
	 *  */	
	public void testDoMovmentEmptyFields1() {
		InventoryService serv = new InventoryServiceImpl();
		ProductMovmentImpl mov = getMovimento();
		mov.setMovmentDate(null);
		serv.doInvetoryMovment(mov);
		
		ProductMovmentImpl found = serv.findById(ProductMovmentImpl.class, mov.getId());
		assertNull(found);
		fail("Não poderia ter salvo");
	}
	
	@Test(expected=RollbackException.class)
	/* 
	 * Test a movment without some data.
	 *  */
	public void testDoMovmentEmptyFields2() {
		InventoryService serv = new InventoryServiceImpl();
		ProductMovmentImpl mov = getMovimento();
		mov.setMovmentType(null);
		serv.doInvetoryMovment(mov);
		fail("Não poderia ter salvo");
	}

	@Test(expected=RollbackException.class)
	/* 
	 * Test a movment without some data.
	 *  */
	public void testDoMovmentEmptyFields3() {
		InventoryService serv = new InventoryServiceImpl();
		ProductMovmentImpl mov = getMovimento();
		mov.setProduct(null);
		serv.doInvetoryMovment(mov);
		fail("Não poderia ter salvo");
	}

	@Test(expected=RollbackException.class)
	/* 
	 * Test a movment without some data.
	 *  */
	public void testDoMovmentEmptyFields4() {
		InventoryService serv = new InventoryServiceImpl();
		ProductMovmentImpl mov = getMovimento();
		mov.setProduct(null);
		serv.doInvetoryMovment(mov);
		fail("Não poderia ter salvo");
	}
	
	private ProductMovmentImpl getMovimento() {
		ProductMovmentImpl retorno = new ProductMovmentImpl();
		retorno.setMovmentDate(new Date());
		retorno.setMovmentType(MovmentType.IN);
		retorno.setNotes("Some notas.");
		Product product = Utils.createProduct();
		retorno.setProduct(product);
		retorno.setQuantity(3);
		return retorno;
	}
	
	@Test
	public void testQuantidadeEmEstoque(){
		final Product product = Utils.createProduct();
		int qtCadaVez = (int) (10 * Math.random());
		InventoryService serv = new InventoryServiceImpl();
		
		//adiciona 100
		for (int i = 0; i < 10; i++) {
			ProductMovmentImpl mov = new ProductMovmentImpl();
			mov.setMovmentDate(new Date());
			mov.setMovmentType(MovmentType.IN);
			mov.setProduct(product);
			mov.setQuantity(qtCadaVez);
			serv.doInvetoryMovment(mov);
		}
		
		//remove 5
		ProductMovmentImpl mov = new ProductMovmentImpl();
		mov.setMovmentDate(new Date());
		mov.setMovmentType(MovmentType.OUT);
		mov.setProduct(product);
		int qtSaiu = (int) (109 * Math.random());
		mov.setQuantity(qtSaiu);
		serv.doInvetoryMovment(mov);
		
		int quantidadeEsperada = 10 * qtCadaVez - qtSaiu;		
		int qtEncontrada = serv.getQuantityInventory(product);
		assertEquals(quantidadeEsperada, qtEncontrada);				
	}
}