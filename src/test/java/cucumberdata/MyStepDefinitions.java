package cucumberdata;
import cucumberdata.factory.DriverFactory;
import cucumberdata.pages.CartPage;
import cucumberdata.pages.CheckoutPage;
import cucumberdata.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.Map;

public class MyStepDefinitions {
    private  WebDriver driver;

    @Given("I'm on the Store Page")
    public void i_m_on_the_store_page() {
        driver= DriverFactory.getDriver();
        new StorePage(driver).load("https://askomdch.com/store/");
    }

    @When("I add a {string} to the cart")
    public void i_add_a_to_the_cart(String productName) throws InterruptedException {
        new StorePage(driver).addToCart(productName);
    }

    @Then("I should see {int} {string} in the Cart")
    public void i_should_see_in_the_cart(int quantity, String productName) {
        CartPage cartPage=new CartPage(driver);
        Assert.assertEquals(productName,cartPage.getProductName());
        Assert.assertEquals(quantity,cartPage.getProductQuantity());
        driver.close();
    }

    @Given("I am guest customer")
    public void iAmGuestCustomer() {
        driver= DriverFactory.getDriver();
        new StorePage(driver).load("https://askomdch.com/store/");
    }

    @And("I have product in the cart")
    public void iHaveProductInTheCart() throws InterruptedException {
    new StorePage(driver).addToCart("Blue Shoes");
    }

    @And("I'm on the checkout page")
    public void iMOnTheCheckoutPage() {

        new CartPage(driver).checkout();
    }

    @When("I am providing the billing details")
    public void iAmProvidingTheBillingDetails(List<Map<String,String>> billingDetails) throws InterruptedException {
        CheckoutPage checkoutPage=new CheckoutPage(driver);
        System.out.println(billingDetails.get(0).get("email"));
        checkoutPage.setBillingDetails(
                billingDetails.get(0).get("firstname"),
                billingDetails.get(0).get("lastname"),
                billingDetails.get(0).get("address_line1"),
                billingDetails.get(0).get("city"),
                billingDetails.get(0).get("state"),
                billingDetails.get(0).get("zip"),
                billingDetails.get(0).get("email"));

    }

    @And("I place an order")
    public void iPlaceAnOrder() {
      new CheckoutPage(driver).placeOrder();
    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        Assert.assertEquals("Thank you. Your order has been received.",new CheckoutPage(driver).getNotice());
    }
}
