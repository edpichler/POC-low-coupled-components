package com.edpichler.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.edpichler.inventory.MovmentType;
import com.edpichler.inventory.ProductMovment;
import com.edpichler.inventory.impl.ProductMovmentImpl;
import com.edpichler.productSale.impl.ProductSaleImpl;
import com.edpichler.productSales.ProductSale;
import com.edpichler.productSales.ProductSellService;
import com.edpichler.productSales.SaleStatus;
import com.edpichler.productSales.dto.ProductSellDTO;

public class ProductSellServiceImpl extends JPAServiceBase implements
		ProductSellService {

	@Override
	public ProductSale doSell(ProductSellDTO dto) {
		// TODO validar com aspectj para dto.quantidade ser obrigatório maior
		// que zero

		ProductSaleImpl sell = new ProductSaleImpl();
		sell.setDateSold(dto.getDateOcurried());
		sell.setTotal(dto.getValueTotal());

		ProductMovmentImpl mov = new ProductMovmentImpl();
		mov.setMovmentDate(dto.getDateOcurried());
		mov.setMovmentType(MovmentType.OUT);
		mov.setProduct(dto.getProduct());
		mov.setQuantity(dto.getQuantity());

		sell.setProductMovment(mov);
		sell.setStatus(SaleStatus.ACTIVE);
		super.persist(sell);
		return sell;
	}

	@Override
	public void cancelSale(ProductSale a) {
		a.setStatus(SaleStatus.CANCELED);
		EntityManager em = createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.merge(a);

		ProductMovment canceledMov = a.getProductMovment();
		ProductMovmentImpl newMov = new ProductMovmentImpl();

		newMov.setMovmentDate(new Date());
		newMov.setMovmentType(MovmentType.IN);
		newMov.setNotes("Sale Canceled: "
				+ ProductMovmentImpl.class.getSimpleName() + " ID = "
				+ a.getId());

		newMov.setProduct(canceledMov.getProduct());
		int quantity = canceledMov.getQuantity();
		newMov.setQuantity(quantity);

		em.persist(newMov);

		t.commit();

	}

	@Override
	public <T> List<T> findAll(Class<T> entity, int startIndex, int maxResults) {
		return super.findAll(entity, startIndex, maxResults);
	}

	@Override
	public <T> List<T> findAll(Class<T> entity, int maxResults) {
		return super.findAll(entity, 0, maxResults);
	}

	@Override
	public <T> List<T> find(String anyValue, int startIndex, int maxResults) {
		return super.find(anyValue, startIndex, maxResults);
	}

	@Override
	public <T> List<T> find(String anyValue, int maxResults) {
		return super.find(anyValue, 0, maxResults);
	}

	@Override
	public <T> T findById(Class<T> entity, long id) {
		return super.findById(entity, id);
	}

}
