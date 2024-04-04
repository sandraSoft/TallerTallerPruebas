package sia;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.*;

class TestUsuariosSia {

    @Test
    void testLoginFuncionario(){
        System.setProperty("webdriver.chrome.driver",	"chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://acad.ucaldas.edu.co/Default.aspx");
        WebElement campoUsuario =
                driver.findElement(By.name("ctl00$cphMaster$txtUsuario"));
        WebElement campoContrasena =
                driver.findElement(By.name("ctl00$cphMaster$txtContrasena"));
        WebElement botonIngresar =
                driver.findElement(By.name("ctl00$cphMaster$btnIniciar"));

        campoUsuario.sendKeys("12345");
        campoContrasena.sendKeys("12345");
        botonIngresar.click();

        WebElement etiquetaNombre =
                driver.findElement(By.xpath("/html/body/form/center/table/tbody/tr[2]/td/div/div[11]/center/table/tbody/tr[1]/td[2]/b/i/span"));
        assertEquals("Funcionario de Prueba Becas",etiquetaNombre.getText());

        WebElement enlaceSalir =
                driver.findElement(By.linkText("Salir"));
        enlaceSalir.click();
        driver.quit();
    }

    @Test
    void testMenuBecario(){
        System.setProperty("webdriver.chrome.driver",	"chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://acad.ucaldas.edu.co/Default.aspx");
        WebElement campoUsuario =
                driver.findElement(By.name("ctl00$cphMaster$txtUsuario"));
        WebElement campoContrasena =
                driver.findElement(By.name("ctl00$cphMaster$txtContrasena"));
        WebElement botonIngresar =
                driver.findElement(By.name("ctl00$cphMaster$btnIniciar"));

        campoUsuario.sendKeys("12345678");
        campoContrasena.sendKeys("12345678");
        botonIngresar.click();

        WebElement select =
                driver.findElement(By.name("ctl00$cphMaster$ddlPerfiles"));
        Select perfil = new Select(select);
        perfil.selectByIndex(1);

        WebElement menu = driver.findElement(By.xpath(
                "/html/body/form/center/table/tbody/tr[2]/td/div/div[11]/table/tbody/tr/td[1]/div/div/table/tbody/tr/td[2]/span/table/tbody/tr/td[2]"));

        assertEquals("Asuntos Estudiantiles", menu.getText());

        WebElement enlaceSalir =
                driver.findElement(By.linkText("[Salir Modo Seguro]"));
        enlaceSalir.click();
        driver.quit();
    }
}