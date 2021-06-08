// Generated by Selenium IDE
package es.uma.informatica.sii.sii_grupor.test;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

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

	@Test
	public void testAlumno() {
		//TODO: 
		//persist de alumno con el em
		driver.get("http://localhost:8080/sii_grupor-war/");
		driver.findElement(By.name("login:j_idt9")).click();
		driver.findElement(By.cssSelector("input:nth-child(2)")).click();

		assertThat(driver.findElement(By.cssSelector("td:nth-child(1)")).getText(), is("12345678A"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(2)")).getText(), is("Profe"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(3)")).getText(), is("Apruébanos"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(4)")).getText(), is("Porfa"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(5)")).getText(), is("un5son6creditos@uma.es"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(6)")).getText(), is("aunqueseaun5@gmail.com"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(7)")).getText(), is("123456789"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(8)")).getText(), is("987654321"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(8)")).getText(), is("Teatinos 69"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(8)")).getText(), is("Málaga"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(8)")).getText(), is("Málaga"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(8)")).getText(), is("29001"));

		driver.findElement(By.name("alumnos:modificaralumnos")).click();
		
		driver.findElement(By.id("alumno:nombre")).clear();
		driver.findElement(By.id("alumno:nombre")).sendKeys("Gracias");
		driver.findElement(By.id("alumno:apellido1")).clear();
		driver.findElement(By.id("alumno:apellido1")).sendKeys("Profe");
		driver.findElement(By.id("alumno:apellido2")).clear();
		driver.findElement(By.id("alumno:apellido2")).sendKeys("BuenVerano");

		driver.findElement(By.name("alumnos:accionalumnos")).click();

		assertThat(driver.findElement(By.cssSelector("td:nth-child(2)")).getText(), is("Gracias"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(3)")).getText(), is("Profe"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(4)")).getText(), is("BuenVerano"));

		driver.findElement(By.linkText("Volver al menú")).click();
		driver.findElement(By.cssSelector("input:nth-child(7)")).click();
	}

	@Test
	public void testMatricula() {
		//TODO: 
		//persist de matricula con el em
		driver.get("http://localhost:8080/sii_grupor-war/");
		driver.findElement(By.name("login:j_idt9")).click();
		driver.findElement(By.cssSelector("input:nth-child(5)")).click();

		assertThat(driver.findElement(By.cssSelector("td:nth-child(1)")).getText(), is("2021"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(2)")).getText(), is("s"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(3)")).getText(), is("123456789"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(4)")).getText(), is("Mañana"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(6)")).getText(), is("si"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(7)")).getText(), is("101,102,103,104,105,106,107,108,109,110"));

		driver.findElement(By.name("matriculas:modificarmatricula")).click();

		driver.findElement(By.id("matricula:turno")).clear();
		driver.findElement(By.id("matricula:turno")).sendKeys("Tarde");
		driver.findElement(By.id("matricula:listaAsig")).clear();
		driver.findElement(By.id("matricula:listaAsig")).sendKeys("101,102,106,107");

		driver.findElement(By.name("matriculas:accionmatricula")).click();

		assertThat(driver.findElement(By.cssSelector("td:nth-child(4)")).getText(), is("Tarde"));
		assertThat(driver.findElement(By.cssSelector("td:nth-child(7)")).getText(), is("101,102,106,107"));
		
		driver.findElement(By.linkText("Volver al menú")).click();
		driver.findElement(By.cssSelector("input:nth-child(7)")).click();
	}

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
