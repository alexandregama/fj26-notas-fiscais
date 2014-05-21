package br.com.caelum.notasfiscais.util;

import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class JPAUtil {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("notas");

	@Produces @RequestScoped
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public void close(@Disposes EntityManager em) {
		System.out.println("Fechando o entityManager");
		em.close();
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("Fechando o entityManagerFactory");
		emf.close();
	}
	
}