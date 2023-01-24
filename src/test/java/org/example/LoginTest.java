package org.example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest {

    public static LoginPage loginPage;
    public static ProfilePage profilePage;
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

        driver.get(ConfProperties.getProperty("loginpage"));

        loginPage = new LoginPage(driver);

        profilePage = new ProfilePage(driver);
    }

    /**
     * тестовый метод для осуществления аутентификации
     */

    @Test
    public void loginTest() {
        /**
         * значение login/password берутся из файла настроек по аналогии с chromedriver и loginpage.
         * Вводим логин.
         */
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //получаем отображаемый логин
        String user = profilePage.getUserName();
        //и сравниваем его с логином из файла настроек
        Assert.assertEquals(ConfProperties.getProperty("login"), user);
    }

    /**
     * осуществление выхода из аккаунта с последующим закрытием окна браузера
     */

    @AfterClass
    public static void tearDown() {
        profilePage.entryMenu();
        profilePage.userLogout();
        driver.quit(); }
}
