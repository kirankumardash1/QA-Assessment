package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
    public WebDriver driver;
    @FindBy(xpath = "(//*[@id='add-to-cart-button'])[1]")
    WebElement addToCart;
    @FindBy(xpath = "//*[contains(text(),' Go to Cart')]")
    WebElement openCart;
    public ProductDetailsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void addTocart(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        addToCart.click();
    }
    public ShoppingCartPage openCart(){
        openCart.click();
        return new ShoppingCartPage(driver);

    }
}
