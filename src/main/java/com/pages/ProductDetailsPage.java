package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
    public WebDriver driver;
    @FindBy(xpath = "//*[@id='add-to-cart-button']")
    WebElement addToCart;
    @FindBy(xpath = "//*[contains(text(),' Go to Cart')]")
    WebElement openCart;
    public ProductDetailsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void addTocart(){
        addToCart.click();
    }
    public ShoppingCartPage openCart(){
        openCart.click();
        return new ShoppingCartPage(driver);

    }
}
