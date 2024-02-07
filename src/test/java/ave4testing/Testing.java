package ave4testing;

import ave4testing.pageobjects.LandingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class Testing {
    public static void main(String[] args) {

        String MyProduct = "ZARA COAT 3";
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goTo();
        landingPage.loginApplication("ave4testing@gmail.com","Iamking@000");
        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

        WebElement prod = products.stream()
                .filter(product -> {
                    try {
                        return product.findElement(By.cssSelector("b")).getText().equals(MyProduct);
                    } catch (NoSuchElementException e) {
                        return false; // Return false if <b> tag is not found
                    }
                })
                .findFirst()
                .orElse(null);

        if (prod != null) {
            System.out.println(prod);
        } else {
            System.out.println("Product not found: " + MyProduct);
        }


    }
}
