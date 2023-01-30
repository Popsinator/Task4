package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Mountaineering {

    /**
     *конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public Mountaineering(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора поля ввода логина
     */
    @FindBy(xpath = ".//a[@class = 'filter-accordion__btn no-arrow'][contains(text(), 'Оттяжки')]")
    private WebElement chapterDrawbacks;


    /**
     * метод для ввода логина
     */
    public Drawbacks moveDrawbacks() {
        chapterDrawbacks.click();
        return new Drawbacks(driver);
    }
}
