package br.com.caelum.notasfiscais.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("notas");
		
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.close();
	}
}
