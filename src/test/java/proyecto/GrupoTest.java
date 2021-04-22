package proyecto;


import static org.junit.Assert.assertEquals;
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

import ejb.GestionAlumnos;
import ejb.GestionMatricula;
import ejb.excepciones.AlumnoNoEncontradoException;
import ejb.excepciones.TrazabilidadException;
import jpa.entidades.Alumno;


public class GrupoTest {
	
	private static final Logger LOG = Logger.getLogger(GrupoTest.class.getCanonicalName());

	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
	private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
	private static final String ALUMNO_EJB = "java:global/classes/AlumnoEJB";
	private static final String MATRICULA_EJB = "java:global/classes/MatriculaEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "TrazabilidadTest";
	
	private static EJBContainer ejbContainer;
	private static Context ctx;
	
	private GestionAlumnos gestionAlumnos;
	private GestionMatricula gestionMatricula;
	
	@BeforeClass
	public static void setUpClass() {
		Properties properties = new Properties();
		properties.setProperty(GLASSFISH_CONFIGI_FILE_PROPERTY, CONFIG_FILE);
		ejbContainer = EJBContainer.createEJBContainer(properties);
		ctx = ejbContainer.getContext();
	}
	
	@Before
	public void setup() throws NamingException  {
		gestionAlumnos = (GestionAlumnos) ctx.lookup(ALUMNO_EJB);
		gestionMatricula = (GestionMatricula) ctx.lookup(MATRICULA_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Test
	public void testInsertarAlumno() {
		Alumno prueba = new Alumno("888954","Dani","Lechuga","Ruiz","pruebak@uma.es","sp1","72778113","95212812","C/Parrados","Malaga","Malaga",(long)29010);
		
		try {
			gestionAlumnos.insertarAlumno(prueba);
		} catch (AlumnoNoEncontradoException h) {
			fail("No se ha encontrado el alumno");
		}
	}
	
	@AfterClass
	public static void tearDownClass() {
		if (ejbContainer != null) {
			ejbContainer.close();
		}
	}

}