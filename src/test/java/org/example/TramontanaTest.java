package org.example;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class TramontanaTest {

    public static EntryMountain tramontana;

    public static Mountaineering mountaining;

    public static Drawbacks drawbacks;

    public static WebDriver driver;

    /**
     * осуществление первоначальной настройки
     */

    @BeforeClass
    public static void setUp() {

        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(ConfProperties.getProperty("pageMountain"));

        tramontana = new EntryMountain(driver);

        mountaining = new Mountaineering(driver);

        drawbacks = new Drawbacks(driver);
    }

    /**
     * тестовый метод для осуществления аутентификации
     */

    @Test
    public void chapterMountainTest() {

        tramontana.moveMountain();

        mountaining.moveDrawbacks();

        assertTrue(drawbacks.checkProductCard());
    }

    /**
     * осуществление выхода из аккаунта с последующим закрытием окна браузера
     */

    @AfterClass
    public static void tearDown() {
        driver.quit(); }
}
