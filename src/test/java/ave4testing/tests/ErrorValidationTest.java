package ave4testing.tests;

import ave4testing.TestComponents.BaseTest;
import ave4testing.TestComponents.Retry;
import ave4testing.pageobjects.CartPage;
import ave4testing.pageobjects.ProductCatalog;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;


public class ErrorValidationTest extends BaseTest {

     @Test(groups = {"ErrorHandling"},retryAnalyzer= Retry.class)
     public void LoginErrorValidation() throws IOException, InterruptedException
     {

          landingPage.loginApplication("ave4testing@gmail.com", "Iamki000");
          Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

     }

     @Test
     public void ProductErrorValidation() throws InterruptedException
     {
          String productName = "ZARA COAT 3";
          ProductCatalog productCatalog = landingPage.loginApplication("ave4testing@gmail.com","Iamking@000");
          List<WebElement> product = productCatalog.getProductList();
          productCatalog.addProductToCart(productName);
          CartPage cartPage = productCatalog.goToCartPage();
          Boolean match = cartPage.VerifyProductDisplay("Zara Coat 33");
          Assert.assertFalse(match);

     }




}





//}
