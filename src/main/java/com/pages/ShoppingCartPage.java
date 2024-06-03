package com.pages;

import com.qa.util.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.math.BigDecimal;
import java.util.Properties;

public class ShoppingCartPage {
    private ConfigReader configReader;
    Properties prop;
    String  final_ActualPrice;

    WebDriver driver;
    @FindBy (xpath = "//*[@class='sc-badge-price-to-pay']")
    WebElement productPrice ;

    @FindBy (xpath = "//*[@id='sc-subtotal-amount-activecart']")
    WebElement subTotalPrice;

    public ShoppingCartPage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }
    public void verifyProductPrice(String productName){
        String temp_actualPrice = productPrice.getText();
        final_ActualPrice =String.valueOf(new BigDecimal(temp_actualPrice.trim().replaceAll("(?<=\\d),(?=\\d)","")).intValue()) ;
        configReader = new ConfigReader();
        prop = configReader.init_prop();
        String  expectedPrice = prop.getProperty(productName);
        Assert.assertEquals(expectedPrice,final_ActualPrice);

    }
    public void verifySubTotalPrice(String productName){
        String temp_actualPrice = subTotalPrice.getText();
        final_ActualPrice =String.valueOf(new BigDecimal(temp_actualPrice.trim().replaceAll("(?<=\\d),(?=\\d)","")).intValue()) ;
        String  expectedPrice = prop.getProperty(productName);
        Assert.assertEquals(expectedPrice,final_ActualPrice);
        System.out.println("inside subtotoal"+expectedPrice);
        System.out.println("inside subtotoal"+final_ActualPrice);

    }
}
