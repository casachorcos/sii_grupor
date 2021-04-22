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

public class EncuestaTest {

	private static final Logger LOG = Logger.getLogger(EncuestaTest.class.getCanonicalName());

	private static final String ENCUESTAS_EJB = "java:global/classes/EncuestaEJB";
	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
	private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "sii_grupor";
	
	private static EJBContainer ejbContainer;
	private static Context ctx;
	
	private GestionEncuestas gestionEncuesta;
	
	@BeforeClass
	public static void setUpClass() {
		Properties properties = new Properties();
		properties.setProperty(GLASSFISH_CONFIGI_FILE_PROPERTY, CONFIG_FILE);
		ejbContainer = EJBContainer.createEJBContainer(properties);
		ctx = ejbContainer.getContext();
	}
	
	@Before
	public void setup() throws NamingException  {
		gestionEncuesta = (GestionEncuestas) ctx.lookup(ENCUESTAS_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Requisitos({"RF03.1"})
	@Test
	public void testInsertarEncuesta() {
		
		try {
			
			Encuesta e = new Encuesta(new Date(2021, 4, 22));
			
			try {
				gestionEncuesta.insertarEncuesta(e);
			} catch (EncuestaExistenteException ex) {
				fail("Excepcion");
			}
			
		} catch (TrazabilidadException e) {
			throw new RuntimeException(e);
		}
		
		try {
			Encuesta en = gestionEncuesta.obtenerEncuesta(new Date(2021, 4, 22, 13, 21, 56));
			assertEquals(new Date(2021, 4, 22, 13, 21, 56), en.getFecha_de_envio());
		} catch (TrazabilidadException e) {
			throw new RuntimeException(e);
		}
		
	}
}
