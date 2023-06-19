package org.example.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtils {
    private WebDriver driver;
    public ElementUtils(WebDriver driver){
        this.driver = driver;
    }


    public WebElement getElement(By locator){
        return driver.findElement(locator);
    }

    public WebElement getElement(String locatorType, String locatorValue){
        return driver.findElement(getBy(locatorType, locatorValue));
    }

    private By getBy(String locatorType, String locatorValue) {
        By locator = null;
        switch (locatorType.toLowerCase()){
            case "xpath" :
                    locator= By.xpath(locatorValue);
                    break;
            case "id" :
                locator = By.id(locatorValue);
                break;
            case "linktext" :
                    locator = By.linkText(locatorValue);
                    break;
            case "name" :
                locator = By.name(locatorValue);
                break;
            case "cssselector" :
                locator = By.cssSelector(locatorValue);
                break;
            default:
                System.out.println("Unexpected locator type or value: " + locatorType.toLowerCase());
        }

        return locator;
    }
}
