package com.miranda.proyectoaulas.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {

	private static final String PERSISTENCE_UNIT_NAME = "persistence";
	private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();
	

	private static EntityManagerFactory buildEntityManagerFactory() {
		return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

	public static EntityManager getEntityManager() {
	return entityManagerFactory.createEntityManager();
	}
	
//	public static EntityManagerFactory getEntityManagerFactory() {
//	if (entityManagerFactory ==null) {
//		entityManagerFactory=Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
//	}
//	return entityManagerFactory;
//	}
	
//	public static void shutDown() {
//		if(entityManagerFactory!=null) {
//			entityManagerFactory.close();
//			
//		}
//	}
	
	

}
