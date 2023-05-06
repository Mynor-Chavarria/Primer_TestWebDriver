package selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AppTest {
    private WebDriver driver;
    @BeforeEach // al Iniciar prueba
    void setUp(){
        ChromeOptions options = new ChromeOptions();

        //Ventana Maximizada, Incognito, Sin InterfazGráfica(Ideal cuando se finalizan las pruebas)
        options.addArguments("--start-maximized", "--incognito", "--headless");
        driver = new ChromeDriver(options);
    }
    @Test
    void openGoogle(){
//        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        Assertions.assertEquals( "Google", driver.getTitle());

    }

    @AfterEach //Al finalizar prueba
    void tearDowm(){
        driver.quit();
    }

    @Test
    void googleSearch(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.submit();

        Assertions.assertTrue(driver.getTitle().contains("Selenium WebDriver"));
    }

}
