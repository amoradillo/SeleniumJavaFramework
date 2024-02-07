package ave4testing;

import ave4testing.pageobjects.LandingPage;
import ave4testing.pageobjects.ProductCatalog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SubmitOrderTest {
    public static void main(String[] args) {
         String productName = "ZARA COAT 3";
         WebDriver driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         driver.manage().window().maximize();
         LandingPage landingPage = new LandingPage(driver);
         landingPage.goTo();
         landingPage.loginApplication("ave4testing@gmail.com","Iamking@000");
         ProductCatalog productCatalog = new ProductCatalog(driver);
         List<WebElement> product = productCatalog.getProductList();
         productCatalog.addProductToCart(productName);
//         driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
//         List <WebElement> cardProducts = driver.findElements(By.cssSelector(".cartSection h3"));
//         Boolean match = cardProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase())





    }
}
