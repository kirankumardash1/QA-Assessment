package stepdefinitions;

import com.pages.HomePage;
import com.pages.ProductDetailsPage;
import com.pages.SearchResultPage;
import com.pages.ShoppingCartPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class CartSteps {

    HomePage homePage = new HomePage(DriverFactory.getDriver());
    SearchResultPage searchResultPage;
    ProductDetailsPage productDetailsPage;
    ShoppingCartPage shoppingCartPage;
    String searchItem;

    @Given("I navigate to the {string}")
    public void iNavigateToThe(String url) {
      DriverFactory.getDriver().get(url);
    }

    @When("I search for {string}")
    public void iSearchForMonitor(String item) {
        searchItem=item;
       searchResultPage =homePage.searchItem(item);

    }

    @And("I open the First Monitor")
    public void iOpenTheFirstMonitor() throws IOException {
        searchResultPage.validateResultPage(searchItem);
        productDetailsPage = searchResultPage.clickOnFirstMonitor();
    }

    @And("I add the product to the Shopping Cart")
    public void iAddTheFirstMonitorToTheShoppingCart() {
        productDetailsPage.addTocart();
    }

    @And("I open my cart")
    public void iOpenMyCart() {
        shoppingCartPage = productDetailsPage.openCart();
    }


    @And("I open the second Laptop")
    public void iOpenTheSecondLaptop() throws IOException {
        searchResultPage.validateResultPage(searchItem);
        productDetailsPage = searchResultPage.clickOnSecondLaptop();
    }

    @And("the {string} subtotal should be accurate")
    public void theSubtotalShouldBeAccurate(String productName) {
        shoppingCartPage.verifySubTotalPrice(productName);
    }

    @Then("verify the {string} price of the Product")
    public void verifyThePriceOfTheProduct(String productName) {
        shoppingCartPage.verifyProductPrice(productName);
    }
}
