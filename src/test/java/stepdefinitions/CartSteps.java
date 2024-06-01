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

    @Given("I navigate to the {string}")
    public void iNavigateToThe(String url) {
      DriverFactory.getDriver().get(url);
    }

    @When("I search for {string}")
    public void iSearchForMonitor(String item) {
       searchResultPage =homePage.searchItem(item);
    }

    @And("I open the First Monitor")
    public void iOpenTheFirstMonitor() throws IOException {
        productDetailsPage = searchResultPage.clickOnFirstMonitor();
    }

    @And("I add the First Monitor to the Shopping Cart")
    public void iAddTheFirstMonitorToTheShoppingCart() {
        productDetailsPage.addTocart();
    }

    @And("I open my cart")
    public void iOpenMyCart() {
        shoppingCartPage = productDetailsPage.openCart();
    }

    @Then("verify the price of the Product")
    public void verifyThePriceOfTheProduct() {
        shoppingCartPage.verifyProductPrice();
    }

    @And("the subtotal should be accurate")
    public void theSubtotalShouldBeAccurate() {
    }


}
