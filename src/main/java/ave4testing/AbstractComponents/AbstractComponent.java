package ave4testing.AbstractComponents;

import ave4testing.pageobjects.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent
{

    private WebDriver driver;

    public AbstractComponent(WebDriver driver)
    {
        this.driver = driver;
    }

    public AbstractComponent initializeLoginPage()
    {
        return PageFactory.initElements(driver, AbstractComponent.class);
    }


//    public AbstractComponent(WebDriver driver)
//    {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//
//    }

    // Links Cart Header
    @FindBy(css = "[routerlink*='cart']" )
    WebElement cartHeader;


    public void waitForElementToAppear(By findBy)
    {
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
     // wait.until(ExpectedConditions.visibilityOfElementLocated(
     wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

    }

    public void waitForWebElementToAppear(WebElement findBy)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(
        wait.until(ExpectedConditions.visibilityOf(findBy));

    }

    public CartPage goToCartPage()
    {
//        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
          cartHeader.click();
          CartPage cartPage = new CartPage(driver);
          return cartPage;
    }




    public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
          Thread.sleep(1000);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//        wait.until(ExpectedConditions.invisibilityOf(ele));

    }
}
