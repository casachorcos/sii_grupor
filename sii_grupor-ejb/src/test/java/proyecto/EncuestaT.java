package proyecto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.Properties;
import java.util.logging.Logger;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ejb.EncuestaEJB;
import ejb.GestionEncuestas;
import ejb.excepciones.*;
import es.uma.informatica.sii.anotaciones.Requisitos;
import jpa.entidades.Encuesta;

public class EncuestaT {

	private static final Logger LOG = Logger.getLogger(EncuestaT.class.getCanonicalName());

	private static final String ENCUESTAS_EJB = "java:global/classes/EncuestaEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "sii_gruporTest";

	private GestionEncuestas gestionEncuesta;
	
	@Before
	public void setup() throws NamingException  {
		gestionEncuesta = (GestionEncuestas) SuiteTest.ctx.lookup(ENCUESTAS_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Requisitos({"RF07"})
	@Test
	public void testInsertarEncuesta() {
		
		try {
			
			Encuesta en = new Encuesta(new Date(2021, 5, 22, 13, 21, 56));
			
			try {
				gestionEncuesta.insertarEncuesta(en);
			} catch (EncuestaExistenteException ex) {
				fail("Excepcion");
			}
			
		} catch (TrazabilidadException e) {
			throw new RuntimeException(e);
		}
		
		try {
			Encuesta en = gestionEncuesta.obtenerEncuesta(new Date(2021, 5, 22, 13, 21, 56));
			assertEquals(new Date(2021, 5, 22, 13, 21, 56), en.getFecha_de_envio());
		} catch (TrazabilidadException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	@Requisitos({"RF07"})
	@Test
	public void testInsertarEncuestaExistente() {
		Encuesta en = new Encuesta(new Date(2021, 4, 22, 13, 21, 56));
		
		try {
			gestionEncuesta.insertarEncuesta(en);
			fail("Debe lanzar excepción");
		} catch (EncuestaExistenteException e) {
			//OK
		} catch (TrazabilidadException e) {
			fail("Debe lanzar EncuestaExistenteException");
		}
	}
	
	@Requisitos({"RF07"})
	@Test
	public void testObtenerEncuesta() {
		try {
			Encuesta en = gestionEncuesta.obtenerEncuesta(new Date(2021, 4, 22, 13, 21, 56));
			assertEquals(new Date(2021, 4, 22, 13, 21, 56),en.getFecha_de_envio());

		} catch (TrazabilidadException e) {
			fail("Lanza una excepcion al obtener");
		}
	}
	
	@Requisitos({"RF07"})
	@Test
	public void testObtenerEncuestaNoExistente() {
		try {
			Encuesta en = gestionEncuesta.obtenerEncuesta(new Date(2000, 2, 22, 2, 22, 22));
			fail("Debe lanzar la excepcion");
		} catch (EncuestaNoEncontradoException e) {
			// OK
		} catch (TrazabilidadException e) {
			fail("Debe lanzar EncuestaNoEncontradoException");
		}
	}
	
	@Requisitos({"RF07"})
	@Test
	public void testEliminarEncuesta() {
		Encuesta en = new Encuesta(new Date(2021, 4, 22, 13, 21, 56));
		try {
			gestionEncuesta.eliminarEncuesta(en);
			
			try {
				gestionEncuesta.obtenerEncuesta(new Date(2021, 4, 22, 13, 21, 56));
			} catch (EncuestaNoEncontradoException e) {
				// OK
			} catch (TrazabilidadException e) {
				fail("Debe lanzar EncuestaNoEncontradoException");
			}
		} catch (TrazabilidadException e) {
			fail("Lanza una excepion al eliminar");
		}
	}
	
	@Requisitos({"RF07"})
	@Test
	public void testEliminarEncuestaNoExistente() {
		Encuesta en = new Encuesta(new Date(2000, 2, 22, 2, 22, 22));
		try {
			gestionEncuesta.eliminarEncuesta(en);
			fail("Debe lanzar EncuestaNoEncontradoException");
		} catch (EncuestaNoEncontradoException e) {
			// OK
		} catch (TrazabilidadException e) {
			fail("Debe lanzar EncuestaNoEncontradoException");
		}
	}
}
