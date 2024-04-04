package otras;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestAvanzados {

    @Test
    void testWaitSelect() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer");

        // Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        // wait.until(d -> driver.findElement(By.name("userSelect")).isDisplayed());

        Select selectorVista = new Select(driver.findElement(By.name("userSelect")));
        selectorVista.selectByVisibleText("Harry Potter");

        WebElement boton = driver.findElement(By.className("btn-default"));
        boton.click();

        WebElement nombre = driver.findElement(By.cssSelector(".fontBig"));
        assertEquals("Harry Potter", nombre.getText());
        driver.findElement(By.cssSelector(".logout")).click();

        driver.quit();
    }

    @Test
    void testJavascriptWait() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://www.ecosia.org/");

        String fraseBusqueda = "Functional Testing";

        WebElement campoBusqueda = driver.findElement(By.name("q"));
        campoBusqueda.sendKeys(fraseBusqueda + Keys.ENTER);

        assertEquals(fraseBusqueda + " - Ecosia - Web", driver.getTitle());

        WebElement enlace = driver.findElement(By.partialLinkText("Wikipedia"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", enlace);

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.titleContains("Wikipedia"));
        assertTrue(driver.getTitle().contains("Wikipedia"));

        driver.quit();
    }
}
