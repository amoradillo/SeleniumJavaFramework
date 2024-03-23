package ave4testing.stepDefinitions;

import ave4testing.TestComponents.BaseTest;
import ave4testing.pageobjects.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class StepDefinitionImpl extends BaseTest {

    public LandingPage landingPage;
    public ProductCatalog productCatalog;
    public ConfirmationPage confirmationPage;

    @Given("I landed on Ecommerce Page")
    public void I_landed_on_Ecommerce_Page() throws IOException
    {
        landingPage = launchApplication();
        //code
    }


    @Given("^Logged in with username (.+) and password (.+)$")
    public void logged_in_username_and_password(String username, String password)
    {
        productCatalog = landingPage.loginApplication(username,password);
    }


    @When("^I add product (.+) to Cart$")
    public void i_add_product_to_cart(String productName) throws InterruptedException
    {
        List<WebElement> products = productCatalog.getProductList();
        productCatalog.addProductToCart(productName);
    }

    @When("^Checkout (.+) and submit the order$")
    public void checkout_submit_order(String productName)
    {
        CartPage cartPage = productCatalog.goToCartPage();

        Boolean match = cartPage.VerifyProductDisplay(productName);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.SelectCountry("Philippines");
        confirmationPage = checkoutPage.submitOrder();
    }


    @Then("{string} message is displayed on ConfirmationPage")
    public void message_displayed_confirmationPage(String string)
    {
        String confirmMessage = confirmationPage.verifyConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
        driver.quit();
    }


//    @Then("{string} message is displayed")
//    public void messageIsDisplayed(String string) throws IOException
//    {
//        Assert.assertEquals(string, landingPage.getErrorMessage());
//        driver.quit();
//    }

    @Then("{string} message is displayed")
    public void message_is_displayed(String string) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(string, landingPage.getErrorMessage());
        driver.quit();
    }
}
