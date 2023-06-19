package org.example.pages;

import org.example.utils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Properties;

public class Homepage {
    private WebDriver driver;
    private ElementUtils elementUtil;

    public Homepage(WebDriver driver) {
        this.driver = driver;
        this.elementUtil = new ElementUtils(driver);
    }

    private By inp_login = By.xpath("");

    private WebElement getFooterContactLink(String contactValue) {
        String contactXpathValue = "//a[contains(text(),'" + contactValue + "')]";
        return elementUtil.getElement("xpath", contactXpathValue);
    }
    public boolean isContactInFooterExist(String contactValue){
        return getFooterContactLink(contactValue).isDisplayed();
    }

    private WebElement getNavHeader(String navHeaderValue) {
        String headerXpathValue = "//a[contains(text(),'" + navHeaderValue + "')]";
        return elementUtil.getElement("xpath", headerXpathValue);
    }
    public boolean isNavHeaderExist(String navHeaderValue){
        String navHeaderText = getNavHeader(navHeaderValue).getText();
        System.out.println(navHeaderText);
        return getNavHeader(navHeaderValue).isDisplayed();
    }



}
