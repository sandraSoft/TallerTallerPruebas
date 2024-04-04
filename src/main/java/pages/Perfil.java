package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Perfil {
    private WebDriver driver;

    public Perfil(WebDriver driver) {
        this.driver = driver;
    }

    public void seleccionarPerfil(int posicion){
        WebElement select =
                driver.findElement(By.name("ctl00$cphMaster$ddlPerfiles"));
        Select perfil = new Select(select);
        perfil.selectByIndex(posicion);
    }

    public String obtenerNombreUsuario(){
        WebElement etiquetaNombre =
                driver.findElement(By.xpath("/html/body/form/center/table/tbody/tr[2]/td/div/div[11]/center/table/tbody/tr[1]/td[2]/b/i/span"));
        return etiquetaNombre.getText();
    }

    public void salir() {
        WebElement enlaceSalir = driver.findElement(By.linkText("Salir"));
        enlaceSalir.click();
    }
}
