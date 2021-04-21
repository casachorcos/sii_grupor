package proyecto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Properties;
import java.util.logging.Logger;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ejb.GestionAsignaturas;
import ejb.excepciones.AsignaturaExistenteException;
import ejb.excepciones.AsignaturaNoEncontradoException;
import ejb.excepciones.TrazabilidadException;
import es.uma.informatica.sii.anotaciones.Requisitos;
import jpa.entidades.Asignatura;


public class AsignaturaTest {
	
	private static final Logger LOG = Logger.getLogger(AsignaturaTest.class.getCanonicalName());

	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
	private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
	private static final String ASIGNATURA_EJB = "java:global/classes/AsignaturaEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "sii_grupor";
	
	private static EJBContainer ejbContainer;
	private static Context ctx;
	
	private GestionAsignaturas gestionAsignaturas;
	
	@BeforeClass
	public static void setUpClass() {
		Properties properties = new Properties();
		properties.setProperty(GLASSFISH_CONFIGI_FILE_PROPERTY, CONFIG_FILE);
		ejbContainer = EJBContainer.createEJBContainer(properties);
		ctx = ejbContainer.getContext();
	}
	
	@Before
	public void setup() throws NamingException  {
		gestionAsignaturas = (GestionAsignaturas) ctx.lookup(ASIGNATURA_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Requisitos({"RF05"}) 
	@Test
	public void testInsertarAsignatura() throws AsignaturaNoEncontradoException, TrazabilidadException {
		
		final int ref_asig = 10000;
		
		Asignatura prueba = new Asignatura (10000, 001, "6","Sí","Asignatura de Prueba", 3, "-", "2º Semestre", "-", "-");
		
		try {
			gestionAsignaturas.insertarAsignatura(prueba);
		} catch (AsignaturaExistenteException e) {
			fail("Lanzó excepción al insertar");
		}
				
		try {
			Asignatura asignatura = gestionAsignaturas.obtenerAsignaturas(ref_asig);
			assertEquals(ref_asig, asignatura.getReferencia());
			assertEquals(001,asignatura.getCodigo());
			assertTrue(("6").compareTo(asignatura.getCreditos())==0);
			assertTrue(("Sí").compareTo(asignatura.getOfertada())==0);
			assertTrue(("Asignatura de Prueba").compareTo(asignatura.getNombre())==0);
			assertEquals(3, asignatura.getCurso());
			assertTrue(("-").compareTo(asignatura.getCreditos())==0);
			assertTrue(("2º Semestre").compareTo(asignatura.getDuracion())==0);
			assertTrue(("-").compareTo(asignatura.getUnidad_temporal())==0);
			assertTrue(("-").compareTo(asignatura.getIdiomas())==0);
		} catch (TrazabilidadException e) {
			fail("No debería lanzar excepción");
		}
	}
	
}
