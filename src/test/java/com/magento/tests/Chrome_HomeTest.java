package com.magento.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class Chrome_HomeTest {
    WebDriver driver; // creo un objeto llamado driver de tipo WebDriver
    int TIME_OUT = 10;
    String  EXPECTED_TITLE = "Home Page";

    //PRE CONDICIONES
    @BeforeMethod
    public void setUpWithChrome() {
        ChromeOptions options = new ChromeOptions(); //declara objeto e instancia al mismo tiempo.
        options.setBrowserVersion("113"); // Para asignar la versión del navegador: 115, 113, 116.0.5793.0, dev (modo development)
        driver = new ChromeDriver(options); // Instancia el objeto driver de tipo Browser (y le agregamos options para que absorba las configuraciones)
        driver.manage().window().maximize(); // maximizamos el navegador inicializado
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIME_OUT)); // espera 10 segundos hasta que ubiquemos el primer elemento
        driver.get("https://magento.softwaretestingboard.com/");
    }
    //TEST
    @Test
    public void verifyTitle() {
        Assert.assertEquals(driver.getTitle(),EXPECTED_TITLE);
    }
    //POST CONDICIONES
    @AfterMethod
    public void tearDown() {
       driver.close(); // cierra la ventana de la instancia creada
       driver.quit(); // termina la instancia creada y deja el puerto libre
    }
}
