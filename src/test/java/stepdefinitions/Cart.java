package stepdefinitions;

import com.qa.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class Cart  {
    WebDriver driver;
    DriverFactory driverFactory = new DriverFactory();
    @Given("I navigate to the {string}")
    public void iNavigateToThe(String url) {
        System.out.println("url");
      driver =  driverFactory.getDriver("chrome");
      driver.get("https://www.amazon.in/");
    }

    @When("I search for “Monitor”")
    public void iSearchForMonitor() {
    }

    @And("I open the First Monitor")
    public void iOpenTheFirstMonitor() {
    }

    @And("I add the First Monitor to the Shopping Cart")
    public void iAddTheFirstMonitorToTheShoppingCart() {
    }

    @And("I open my cart")
    public void iOpenMyCart() {
    }

    @Then("verify the price of the Product")
    public void verifyThePriceOfTheProduct() {
    }

    @And("the subtotal should be accurate")
    public void theSubtotalShouldBeAccurate() {
    }


}
