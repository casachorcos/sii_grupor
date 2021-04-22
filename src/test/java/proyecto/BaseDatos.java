package proyecto;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.entidades.*;

public class BaseDatos {
	public static void inicializaBaseDatos(String nombreUnidadPersistencia) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(nombreUnidadPersistencia);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		
		Asignatura sii = new Asignatura (51025, 306, "6","Sí","Sistemas de Información para Internet", 3, "-", "2º Semestre", "-", "-");
		Asignatura abd = new Asignatura (51015, 305, "6","Sí","Administración de Bases de Datos", 3, "-", "2º Semestre", "-", "-");
		Asignatura si2 = new Asignatura (51024, 307, "6","Sí","Sistemas Inteligentes II", 3, "-", "2º Semestre", "-", "-");
		Asignatura ayc = new Asignatura (51016, 311, "6","Sí","Algoritmia y Complejidad", 3, "-", "2º Semestre", "-", "-");
		Asignatura pr = new Asignatura (51040, 865, "6","Sí","Programación de Robots", 3, "-", "2º Semestre", "-", "-");
		
		for (Asignatura asignatura: new Asignatura [] {sii, abd, si2, ayc, pr}) {
			em.persist(asignatura);
			
		
			
		Alumno al1 = new Alumno("77774511J","Dani","Lechuga","Ruiz","supraaazk@uma.es","sp1","72778113","95212812","C/Parrados","Malaga","Malaga",(long)29010);
		Alumno al2 = new Alumno("66664511J","Alejandro","Gutierrez","España","ale@uma.es","sp2","72778115","95212813","C/Parrados2","Malaga","Malaga",(long)29010);
		Alumno al3 = new Alumno("55554511J","Nicolas","Casamayor","Camacho","nico@uma.es","sp3","72778116","95212814","C/Parrados3","Malaga","Malaga",(long)29010);
		Alumno al4 = new Alumno("44444511J","Francisco","Cabrerizo","Perez","cabre@uma.es","sp4","72778117","95212815","C/Parrados4","Malaga","Malaga",(long)29010);
		
		for(Alumno al : new Alumno [] {al1,al2,al3,al4}) {
			em.persist(al);
		}
		
		}
		
		Grupo gr1 = new Grupo(1,'A',"Ma�ana","S�","No",null,20);
		Grupo gr2 = new Grupo(2,'D',"Tarde","No","S�",null,30);
		Grupo gr3 = new Grupo(3,'B',"Ma�ana","No","S�",null,60);
		
		for (Grupo grupo : new Grupo [] {gr1, gr2, gr3}) {
			em.persist(grupo);
		}
		
		/* EJEMPLO *
		Ingrediente carne = new Ingrediente ("Carne picada");
		Ingrediente pimienta = new Ingrediente ("Pimienta");
		Ingrediente especias = new Ingrediente("Especias de hamburguesa");
		Ingrediente pimenton = new Ingrediente ("Pimentón");
		Ingrediente sal = new Ingrediente ("Sal");
		Ingrediente azucar = new Ingrediente ("Azúcar");
		Ingrediente perejil = new Ingrediente ("Perejil");
		
		for (Ingrediente ingrediente: new Ingrediente [] {carne, pimienta, especias, pimenton, sal, azucar, perejil}) {
			em.persist(ingrediente);
		}
		
		Producto chorizo = new Producto ("Chorizo");
		Producto salchicha = new Producto ("Salchicha");
		Producto hamburguesa = new Producto ("Hamburguesa");
		
		chorizo.setIngredientes(Stream.of(carne, pimienta, pimenton, sal)
				.collect(Collectors.toSet()));
		
		salchicha.setIngredientes(Stream.of(carne, sal, azucar, perejil)
				.collect(Collectors.toSet()));
		
		hamburguesa.setIngredientes(Stream.of(carne, especias, sal, azucar)
				.collect(Collectors.toSet()));
		
		for (Producto producto: new Producto [] {chorizo, salchicha, hamburguesa}) {
			em.persist(producto);
		}
		
		Lote lote = new Lote ("LT1", chorizo, BigDecimal.TEN, Date.valueOf("2021-04-11"));
		lote.setLoteIngredientes(new HashMap<Ingrediente, String>());
		lote.getLoteIngredientes().put(carne, "C1");
		lote.getLoteIngredientes().put(pimienta, "Pi1");
		lote.getLoteIngredientes().put(pimenton, "PM1");
		lote.getLoteIngredientes().put(sal, "S1");
		
		em.persist(lote);
		
		lote = new Lote ("LT2", chorizo, BigDecimal.valueOf(25L), Date.valueOf("2021-04-12"));
		lote.setLoteIngredientes(new HashMap<Ingrediente, String>());
		lote.getLoteIngredientes().put(carne, "C2");
		lote.getLoteIngredientes().put(pimienta, "Pi2");
		lote.getLoteIngredientes().put(pimenton, "PM2");
		lote.getLoteIngredientes().put(sal, "S2");
		
		em.persist(lote);
		* FIN EJEMPLO */
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
