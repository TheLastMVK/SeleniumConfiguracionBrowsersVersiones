package com.magento.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class Firefox_HomeTest {
    WebDriver driver; // creo un objeto llamado driver de tipo WebDriver
    int TIME_OUT = 10;
    String  EXPECTED_TITLE = "Home Page";

    //PRE CONDICIONES
    @BeforeMethod
    public void setUpWithFirefox() {
        FirefoxOptions options = new FirefoxOptions(); //declara objeto e instancia al mismo tiempo.
        options.setBrowserVersion("123"); // Para asignar la versión del navegador: 122.0, 121.0, 120, 119, 118, 117, dev, nightly, 125
        driver = new FirefoxDriver(options); // Instancia el objeto driver de tipo Browser (y le agregamos options para que absorba las configuraciones)
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
