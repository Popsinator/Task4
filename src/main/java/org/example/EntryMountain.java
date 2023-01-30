package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EntryMountain {

    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;

    public EntryMountain(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора поля ввода логина
     */
    @FindBy(xpath = ".//a[@class = 'nav-link'][text() = 'Альпинизм']")
    private WebElement chapterMountain;


    /**
     * метод для ввода логина
     */
    public Mountaineering moveMountain() {
        chapterMountain.click();
        return new Mountaineering(driver);
    }
}
