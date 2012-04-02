package com.edpichler.jpa;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

class JPAUtil {
	private static Map properties;
	private static EntityManagerFactory emf;
	private static final String PERSISTENCE_UNIT = "pesistenceUnit";

	private static JPAUtil instance;

	private JPAUtil() {

	}

	/** @return the singleton */
	public static JPAUtil getInstance() {
		if (instance == null) {
			instance = new JPAUtil();
		}
		return instance;
	}

	/**
	 * Create an EntityManager.
	 * 
	 * @see ConfigurationServiceProvider
	 */
	public static EntityManager createEntityManager() {
		if (emf == null || !emf.isOpen()) {
			emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT,
					properties);
		}

		EntityManager em = emf.createEntityManager();		
		return em;
	}

	public void setServiceConfiguration(Map prop)
			throws IllegalStateException {
		if (emf != null) {
			throw new IllegalStateException(
					"The persistent context was already been"
							+ " initialized."
							+ " You only can set the properties "
							+ "before calling any service or initializing the persist context.");
		}
		properties = prop;
	}
}
