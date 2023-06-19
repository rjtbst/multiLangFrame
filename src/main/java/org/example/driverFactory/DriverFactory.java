package org.example.driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

 public class DriverFactory {
  private WebDriver driver;
    public WebDriver initDriver(String browserName, Properties prop){
        switch (browserName.toLowerCase()){
            case "chrome":
         WebDriverManager.chromedriver().setup();
         ChromeOptions options = new ChromeOptions();
         options.addArguments("--headless");
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
            break;
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            break;
        }
        System.out.println("driver is: "+ browserName);
      driver.get(prop.getProperty("url"));
      driver.manage().deleteAllCookies();
      driver.manage().window().maximize();
      return driver;
    }
}
