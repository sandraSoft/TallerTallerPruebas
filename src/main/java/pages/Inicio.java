package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Inicio {

    private WebDriver driver;

    public Inicio(WebDriver driver) {
        this.driver = driver;
    }

    public void escribirUsuario(String usuario) {
        driver.findElement(By.name("ctl00$cphMaster$txtUsuario")).sendKeys(usuario);
    }

    public void escribirContrasena(String contrasena){
        driver.findElement(By.name("ctl00$cphMaster$txtContrasena")).sendKeys(contrasena);
    }

    public void clickOK() {
        driver.findElement(By.name("ctl00$cphMaster$btnIniciar")).click();
    }

    // TAMBIÉN se pueden agrupar acciones:
    public void login(String usuario,String constrasena) {
        escribirUsuario(usuario);
        escribirContrasena(constrasena);
        clickOK();
    }
}
