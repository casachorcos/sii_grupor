package proyecto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;

import ejb.GestionAlumnos;
import ejb.excepciones.AsignaturaNoEncontradoException;
import ejb.excepciones.TrazabilidadException;
import es.uma.informatica.sii.anotaciones.Requisitos;
import jpa.entidades.Alumno;

public class AlumnoT {

	private static final String ALUMNO_EJB = "java:global/classes/AlumnoEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "sii_grupor";

	private GestionAlumnos gestionAlumnos;
	
	@PersistenceContext(name="sii_grupor")
	private EntityManager em;

	@Before
	public void setup() throws NamingException  {
		gestionAlumnos = (GestionAlumnos) SuiteTest.ctx.lookup(ALUMNO_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Requisitos({"RF04"}) 
	@Test
	public void testActualizarAlumno() {
		final String nuevoNombre = "José";
		final String nuevoApellido = "Porgutis";
		
		try {
			Alumno alumnoPrueba1 = em.find(Alumno.class, (long)1);
			alumnoPrueba1.setNombre(nuevoNombre);
			alumnoPrueba1.setApellido(nuevoApellido);
			gestionAlumnos.actualizarAlumno(alumnoPrueba1);
			
		} catch (TrazabilidadException e) {
			fail("Lanzó excepción al actualizar");
		}
		
		Alumno actualizado = em.find(Alumno.class, (long)1);
		assertEquals("José",actualizado.getNombre());
		assertEquals("Porgutis",actualizado.getApellido());
	}
	
	@Requisitos({"RF04"}) 
	@Test
	public void testActualizarAlumnoNoEncontrado() {
		Alumno alumnoPrueba2 = new Alumno("89999H","Pepe","Lechuga","Ruiz","supraaazk@uma.es","sp1","72778113","95212812","C/Parrados","Malaga","Malaga",(long)29010);
		
		try {
			gestionAlumnos.actualizarAlumno(alumnoPrueba2);
			fail("Debería lanzar excepción de asignatura no encontrado");
		} catch (AsignaturaNoEncontradoException e) {
			//OK
		} catch (TrazabilidadException e) {
			fail("Debería lanzar excepción de asignatura no encontrado");
		}
	}
}
