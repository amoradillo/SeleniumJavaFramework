package ave4testing;

import ave4testing.pageobjects.LandingPage;
import ave4testing.pageobjects.ProductCatalog;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class SubmitOrderTest {
    public static void main(String[] args) {
         String productName = "ZARA COAT 3";
         WebDriver driver = new ChromeDriver();
         LandingPage landingPage = new LandingPage(driver);
         landingPage.goTo();
         landingPage.loginApplication("ave4testing@gmail.com","Iamking@000");
         ProductCatalog productCatalog = new ProductCatalog(driver);
         ArrayList<WebElement> product = productCatalog.getProductList();
         productCatalog.addProductToCard(productName);




    }
}
