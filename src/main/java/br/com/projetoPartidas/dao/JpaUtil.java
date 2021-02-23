package br.com.projetoPartidas.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("partida");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
