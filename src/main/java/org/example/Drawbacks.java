package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Drawbacks {

    /**
     *конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public Drawbacks(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора поля ввода логина
     */
    @FindBy(xpath = ".//img[@alt = 'Удочка для встегивания оттяжек KAILAS Clip Up III']")
    private WebElement productCard;


    /**
     * метод для ввода логина
     */
    public boolean checkProductCard() {
        /*((JavascriptExecutor) driver).executeScript("window.scrollTo(0, Math.max" +
                "(document.documentElement.scrollHeight, document.body.scrollHeight, " +
                "document.documentElement.clientHeight));");
        new WebDriverWait(driver, 1000).until(ExpectedConditions..
                textToBePresentInElementLocated(By.xpath(".//img[@alt = 'Удочка для встегивания оттяжек KAILAS Clip Up III']"),
                        "Удочка для встегивания оттяжек KAILAS Clip Up III"));*/
        while (!productCard.isDisplayed()) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0,250)");
        }
        return productCard.isDisplayed();
    }
}
