package jpa.entidades;

import java.io.Closeable;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AccesoDatos implements Closeable {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public AccesoDatos() {
		emf = Persistence.createEntityManagerFactory("sii_grupor");
		em = emf.createEntityManager();
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		em.close();
		emf.close();
	}	
}
