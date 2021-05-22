package proyecto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import ejb.GestionAsignaturas;
import ejb.excepciones.AsignaturaExistenteException;
import ejb.excepciones.AsignaturaNoEncontradoException;
import ejb.excepciones.TrazabilidadException;
import es.uma.informatica.sii.anotaciones.Requisitos;
import jpa.entidades.Asignatura;


public class AsignaturaT {

	private static final String ASIGNATURA_EJB = "java:global/classes/AsignaturaEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "sii_gruporTest";
	

	
	private GestionAsignaturas gestionAsignaturas;
	
	@Before
	public void setup() throws NamingException  {
		gestionAsignaturas = (GestionAsignaturas) SuiteTest.ctx.lookup(ASIGNATURA_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Requisitos({"RF05"}) 
	@Test
	public void testInsertarAsignatura() throws AsignaturaNoEncontradoException, TrazabilidadException {
		
		final Integer ref_asig = 10000;
		
		Asignatura prueba = new Asignatura (10000, 001, "6","Sí","Asignatura de Prueba", 3, "-", "2º Semestre", "-", "-");
		
		try {
			gestionAsignaturas.insertarAsignatura(prueba);
		} catch (AsignaturaExistenteException e) {
			fail("Lanzó excepción al insertar");
		}
				
		try {
			Asignatura asignatura = gestionAsignaturas.obtenerAsignaturas(ref_asig);
			assertEquals(ref_asig, asignatura.getReferencia());
			assertEquals(Integer.valueOf(001),asignatura.getCodigo());
			assertTrue(("6").compareTo(asignatura.getCreditos())==0);
			assertTrue(("Sí").compareTo(asignatura.getOfertada())==0);
			assertTrue(("Asignatura de Prueba").compareTo(asignatura.getNombre())==0);
			assertEquals(Integer.valueOf(3), asignatura.getCurso());
			assertTrue(("-").compareTo(asignatura.getCreditos())==0);
			assertTrue(("2º Semestre").compareTo(asignatura.getDuracion())==0);
			assertTrue(("-").compareTo(asignatura.getUnidad_temporal())==0);
			assertTrue(("-").compareTo(asignatura.getIdiomas())==0);
		} catch (TrazabilidadException e) {
			fail("No debería lanzar excepción");
		}
	}
	
	@Requisitos({"RF05"})
	@Test
	public void testInsertarAsignaturaNoEncontrado() throws TrazabilidadException {
		
		final int ref_asig = 00000;
		
		Asignatura prueba = new Asignatura (10000, 001, "6","Sí","Asignatura de Prueba", 3, "-", "2º Semestre", "-", "-");
		
		try {
			gestionAsignaturas.insertarAsignatura(prueba);
			Asignatura asignatura = gestionAsignaturas.obtenerAsignaturas(ref_asig);
			fail("Debe lanzar excepción");
		} catch (AsignaturaExistenteException e) {
			fail("Lanzó excepción al insertar");
		} catch (AsignaturaNoEncontradoException e) {
			//OK
		}
	}
	
	@Requisitos({"RF05"})
	@Test
	public void testInsertarAsignaturaExistente() throws AsignaturaNoEncontradoException, TrazabilidadException {
		
		Asignatura prueba = new Asignatura (51025, 306, "6","Sí","Sistemas de Información para Internet", 3, "-", "2º Semestre", "-", "-");
		
		try {
			gestionAsignaturas.insertarAsignatura(prueba);
			fail("Debe lanzar excepción de asignatura existente");
		} catch (AsignaturaExistenteException e) {
			//OK
		} catch (TrazabilidadException e) {
			fail("Debe lanzar excepción de asignatura existente");
		}
	}
	
	@Requisitos({"RF05"})
	@Test
	public void testObtenerAsignatura() {
		try {
			Asignatura prueba = gestionAsignaturas.obtenerAsignaturas(51025);
			assertEquals(Integer.valueOf(51025),prueba.getReferencia());
		} catch (TrazabilidadException e) {
			fail("No debería lanzar excepción");
		}
	}
	
	@Requisitos({"RF05"})
	@Test
	public void testObtenerAsignaturaNoEncontrado() {
		try {
			Asignatura prueba = gestionAsignaturas.obtenerAsignaturas(99999);
			fail("Debería lanzar excepción de asignatura no encontrado");
		} catch (AsignaturaNoEncontradoException e) {
			//OK
		} catch (TrazabilidadException e) {
			fail("No debería lanzar excepción");
		}
	}
	
	@Requisitos({"RF05"})
	@Test
	public void testActualizarAsignatura() {
		final int ref = 51025;
		final String NuevoCaracter = "Presencial";
		final String NuevoIdioma = "Español";
		
		try {
			Asignatura asignatura = gestionAsignaturas.obtenerAsignaturas(ref);
			asignatura.setCaracter(NuevoCaracter);
			asignatura.setIdiomas(NuevoIdioma);
			gestionAsignaturas.actualizarAsignatura(asignatura);
			
		} catch (TrazabilidadException e) {
			fail("Lanzó excepción al actualizar");
		}
		
		try {
			Asignatura actualizado = gestionAsignaturas.obtenerAsignaturas(ref);
			assertTrue((NuevoCaracter).compareTo(actualizado.getCaracter())==0);
			assertTrue(NuevoIdioma.compareTo(actualizado.getIdiomas())==0);
		} catch (TrazabilidadException e) {
			fail("No debería lanzar excepción");
		}
	}
	
	@Requisitos({"RF05"})
	@Test
	public void testActualizarAsignaturaNoEncontrado() {
		Asignatura prueba = new Asignatura (99990, 999, "6","Sí","Sistemas de Información para Internet II", 5, "-", "1º Semestre", "-", "-");
		
		try {
			gestionAsignaturas.actualizarAsignatura(prueba);
			fail("Debería lanzar excepción de asignatura no encontrado");
		} catch (AsignaturaNoEncontradoException e) {
			//OK
		} catch (TrazabilidadException e) {
			fail("Debería lanzar excepción de asignatura no encontrado");
		}
	}
	
	@Requisitos({"RF05"})
	@Test
	public void testEliminarAsignatura() throws TrazabilidadException {
		final int ref = 51025;
		Asignatura prueba = gestionAsignaturas.obtenerAsignaturas(ref);
		
		gestionAsignaturas.eliminarAsignatura(prueba);
		
		try {
			prueba = gestionAsignaturas.obtenerAsignaturas(ref);
			fail("Debería lanzar excepción de asignatura no encontrado");
		} catch (AsignaturaNoEncontradoException e) {
			//Ok
		}
		
	}
	
	@Requisitos({"RF05"})
	@Test
	public void testEliminarAsignaturaNoEncontrado() {
		
		try {
			Asignatura prueba = new Asignatura (99990, 999, "6","Sí","Sistemas de Información para Internet II", 5, "-", "1º Semestre", "-", "-");
			
			gestionAsignaturas.eliminarAsignatura(prueba);
			fail("Debería lanzar excepción de asignatura no encontrado");
		} catch (AsignaturaNoEncontradoException e) {
			//OK
		} catch (TrazabilidadException e) {
			fail("Debería lanzar la excepción de producto no encontrado");
		}
	}
}
