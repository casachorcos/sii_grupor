package proyecto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;

import ejb.GestionMatricula;
import ejb.excepciones.AsignaturaNoEncontradoException;
import ejb.excepciones.TrazabilidadException;
import es.uma.informatica.sii.anotaciones.Requisitos;
import jpa.entidades.Expediente;
import jpa.entidades.Matricula;

public class MatriculaT {
	
	private static final String MATRICULA_EJB = "java:global/classes/MatriculaEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "sii_grupor";

	private GestionMatricula gestionMatricula;
	
	@PersistenceContext(name="sii_grupor")
	private EntityManager em;

	@Before
	public void setup() throws NamingException  {
		gestionMatricula = (GestionMatricula) SuiteTest.ctx.lookup(MATRICULA_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Requisitos({"RF06"}) 
	@Test
	public void testActualizarMatricula() {
		final String nuevoTurno = "Tarde";
		final char nuevoNuevoIngreso = 'n';
		
		try {
			Matricula matPrueba = em.find(Matricula.class, new Matricula.MatriculaId(3,888));
			matPrueba.setTurno(nuevoTurno);
			matPrueba.setNuevoIngreso(nuevoNuevoIngreso);
			gestionMatricula.actualizarMatricula(matPrueba);
			
		} catch (TrazabilidadException e) {
			fail("Lanzó excepción al actualizar");
		}
		
		Matricula matActualizada = em.find(Matricula.class, new Matricula.MatriculaId(3,888));
		assertEquals("Tarde",matActualizada.getTurno());
		assertEquals("n",matActualizada.getNuevoIngreso());
	}
	
	@Requisitos({"RF06"}) 
	@Test
	public void testActualizarMatriculaNoEncontrado() {
		Expediente exp = new Expediente();
		exp.setNum_exp(77);
		Matricula mat = new Matricula(1,'b',958998,"Mañana",java.util.Date.from(null),'s',"Mates");
		mat.setExpediente(exp);
		
		try {
			gestionMatricula.actualizarMatricula(mat);
			fail("Debería lanzar excepción de asignatura no encontrado");
		} catch (AsignaturaNoEncontradoException e) {
			//OK
		} catch (TrazabilidadException e) {
			fail("Debería lanzar excepción de asignatura no encontrado");
		}
	}
}
