package proyecto;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.entidades.Alumno;
import jpa.entidades.Asignatura;
import jpa.entidades.Encuesta;
import jpa.entidades.Expediente;
import jpa.entidades.Grupo;
import jpa.entidades.Matricula;
import jpa.entidades.Titulacion;

public class BaseDatos {
	public static void inicializaBaseDatos(String nombreUnidadPersistencia) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(nombreUnidadPersistencia);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Titulacion t = new Titulacion(1024, "Ingenieria Informatica", 240.0);
		em.persist(t);
		
		Asignatura sii = new Asignatura (51025, 306, "6","Si","Sistemas de Informacion para Internet", 3, "-", "2 Semestre", "-", "-");
		Asignatura abd = new Asignatura (51015, 305, "6","Si","Administración de Bases de Datos", 3, "-", "2 Semestre", "-", "-");
		Asignatura si2 = new Asignatura (51024, 307, "6","Si","Sistemas Inteligentes II", 3, "-", "2 Semestre", "-", "-");
		Asignatura ayc = new Asignatura (51016, 311, "6","Si","Algoritmia y Complejidad", 3, "-", "2 Semestre", "-", "-");
		Asignatura pr = new Asignatura (51040, 865, "6","Si","Programacion de Robots", 3, "-", "2 Semestre", "-", "-");
		
		for (Asignatura asignatura: new Asignatura [] {sii, abd, si2, ayc, pr}) {
			em.persist(asignatura);
		}
		
		Alumno al1 = new Alumno("77774511J","Dani","Lechuga","Ruiz","supraaazk@uma.es","sp1","72778113","95212812","C/Parrados","Malaga","Malaga","29010");
		Alumno al2 = new Alumno("66664511J","Alejandro","Gutierrez","España","ale@uma.es","sp2","72778115","95212813","C/Parrados2","Malaga","Malaga","29010");
		Alumno al3 = new Alumno("55554511J","Nicolas","Casamayor","Camacho","nico@uma.es","sp3","72778116","95212814","C/Parrados3","Malaga","Malaga","29010");
		Alumno al4 = new Alumno("44444511J","Francisco","Cabrerizo","Perez","cabre@uma.es","sp4","72778117","95212815","C/Parrados4","Malaga","Malaga","29010");
		//al1.setId((long)1);
		//al2.setId((long)2);
		//al3.setId((long)3);
		//al4.setId((long)4);
		for(Alumno al : new Alumno [] {al1,al2,al3,al4}) {
			em.persist(al);
		}
		
		
		Grupo gr1 = new Grupo("1AINF2021",1,'A',"Ma�ana","Si","No",null,20);
		Grupo gr2 = new Grupo("2DINF2021",1,'D',"Tarde","No","Si",null,30);
		Grupo gr3 = new Grupo("3BINF2021",3,'A',"Ma�ana","No","Si",null,60);
		
		for (Grupo grupo : new Grupo [] {gr1, gr2, gr3}) {
			em.persist(grupo);
		}
		
		Encuesta en = new Encuesta(new Date(2021, 4, 22, 13, 21, 56));
		em.persist(en);
		
		Expediente exp = new Expediente(0,'a',0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0);
		exp.setNum_exp(888);
		em.persist(exp);
		
		java.util.Date date = new java.util.Date();
		Matricula mat = new Matricula(3,'a',958,"Mañana",date,'s',"Mates");
		mat.setExpediente(exp);
		em.persist(mat);
		
		
		em.getTransaction().commit(); //Está comentado porque sino devuelve errores de violacion de primary key y no funciona la base de datos
		
		em.close();
		emf.close();
	}
}
