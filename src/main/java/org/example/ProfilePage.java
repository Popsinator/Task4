package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение главного меню после успешной авторизации
     */
    @FindBy(xpath = ".//div[@class = 'PageTemplate_sidebar__jWClF']")
    private WebElement mainMenu;

    public boolean checkMenuDisplayed() {
        return mainMenu.isDisplayed();
    }
}