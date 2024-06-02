package com.pages;

import com.qa.util.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class SearchResultPage {
    private ConfigReader configReader;
    private Properties prop;

    public WebDriver driver;

     ProductDetailsPage productDetailsPage;
    @FindBy(xpath = "//div[@data-cel-widget='search_result_2']//*[contains(text(),'Monitor')]")
    WebElement FirstMonitor;

    @FindBy(xpath = "//div[@data-cel-widget='search_result_3']//*[contains(text(),'Laptop')]")
    WebElement secondLaptop;


    @FindBy(xpath = " //*[@id='corePriceDisplay_desktop_feature_div']/div[1]/span[3]/span[2]/span[2]")
    WebElement productPrice;

    @FindBy(xpath = "//*[@id='search']/span[2]/div/h1/div/div[1]/div/div/span[3]")
    WebElement resultsPageValidator;
    public SearchResultPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public  void validateResultPage(String itemSearched){
        String actualText = resultsPageValidator.getText();
        String expectedText = '"'+itemSearched+'"';
        Assert.assertEquals(expectedText,actualText);
    }
    public ProductDetailsPage clickOnFirstMonitor() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-cel-widget='search_result_2']//*[contains(text(),'Monitor')]")));

        FirstMonitor.click();
        String parent=driver.getWindowHandle();
        Set<String> windowHandles= driver.getWindowHandles();
        Iterator<String> I1 = windowHandles.iterator();
        while(I1.hasNext()){
            String child_window=I1.next();
            driver.switchTo().window(child_window);
        }
        String price_incurrency = productPrice.getText();
        String newPricce = price_incurrency.replaceAll("(?<=\\d),(?=\\d)","");

        System.out.println(newPricce);
        configReader = new ConfigReader();
        prop = configReader.init_prop();
        configReader.setProperty("Monitor",newPricce);
        return productDetailsPage = new ProductDetailsPage(driver);

    }

    public ProductDetailsPage clickOnSecondLaptop() throws IOException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");

        secondLaptop.click();
        String parent=driver.getWindowHandle();
        Set<String> windowHandles= driver.getWindowHandles();
        Iterator<String> I1 = windowHandles.iterator();
        while(I1.hasNext()){
            String child_window=I1.next();
            driver.switchTo().window(child_window);
        }
        String price_incurrency = productPrice.getText();
        String newPricce = price_incurrency.replaceAll("(?<=\\d),(?=\\d)","");

        System.out.println(newPricce);
        configReader = new ConfigReader();
        prop = configReader.init_prop();
        configReader.setProperty("Laptop",newPricce);
        return productDetailsPage = new ProductDetailsPage(driver);

    }
}
