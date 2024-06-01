package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver driver;
        @FindBy(xpath = "//*[@id='twotabsearchtextbox']")
         WebElement  searchTextBox ;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public SearchResultPage searchItem(String item){
        searchTextBox.click();
        searchTextBox.clear();
        searchTextBox.sendKeys(item);
        searchTextBox.submit();
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        return searchResultPage;
    }

}
