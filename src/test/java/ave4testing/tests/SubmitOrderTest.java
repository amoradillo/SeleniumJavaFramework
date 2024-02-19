package ave4testing.tests;

import ave4testing.TestComponents.BaseTest;
import ave4testing.pageobjects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.IOException;
import java.time.Duration;
import java.util.List;


public class SubmitOrderTest extends BaseTest {

     @Test
     public void submitOrder() throws IOException, InterruptedException {
          String productName = "ZARA COAT 3";
          LandingPage landingPage = launchApplication();
          ProductCatalog productCatalog = landingPage.loginApplication("ave4testing@gmail.com","Iamking@000");
          List<WebElement> product = productCatalog.getProductList();
          productCatalog.addProductToCart(productName);
          CartPage cartPage = productCatalog.goToCartPage();

          Boolean match = cartPage.VerifyProductDisplay(productName);
          Assert.assertTrue(match);
          CheckoutPage checkoutPage = cartPage.goToCheckout();
          checkoutPage.SelectCountry("Philippines");,
          ConfirmationPage confirmationPage = checkoutPage.submitOrder();
          String confirmMessage = confirmationPage.verifyConfirmationMessage();
          Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
          tearDown();

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
