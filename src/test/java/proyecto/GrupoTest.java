package proyecto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ejb.GrupoEJB;
import ejb.GestionGrupo;
import ejb.excepciones.*;
import es.uma.informatica.sii.anotaciones.Requisitos;
import jpa.entidades.Grupo;

public class GrupoTest {

	private static final Logger LOG = Logger.getLogger(GrupoTest.class.getCanonicalName());

	private static final String GRUPOS_EJB = "java:global/classes/GrupoEJB";
	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
	private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "sii_grupor";
	
	private static EJBContainer ejbContainer;
	private static Context ctx;
	
	private GestionGrupo gestionGrupo;
	
	@BeforeClass
	public static void setUpClass() {
		Properties properties = new Properties();
		properties.setProperty(GLASSFISH_CONFIGI_FILE_PROPERTY, CONFIG_FILE);
		ejbContainer = EJBContainer.createEJBContainer(properties);
		ctx = ejbContainer.getContext();
	}
	
	@Before
	public void setup() throws NamingException  {
		gestionGrupo = (GestionGrupo) ctx.lookup(GRUPOS_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Requisitos({"RF03.1"})
	@Test
	public void testInsertarGrupo() {
		
		try {
			
			Grupo g = new Grupo(4,'A',"Tarde","No","Sí","Hola",40);
			
			try {
				gestionGrupo.insertarGrupo(g);
				assertNotNull(g.getId());
			} catch (GrupoExistenteException e) {
				fail("Excepción");
			}
			
		} catch (TrazabilidadException e) {
			throw new RuntimeException(e);
		}
	}
}
