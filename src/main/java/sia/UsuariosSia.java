package sia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsuariosSia {

    public static void main(String[] args) {
        // Para Chrome:
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
                driver.findElement(
                        By.xpath("/html/body/form/center/table/tbody/tr[2]/td/div/div[11]/center/table/tbody/tr[1]/td[2]/b/i/span"));
        System.out.println(etiquetaNombre.getText());

        WebElement enlaceSalir =
                driver.findElement(By.linkText("Salir"));
        enlaceSalir.click();
        driver.quit();

    }
}
