package proyecto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import ejb.GestionGrupo;
import ejb.excepciones.GrupoExistenteException;
import ejb.excepciones.GrupoNoEncontradoException;
import ejb.excepciones.TrazabilidadException;
import es.uma.informatica.sii.anotaciones.Requisitos;
import jpa.entidades.Grupo;


public class GrupoT {

	private static final String GRUPOS_EJB = "java:global/classes/GrupoEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "sii_grupor";
	
	private GestionGrupo gestionGrupo;
	
	@Before
	public void setup() throws NamingException  {
		gestionGrupo = (GestionGrupo) SuiteTest.ctx.lookup(GRUPOS_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Requisitos({"RF03.1"})
	@Test
	public void testInsertarGrupo() {
		
		try {
			
			Grupo g1 = new Grupo("4AINF2021",4,'A',"Tarde","No","Si","Hola",40);
			
			try {
				gestionGrupo.insertarGrupo(g1);
			} catch (GrupoExistenteException e) {
				fail("Se ha lanzado excepcion");
			}
			
		} catch (TrazabilidadException e) {
			throw new RuntimeException(e);
		}
		
		try {
			Grupo g2 = gestionGrupo.obtenerGrupo("4AINF2021");
			assertEquals("4AINF2021",g2.getId());
			assertEquals(4, g2.getCurso());
			assertEquals('A', g2.getLetra());
			assertEquals("Tarde", g2.getTurno());
			assertEquals("No", g2.getIngles());
			assertEquals("Si", g2.getVisible());
			assertEquals("Hola", g2.getAsignar());
			assertEquals(40, g2.getPlazas());
		} catch (TrazabilidadException e) {
			fail("No pasa las pruebas");
		}
		
	}

	@Requisitos({"RF03.1"})
	@Test
	public void testInsertarGrupoExistente() {
		Grupo g = new Grupo("2DINF2021",2,'D',"Tarde","No","Si",null,30);
		
		try {
			gestionGrupo.insertarGrupo(g);
			fail("Debe lanzar excepci�n");
		} catch (GrupoExistenteException e) {
			//OK
		} catch (TrazabilidadException e) {
			fail("Debe lanzar GrupoExistenteException");
		}
	}
	
	@Requisitos({"RF03.2"})
	@Test
	public void testObtenerGrupo() {
		try {
			Grupo g = gestionGrupo.obtenerGrupo("1AINF2021");
			assertEquals("1AINF2021",g.getId());
			assertEquals(1, g.getCurso());
			assertEquals('A', g.getLetra());
			assertEquals("Ma�ana", g.getTurno());
			assertEquals("Si", g.getIngles());
			assertEquals("No", g.getVisible());
			assertEquals(null, g.getAsignar());
			assertEquals(20, g.getPlazas());
		} catch (TrazabilidadException e) {
			fail("Lanza una excepci�n al obtener");
		}
	}
	
	@Requisitos({"RF03.2"})
	@Test
	public void testObtenerGrupoNoExistente() {
		try {
			Grupo g = gestionGrupo.obtenerGrupo("IDINVENTADO");
			fail("Debe lanzar la excepcion");
		} catch (GrupoNoEncontradoException e) {
			// OK
		} catch (TrazabilidadException e) {
			fail("Debe lanzar GrupoNoEncontradoException");
		}
	}
	
	@Requisitos({"RF03.3"})
	@Test
	public void testActualizarGrupo() {
		Grupo gr = new Grupo("2DINF2021",2,'D',"Tarde","Si","No","Asignado",40);
		try {
			gestionGrupo.actualizarGrupo(gr);
		} catch (TrazabilidadException e) {
			fail("Lanza una excepci�n al actualizar");
		}
	}
	
	@Requisitos({"RF03.3"})
	@Test
	public void testActualizarGrupoNoExistente() {
		Grupo gr = new Grupo("IDINVENTADO",2,'D',"Tarde","Si","No","Asignado",40);
		try {
			gestionGrupo.actualizarGrupo(gr);
		} catch (GrupoNoEncontradoException e) {
			// OK
		} catch (TrazabilidadException e) {
			fail("Debe lanzar GrupoNoEncontradoException");
		}
	}
	
	@Requisitos({"RF03.4"})
	@Test
	public void testEliminarGrupo() {
		Grupo gr = new Grupo("3BINF2021",3,'B',"Ma�ana","No","Si",null,60);
		try {
			gestionGrupo.eliminarGrupo(gr);
			
			try {
				gestionGrupo.obtenerGrupo("3BINF2021");
			} catch (GrupoNoEncontradoException e) {
				// OK
			} catch (TrazabilidadException e) {
				fail("Debe lanzar GrupoNoEncontradoException");
			}
		} catch (TrazabilidadException e) {
			fail("Lanza una excepion al eliminar");
		}
	}
	
	@Requisitos({"RF03.4"})
	@Test
	public void testEliminarGrupoNoExistente() {
		Grupo gr = new Grupo("3DSOF2122",3,'D',"Ma�ana","No","Si",null,60);
		try {
			gestionGrupo.eliminarGrupo(gr);
			fail("Debe lanzar GrupoNoEncontradoException");
		} catch (GrupoNoEncontradoException e) {
			// OK
		} catch (TrazabilidadException e) {
			fail("Debe lanzar GrupoNoEncontradoException");
		}
	}
}
