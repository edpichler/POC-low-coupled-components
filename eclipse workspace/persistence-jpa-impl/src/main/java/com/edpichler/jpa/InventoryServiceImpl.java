package com.edpichler.jpa;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.edpichler.inventory.MovmentType;
import com.edpichler.inventory.ProductMovment;
import com.edpichler.inventory.impl.ProductMovmentImpl;
import com.edpichler.inventory.process.InventoryService;
import com.edpichler.product.Product;

public class InventoryServiceImpl extends JPAServiceBase implements InventoryService {

	@Override
	/**
	 * {@inheritDoc}
	 * */
	public void doInvetoryMovment(ProductMovment a) {
		super.persist(a);
	}

	@Override
	public int getQuantityInventory(Product p, Date date) {
		EntityManager em = JPAUtil.createEntityManager();
		Query q = em.createQuery("SELECT SUM (a.quantity) FROM " 
				+ ProductMovmentImpl.class.getSimpleName() + " a" +
						" WHERE a.product = :arg " +
						" AND a.movmentType = :mov " +
						" AND a.movmentDate <= :date");
		q.setParameter("arg", p);
		q.setParameter("mov", MovmentType.IN);
		q.setParameter("date", date);
		
		Object singleResult = q.getSingleResult();
		
		int resIn = 0;
		if(singleResult != null){
			resIn = new Integer(singleResult.toString());	
		}
		
		q.setParameter("mov", MovmentType.OUT);	
		singleResult = q.getSingleResult();
		int resOut = 0;
		if(singleResult != null){
			resOut = new Integer(singleResult.toString());	
		}
		
		return resIn - resOut;
	}

	@Override
	/**
	 * {@inheritDoc}
	 * */
	public int getQuantityInventory(Product p) {
		return getQuantityInventory(p, new Date());
	}
}
