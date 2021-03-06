// Generated by Selenium IDE
package es.uma.informatica.sii.sii_grupor.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import es.uma.informatica.sii.anotaciones.Requisitos;



public class DefaultSuiteIT {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
	public void setUp() {
		
		driver = new FirefoxDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
		
	}

	@After
	public void tearDown() {
		
		driver.quit();
	}
	
	@BeforeClass
	public static void inicializarBD() {
		BaseDatos.inicializar("sii_gruporTestIT");
	}
	
	//Menús: Test sencillo introductorio que comprueba que funciona el acceso a las secciones
	//de secretaría y de alumno (se haría automáticamente si se implementara el login)
	@Test
	public void mens() {
		driver.get("http://localhost:8080/sii_grupor-war/");
		driver.findElement(By.name("login:j_idt8")).click();
		assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("Menú principal"));
		driver.findElement(By.cssSelector("input:nth-child(3)")).click();
		driver.findElement(By.name("login:j_idt9")).click();
		assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("Menú principal secretaría"));
		driver.findElement(By.cssSelector("input:nth-child(7)")).click();
	}
	
	//realizarEncuesta: Comprueba el requisito realizar encuesta desde la parte de alumno, y luego
	//se mueve a la parte de secretaría y comprueba que los datos coinciden correctamente.
	//Para terminar elimina la encuesta y vuelve al menú principal.
	@Requisitos({"RF08"})
	@Test
	public void realizarEncuesta() {
		driver.get("http://localhost:8080/sii_grupor-war/");
		driver.findElement(By.name("login:j_idt8")).click();
		driver.findElement(By.cssSelector("input:nth-child(2)")).click();
		driver.findElement(By.id("encuesta:nexpediente")).sendKeys("104100001");
		driver.findElement(By.id("encuesta:asignaturas")).sendKeys("101,102,103,104,105,106");
		driver.findElement(By.id("encuesta:gr_preferente")).sendKeys("A");
		driver.findElement(By.id("encuesta:asig_ingles")).sendKeys("101,102");
		driver.findElement(By.name("encuesta:j_idt15")).click();
		driver.findElement(By.linkText("Volver al menú")).click();
		driver.findElement(By.cssSelector("input:nth-child(3)")).click();
		driver.findElement(By.name("login:j_idt9")).click();
		driver.findElement(By.cssSelector("input:nth-child(6)")).click();
		assertThat(driver.findElement(By.cssSelector("td:nth-child(2)")).getText(), is("104100001"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(3)")).getText(), is("101,102,103,104,105,106"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(4)")).getText(), is("A"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(5)")).getText(), is("101,102"));
		driver.findElement(By.name("encuestas:j_idt5:0:j_idt24")).click();
		driver.findElement(By.linkText("Volver al menú")).click();
		driver.findElement(By.cssSelector("input:nth-child(7)")).click();
	}
	
	//testAlumno: Comprueba el RU de alumno. Lee (R) y comprueba que los datos sean correctos, 
	//Modifica (U) el alumno y comprueba que se han guardado los cambios, y por último
	//modifica el alumno otra vez y lo devuelve a su estado original antes de volver al menú principal.
	@Requisitos({"RF04"})
	@Test
	public void testAlumno() {
		
		driver.get("http://localhost:8080/sii_grupor-war/");
		driver.findElement(By.name("login:j_idt9")).click();
		driver.findElement(By.cssSelector("input:nth-child(2)")).click();

		assertThat(driver.findElement(By.cssSelector("td:nth-child(2)")).getText(), is("12345678A"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(3)")).getText(), is("Profe"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(4)")).getText(), is("Apruébanos"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(5)")).getText(), is("Porfa"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(6)")).getText(), is("un5son6creditos@uma.es"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(7)")).getText(), is("aunqueseaun5@gmail.com"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(8)")).getText(), is("123456789"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(9)")).getText(), is("987654321"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(10)")).getText(), is("Teatinos 69"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(11)")).getText(), is("Málaga"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(12)")).getText(), is("Málaga"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(13)")).getText(), is("29001"));

		driver.findElement(By.id("alumnos:j_idt5:0:modificaralumnos")).click();
		
		driver.findElement(By.id("alumno:nombre")).clear();
		driver.findElement(By.id("alumno:nombre")).sendKeys("Gracias");
		driver.findElement(By.id("alumno:apellido1")).clear();
		driver.findElement(By.id("alumno:apellido1")).sendKeys("Profe");
		driver.findElement(By.id("alumno:apellido2")).clear();
		driver.findElement(By.id("alumno:apellido2")).sendKeys("BuenVerano");

		driver.findElement(By.id("alumno:accionalumnos")).click();

		assertThat(driver.findElement(By.cssSelector("td:nth-child(3)")).getText(), is("Gracias"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(4)")).getText(), is("Profe"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(5)")).getText(), is("BuenVerano"));

		driver.findElement(By.id("alumnos:j_idt5:0:modificaralumnos")).click();
		
		driver.findElement(By.id("alumno:nombre")).clear();
		driver.findElement(By.id("alumno:nombre")).sendKeys("Profe");
		driver.findElement(By.id("alumno:apellido1")).clear();
		driver.findElement(By.id("alumno:apellido1")).sendKeys("Apruébanos");
		driver.findElement(By.id("alumno:apellido2")).clear();
		driver.findElement(By.id("alumno:apellido2")).sendKeys("Porfa");

		driver.findElement(By.id("alumno:accionalumnos")).click();
		
		driver.findElement(By.linkText("Volver al menú")).click();
		driver.findElement(By.cssSelector("input:nth-child(7)")).click();
		
	}
	
	//testMatricula: Comprueba el RU de matricula. Lee (R) y comprueba que los datos sean correctos, 
	//Modifica (U) la matricula y comprueba que se han guardado los cambios, y por último
	//modifica la matricula otra vez y la devuelve a su estado original antes de volver al menú principal.
	@Requisitos({"RF06"})
	@Test
	public void testMatricula() {
		
		driver.get("http://localhost:8080/sii_grupor-war/");
		driver.findElement(By.name("login:j_idt9")).click();
		driver.findElement(By.cssSelector("input:nth-child(5)")).click();

		assertThat(driver.findElement(By.cssSelector("td:nth-child(1)")).getText(), is("2021"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(2)")).getText(), is("s"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(3)")).getText(), is("123456"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(4)")).getText(), is("Mañana"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(6)")).getText(), is("s"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(7)")).getText(), is("101,102,103,104,105,106,107,108,109,110"));

		driver.findElement(By.id("matriculas:j_idt5:0:modificarmatricula")).click();

		driver.findElement(By.id("matricula:turno")).clear();
		driver.findElement(By.id("matricula:turno")).sendKeys("Tarde");
		driver.findElement(By.id("matricula:listaAsig")).clear();
		driver.findElement(By.id("matricula:listaAsig")).sendKeys("101,102,106,107");

		driver.findElement(By.id("matricula:accionmatricula")).click();

		assertThat(driver.findElement(By.cssSelector("td:nth-child(4)")).getText(), is("Tarde"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(7)")).getText(), is("101,102,106,107"));
		
		driver.findElement(By.linkText("Volver al menú")).click();
		driver.findElement(By.cssSelector("input:nth-child(7)")).click();
		
	}
	
	//testAsignaturaExistente: comprueba que la aplicación devuelve un error cuando se introduce una
	//asignatura duplicada. Primero inserta una asignatura y luego inserta otra idéntica, y comprueba
	//que devuelve el código de error correcto. Por último elimina la asignatura y vuelve al menú.
	@Requisitos({"RF05"})
	@Test
	public void testAsignaturaExistente() {
		driver.get("http://localhost:8080/sii_grupor-war/");
		driver.findElement(By.name("login:j_idt9")).click();
		driver.findElement(By.cssSelector("input:nth-child(3)")).click();
		driver.findElement(By.name("asignaturas:j_idt40")).click();
		driver.findElement(By.id("asignatura:referencia")).sendKeys("123456789");
		driver.findElement(By.id("asignatura:codigo")).sendKeys("100");
		driver.findElement(By.id("asignatura:creditos")).sendKeys("6");
		driver.findElement(By.id("asignatura:ofertada")).sendKeys("si");
		driver.findElement(By.id("asignatura:nombre")).sendKeys("Matemáticas");
		driver.findElement(By.id("asignatura:curso")).sendKeys("1");
		driver.findElement(By.id("asignatura:caracter")).sendKeys("ob");
		driver.findElement(By.id("asignatura:duracion")).sendKeys("2 cuatrimestre");
		driver.findElement(By.id("asignatura:unidad_temporal")).sendKeys("cuatri");
		driver.findElement(By.id("asignatura:idiomas")).sendKeys("no");
		driver.findElement(By.name("asignatura:j_idt29")).click();
		driver.findElement(By.name("asignaturas:j_idt40")).click();
		driver.findElement(By.name("asignatura:j_idt30")).click();
		assertThat(driver.findElement(By.cssSelector("td:nth-child(2)")).getText(), is("123456789"));
		driver.findElement(By.name("asignaturas:j_idt40")).click();
		driver.findElement(By.id("asignatura:referencia")).sendKeys("123456789");
		driver.findElement(By.id("asignatura:codigo")).sendKeys("200");
		driver.findElement(By.id("asignatura:creditos")).sendKeys("6");
		driver.findElement(By.id("asignatura:ofertada")).sendKeys("no");
		driver.findElement(By.id("asignatura:nombre")).sendKeys("Estadistica");
		driver.findElement(By.id("asignatura:curso")).sendKeys("2");
		driver.findElement(By.id("asignatura:caracter")).sendKeys("obligatoria");
		driver.findElement(By.id("asignatura:duracion")).sendKeys("2 cuatrimestre");
		driver.findElement(By.id("asignatura:unidad_temporal")).sendKeys("cuatri");
		driver.findElement(By.id("asignatura:idiomas")).sendKeys("no");
		driver.findElement(By.name("asignatura:j_idt29")).click();
		assertThat(driver.findElement(By.cssSelector("p:nth-child(1)")).getText(),
				is("Se ha producido un error. Por favor, vuelva a intentarlo."));
		driver.findElement(By.linkText("Volver al menú")).click();
		driver.findElement(By.cssSelector("input:nth-child(7)")).click();
		driver.findElement(By.name("login:j_idt9")).click();
		driver.findElement(By.cssSelector("input:nth-child(3)")).click();
		driver.findElement(By.name("asignaturas:j_idt5:0:j_idt39")).click();
		driver.findElement(By.linkText("Volver al menú")).click();
		driver.findElement(By.cssSelector("input:nth-child(7)")).click();
	}
	
	//testAsignatura: Comprueba el CRUD de asignatura. Crea e inserta una asignatura, lee (R) y 
	//comprueba que los datos sean correctos, Modifica (U) la asignatura y comprueba que se han 
	//guardado los cambios, y por último elimina (D) la asignatura y vuelve al menú principal.
	@Requisitos({"RF05"})
	@Test
	public void testAsignatura() {
		driver.get("http://localhost:8080/sii_grupor-war/");
		driver.findElement(By.name("login:j_idt9")).click();
		driver.findElement(By.cssSelector("input:nth-child(3)")).click();
		driver.findElement(By.name("asignaturas:j_idt40")).click();
		driver.findElement(By.id("asignatura:referencia")).sendKeys("123456789");
		driver.findElement(By.id("asignatura:codigo")).sendKeys("101");
		driver.findElement(By.id("asignatura:creditos")).sendKeys("6");
		driver.findElement(By.id("asignatura:ofertada")).sendKeys("si");
		driver.findElement(By.id("asignatura:nombre")).sendKeys("Cálculo para la computación");
		driver.findElement(By.id("asignatura:curso")).sendKeys("1");
		driver.findElement(By.id("asignatura:caracter")).sendKeys("ob");
		driver.findElement(By.id("asignatura:duracion")).sendKeys("1");
		driver.findElement(By.id("asignatura:unidad_temporal")).sendKeys("cuatri");
		driver.findElement(By.id("asignatura:idiomas")).sendKeys("es");
		driver.findElement(By.name("asignatura:j_idt29")).click();
		assertThat(driver.findElement(By.cssSelector("td:nth-child(1)")).getText(), is("Cálculo para la computación"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(2)")).getText(), is("123456789"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(3)")).getText(), is("101"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(4)")).getText(), is("6"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(5)")).getText(), is("si"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(6)")).getText(), is("1"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(7)")).getText(), is("ob"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(8)")).getText(), is("1"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(9)")).getText(), is("cuatri"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(10)")).getText(), is("es"));
		driver.findElement(By.name("asignaturas:j_idt5:0:j_idt37")).click();
		driver.findElement(By.id("asignatura:nombre")).clear();
		driver.findElement(By.id("asignatura:nombre")).sendKeys("Matemáticas Discretas");
		driver.findElement(By.id("asignatura:codigo")).clear();
		driver.findElement(By.id("asignatura:codigo")).sendKeys("102");
		driver.findElement(By.name("asignatura:j_idt29")).click();
		assertThat(driver.findElement(By.cssSelector("td:nth-child(1)")).getText(), is("Matemáticas Discretas"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(3)")).getText(), is("102"));
		driver.findElement(By.name("asignaturas:j_idt5:0:j_idt39")).click();
		driver.findElement(By.linkText("Volver al menú")).click();
		driver.findElement(By.cssSelector("input:nth-child(7)")).click();
	}
	
	//testEncuesta: Comprueba el CRUD de encuesta. Crea e inserta una encuesta, lee (R) y 
	//comprueba que los datos sean correctos, Modifica (U) la encuesta y comprueba que se han 
	//guardado los cambios, y por último elimina (D) la encuesta y vuelve al menú principal.
	@Requisitos({"RF07"})
	@Test
	public void testEncuesta() {
		driver.get("http://localhost:8080/sii_grupor-war/");
		driver.findElement(By.name("login:j_idt9")).click();
		driver.findElement(By.cssSelector("input:nth-child(6)")).click();
		driver.findElement(By.name("encuestas:j_idt25")).click();
		driver.findElement(By.id("encuesta:nexpediente")).sendKeys("104100001");
		driver.findElement(By.id("encuesta:asignaturas")).sendKeys("101,102,103");
		driver.findElement(By.id("encuesta:gr_preferente")).sendKeys("A");
		driver.findElement(By.id("encuesta:asig_ingles")).sendKeys("101");
		driver.findElement(By.name("encuesta:j_idt15")).click();
		assertThat(driver.findElement(By.cssSelector("td:nth-child(2)")).getText(), is("104100001"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(3)")).getText(), is("101,102,103"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(4)")).getText(), is("A"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(5)")).getText(), is("101"));
		driver.findElement(By.name("encuestas:j_idt5:0:j_idt22")).click();
		driver.findElement(By.id("encuesta:gr_preferente")).clear();
		driver.findElement(By.id("encuesta:gr_preferente")).sendKeys("B");
		driver.findElement(By.id("encuesta:asig_ingles")).clear();
		driver.findElement(By.id("encuesta:asig_ingles")).sendKeys("101,102");
		driver.findElement(By.name("encuesta:j_idt15")).click();
		assertThat(driver.findElement(By.cssSelector("td:nth-child(4)")).getText(), is("B"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(5)")).getText(), is("101,102"));
		driver.findElement(By.name("encuestas:j_idt5:0:j_idt24")).click();
		driver.findElement(By.linkText("Volver al menú")).click();
		driver.findElement(By.cssSelector("input:nth-child(7)")).click();
	}
	
	//testGrupo: Comprueba el CRUD de grupo. Crea e inserta un grupo, lee (R) y 
	//comprueba que los datos sean correctos, Modifica (U) el grupo y comprueba que se han 
	//guardado los cambios, y por último elimina (D) el grupo y vuelve al menú principal.
	@Requisitos({"RF03"})
	@Test
	public void testGrupo() {
		driver.get("http://localhost:8080/sii_grupor-war/");
		driver.findElement(By.name("login:j_idt9")).click();
		driver.findElement(By.cssSelector("input:nth-child(4)")).click();
		driver.findElement(By.name("grupos:j_idt34")).click();
		driver.findElement(By.id("asignatura:id")).sendKeys("II1A");
		driver.findElement(By.id("asignatura:curso")).sendKeys("1");
		driver.findElement(By.id("asignatura:letra")).sendKeys("A");
		driver.findElement(By.id("asignatura:turno")).sendKeys("Mañana");
		driver.findElement(By.id("asignatura:ingles")).sendKeys("no");
		driver.findElement(By.id("asignatura:visible")).sendKeys("si");
		driver.findElement(By.id("asignatura:asignar")).sendKeys("si");
		driver.findElement(By.id("asignatura:plazas")).sendKeys("63");
		driver.findElement(By.name("asignatura:j_idt25")).click();
		assertThat(driver.findElement(By.cssSelector("td:nth-child(1)")).getText(), is("II1A"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(2)")).getText(), is("1"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(3)")).getText(), is("A"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(4)")).getText(), is("Mañana"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(5)")).getText(), is("no"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(6)")).getText(), is("si"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(7)")).getText(), is("si"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(8)")).getText(), is("63"));
		driver.findElement(By.name("grupos:j_idt5:0:j_idt31")).click();
		driver.findElement(By.id("asignatura:turno")).clear();
		driver.findElement(By.id("asignatura:turno")).sendKeys("Tarde");
		driver.findElement(By.id("asignatura:ingles")).clear();
		driver.findElement(By.id("asignatura:ingles")).sendKeys("si");
		driver.findElement(By.id("asignatura:asignar")).clear();
		driver.findElement(By.id("asignatura:asignar")).sendKeys("no");
		driver.findElement(By.name("asignatura:j_idt25")).click();
		assertThat(driver.findElement(By.cssSelector("td:nth-child(4)")).getText(), is("Tarde"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(5)")).getText(), is("si"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(7)")).getText(), is("no"));
		driver.findElement(By.name("grupos:j_idt5:0:j_idt33")).click();
		driver.findElement(By.linkText("Volver al menú")).click();
		driver.findElement(By.cssSelector("input:nth-child(7)")).click();
	}
	
	//testGrupoExistente: comprueba que la aplicación devuelve un error cuando se introduce un
	//grupo duplicado. Primero inserta un grupo y luego inserta otro idéntico, y comprueba
	//que devuelve el código de error correcto. Por último elimina el grupo y vuelve al menú.
	@Requisitos({"RF03"})
	@Test
	public void testGrupoExistente() {
		driver.get("http://localhost:8080/sii_grupor-war/");
		driver.findElement(By.name("login:j_idt9")).click();
		driver.findElement(By.cssSelector("input:nth-child(4)")).click();
		driver.findElement(By.name("grupos:j_idt34")).click();
		driver.findElement(By.id("asignatura:id")).sendKeys("II1A");
		driver.findElement(By.id("asignatura:curso")).sendKeys("1");
		driver.findElement(By.id("asignatura:letra")).sendKeys("A");
		driver.findElement(By.id("asignatura:turno")).sendKeys("Mañana");
		driver.findElement(By.id("asignatura:ingles")).sendKeys("no");
		driver.findElement(By.id("asignatura:visible")).sendKeys("si");
		driver.findElement(By.id("asignatura:asignar")).sendKeys("si");
		driver.findElement(By.id("asignatura:plazas")).sendKeys("63");
		driver.findElement(By.name("asignatura:j_idt25")).click();
		driver.findElement(By.name("grupos:j_idt34")).click();
		driver.findElement(By.name("asignatura:j_idt26")).click();
		assertThat(driver.findElement(By.cssSelector("td:nth-child(1)")).getText(), is("II1A"));
		driver.findElement(By.name("grupos:j_idt34")).click();
		driver.findElement(By.id("asignatura:id")).sendKeys("II1A");
		driver.findElement(By.id("asignatura:curso")).sendKeys("1");
		driver.findElement(By.id("asignatura:letra")).sendKeys("B");
		driver.findElement(By.id("asignatura:turno")).sendKeys("M");
		driver.findElement(By.id("asignatura:turno")).sendKeys("Mañana");
		driver.findElement(By.id("asignatura:ingles")).sendKeys("no");
		driver.findElement(By.id("asignatura:visible")).sendKeys("si");
		driver.findElement(By.id("asignatura:asignar")).sendKeys("no");
		driver.findElement(By.id("asignatura:plazas")).sendKeys("63");
		driver.findElement(By.name("asignatura:j_idt25")).click();
		assertThat(driver.findElement(By.cssSelector("p:nth-child(1)")).getText(),
				is("Se ha producido un error. Por favor, vuelva a intentarlo."));
		driver.findElement(By.linkText("Volver al menú")).click();
		driver.findElement(By.cssSelector("input:nth-child(4)")).click();
		driver.findElement(By.name("grupos:j_idt5:0:j_idt33")).click();
		driver.findElement(By.linkText("Volver al menú")).click();
		driver.findElement(By.cssSelector("input:nth-child(7)")).click();
	}
	
}
