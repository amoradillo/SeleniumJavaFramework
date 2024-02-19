package ave4testing.tests;

import ave4testing.TestComponents.BaseTest;
import ave4testing.pageobjects.ProductCatalog;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class ErrorValidation extends BaseTest {

     @Test
     public void submitOrder() throws IOException, InterruptedException {
          String productName = "ZARA COAT 3";
          ProductCatalog productCatalog = landingPage.loginApplication("ave4testing@gmail.com","Iamki000");
          Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

     }


}


//public class SubmitOrderTest {
//    public static void main(String[] args) throws InterruptedException {
//         String productName = "ZARA COAT 3";
//         WebDriver driver = new ChromeDriver();
//         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//         driver.manage().window().maximize();
//         LandingPage landingPage = new LandingPage(driver);
//         landingPage.goTo();
//         ProductCatalog productCatalog = landingPage.loginApplication("ave4testing@gmail.com","Iamking@000");
//         List<WebElement> product = productCatalog.getProductList();
//         productCatalog.addProductToCart(productName);
//         CartPage cartPage = productCatalog.goToCartPage();
//
//         Boolean match = cartPage.VerifyProductDisplay(productName);
//         Assert.assertTrue(match);
//         CheckoutPage checkoutPage = cartPage.goToCheckout();
//         checkoutPage.SelectCountry("Philippines");
//         ConfirmationPage confirmationPage = checkoutPage.submitOrder();
//         String confirmMessage = confirmationPage.verifyConfirmationMessage();
//         Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//         driver.close();
//
//
//
//    }
//}
