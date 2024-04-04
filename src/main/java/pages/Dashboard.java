package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dashboard {
    private WebDriver driver;

    public Dashboard(WebDriver driver) {
        this.driver = driver;
    }

    public String obtenerNombreMenu(){
        WebElement menu = driver.findElement(By.xpath(
                "/html/body/form/center/table/tbody/tr[2]/td/div/div[11]/table/tbody/tr/td[1]/div/div/table/tbody/tr/td[2]/span/table/tbody/tr/td[2]"));
        return menu.getText();
    }

    public void salir(){
        WebElement enlaceSalir =
                driver.findElement(By.linkText("[Salir Modo Seguro]"));
        enlaceSalir.click();
    }
}
