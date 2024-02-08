package ave4testing;

import ave4testing.pageobjects.CartPage;
import ave4testing.pageobjects.LandingPage;
import ave4testing.pageobjects.ProductCatalog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class SubmitOrderTest {
    public static void main(String[] args) {
         String productName = "ZARA COAT 3";
         WebDriver driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         driver.manage().window().maximize();
         LandingPage landingPage = new LandingPage(driver);
         landingPage.goTo();
         ProductCatalog productCatalog = landingPage.loginApplication("ave4testing@gmail.com","Iamking@000");
         List<WebElement> product = productCatalog.getProductList();
         productCatalog.addProductToCart(productName);
         CartPage cartPage = productCatalog.goToCartPage();
         Boolean match = cartPage.VerifyProductDisplay(productName);
         Assert.assertTrue(match);


//         driver.findElement(By.cssSelector(".totalRow button")).click();
//
//         Actions a = new Actions(driver);
//         a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
//
//         wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//
//         driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
//         driver.findElement(By.cssSelector(".action__submit")).click();





    }
}
