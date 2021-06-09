package es.uma.informatica.sii.sii_grupor.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.entidades.Alumno;
import jpa.entidades.Expediente;
import jpa.entidades.Matricula;

public class BaseDatos {

	public static void inicializar(String unidadPersistencia) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(unidadPersistencia);
		EntityManager em = emf.createEntityManager();
		
		datos(em);
		
		em.close();
		emf.close();
	}

	public static void datos(EntityManager em) {
		
		Alumno profe = new Alumno();
		profe.setDNI("12345678A");
		profe.setNombre("Profe");
		profe.setApellido1("Apruébanos");
		profe.setApellido2("Porfa");
		profe.setEmailInst("un5son6creditos@uma.es");
		profe.setEmailPers("aunqueseaun5@gmail.com");
		profe.setTelefono("123456789");
		profe.setMovil("987654321");
		profe.setDireccion("Teatinos 69");
		profe.setLocalidad("Málaga");
		profe.setProvincia("Málaga");
		profe.setCodPostal("29001");
		
		em.getTransaction().begin();
		em.persist(profe);
		em.getTransaction().commit();

		Expediente exp = new Expediente();
		exp.setNum_exp(1000);
		exp.setActivo('s');
		exp.setNotaMedia(5.0);
		exp.setCr_cf(6.0);
		exp.setCr_fb(6.0);
		exp.setCr_ob(6.0);
		exp.setCr_op(6.0);
		exp.setCr_pe(6.0);
		exp.setCr_sup(6.0);
		exp.setCr_tf(6.0);
		
		em.getTransaction().begin();
		em.persist(exp);
		em.getTransaction().commit();
		
		Matricula mat = new Matricula();
		mat.setCurso(2122);
		mat.setEstado('s');
		mat.setnArchivo(123456);
		mat.setTurno("Mañana");
		mat.setFecha_matr(null);
		mat.setNuevoIngreso('s');
		mat.setListaAsig("101,102,103,104,105,106,107,108,109,110");
		
		mat.setExpediente(exp);
		//exp.getMatricula().add(mat);
		
		em.getTransaction().begin();
		em.persist(mat);
		em.getTransaction().commit();
	
	}
	
}
