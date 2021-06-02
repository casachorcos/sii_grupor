package jpa.entidades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main (String [] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ejb.demo");
		EntityManager em = emf.createEntityManager();
		emf.close();
		em.close();
	}
}
