package com.masaischool.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;



	
	public class EMUtil {
		static EntityManagerFactory emf;
		static {
			emf=Persistence.createEntityManagerFactory("Project1");
		}
		
		public static EntityManager getConnection() {
			return emf.createEntityManager();
		}
}

	
	


