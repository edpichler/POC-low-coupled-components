package com.edpichler.jpa;

import com.edpichler.serviceSale.ServiceSaleImpl;
import com.edpichler.serviceSales.SaleStatus;
import com.edpichler.serviceSales.ServiceSale;
import com.edpichler.serviceSales.ServiceSellService;
import com.edpichler.serviceSales.dto.ServiceSellDTO;

public class ServiceSellServiceImpl extends JPAServiceBase implements
		ServiceSellService {

	@Override
	public ServiceSale doSale(ServiceSellDTO dto) {
		// TODO validar com aspectj para dto.quantidade ser obrigatório maior
		// que zero

		ServiceSaleImpl sell = new ServiceSaleImpl();
		sell.setDateSold(dto.getDateOcurried());
		sell.setTotal(dto.getValueTotal());
		sell.setStatus(SaleStatus.ACTIVE);
		sell.setQuantityHours(dto.getQuantityHours());
		sell.setService(dto.getService());		
		persist(sell);
		return sell;
	}

	@Override
	public void cancelSale(ServiceSale a) {
		a.setStatus(SaleStatus.CANCELED);
		merge(a);
//		EntityManager em = createEntityManager();
//		EntityTransaction t = em.getTransaction();
//		t.begin();
//
//		em.merge(a);
//
//		ProductMovment canceledMov = a.getProductMovment();
//		ProductMovmentImpl newMov = new ProductMovmentImpl();
//
//		newMov.setMovmentDate(new Date());
//		newMov.setMovmentType(MovmentType.IN);
//		newMov.setNotes("Sale Canceled: "
//				+ ProductMovmentImpl.class.getSimpleName() + " ID = "
//				+ a.getId());
//
//		newMov.setProduct(canceledMov.getProduct());
//		int quantity = canceledMov.getQuantity();
//		newMov.setQuantity(quantity);
//
//		em.persist(newMov);
//
//		t.commit();

	}

}
