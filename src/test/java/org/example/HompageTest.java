package org.example;

import configReader.ConfigPropReader;
import org.example.driverFactory.DriverFactory;
import org.example.pages.Homepage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Properties;

public class HompageTest {
   private DriverFactory df;
   private ConfigPropReader config;
   private Properties prop;
   private WebDriver driver;
   Homepage homepage;

    @BeforeTest
    public void setup(){
        config = new ConfigPropReader();
        prop = config.initLangProp();
        df = new DriverFactory();
       driver= df.initDriver("chrome",prop);
       homepage = new Homepage(driver);
    }

    @Test
    public void headerTest(){
        Assert.assertTrue(homepage.isNavHeaderExist(prop.getProperty("navHeader")));
    }

    @Test
    public void contactFooterTest(){
        Assert.assertTrue(homepage.isContactInFooterExist(prop.getProperty("contactFooter")));
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
