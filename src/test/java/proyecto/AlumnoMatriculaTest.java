package proyecto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Properties;
import java.util.logging.Logger;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ejb.GestionAlumnos;
import ejb.GestionAsignaturas;
import ejb.GestionMatricula;
import ejb.excepciones.AsignaturaExistenteException;
import ejb.excepciones.AsignaturaNoEncontradoException;
import ejb.excepciones.TrazabilidadException;
import jpa.entidades.Alumno;
import jpa.entidades.Asignatura;
import jpa.entidades.Expediente;
import jpa.entidades.Matricula;

public class AlumnoMatriculaTest {
	private static final Logger LOG = Logger.getLogger(AsignaturaTest.class.getCanonicalName());

	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
	private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
	private static final String ALUMNO_EJB = "java:global/classes/AlumnoEJB";
	private static final String MATRICULA_EJB = "java:global/classes/MatriculaEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "sii_grupor";
	
	private static EJBContainer ejbContainer;
	private static Context ctx;
	
	private GestionAlumnos gestionAlumnos;
	private GestionMatricula gestionMatricula;
	
	@PersistenceContext(name="sii_grupor")
	private EntityManager em;
	
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

	
	@AfterClass
	public static void tearDownClass() {
		if (ejbContainer != null) {
			ejbContainer.close();
		}
	}
}
