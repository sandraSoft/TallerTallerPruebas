package sia;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Dashboard;
import pages.Inicio;
import pages.Perfil;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestUsuariosSiaPom {

    private WebDriver driver;

    @BeforeAll
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver",	"chromedriver.exe");
    }

    @BeforeEach
    public void abrirNavegador(){
        driver = new ChromeDriver();
        driver.get("https://acad.ucaldas.edu.co/Default.aspx");
    }

    @AfterEach
    public void cerrarNavegador(){
        driver.quit();
    }

    @Test
    void testLoginFuncionario(){
        Inicio paginaInicio = new Inicio(driver);
        paginaInicio.escribirUsuario("12345");
        paginaInicio.escribirContrasena("12345");
        paginaInicio.clickOK();

        // Otra alternativa es:
        // paginaInicio.login("12345", "12345");

        Perfil paginaPerfil = new Perfil(driver);
        String nombreUsuario = paginaPerfil.obtenerNombreUsuario();

        assertEquals("Funcionario de Prueba Becas", nombreUsuario);

        paginaPerfil.salir();
    }

    @Test
    void testMenuBecario(){
        Inicio paginaInicio = new Inicio(driver);
        paginaInicio.escribirUsuario("12345678");
        paginaInicio.escribirContrasena("12345678");
        paginaInicio.clickOK();

        Perfil paginaPerfil = new Perfil(driver);
        paginaPerfil.seleccionarPerfil(1);

        Dashboard dashboard = new Dashboard(driver);
        String nombreMenu = dashboard.obtenerNombreMenu();

        assertEquals("Asuntos Estudiantiles", nombreMenu);

        dashboard.salir();
    }
}