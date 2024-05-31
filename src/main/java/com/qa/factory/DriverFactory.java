package com.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
        public WebDriver driver;
        public WebDriver getDriver(String browser){
            if(browser.equals("chrome")){
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                WebDriverManager.chromedriver().capabilities(chromeOptions).create();
                driver = new ChromeDriver(chromeOptions);
            }else if(browser.equals("xyz")){

            }else{
                System.out.println("Enter Correct browser Name");
            }
            return driver;
        }

}
