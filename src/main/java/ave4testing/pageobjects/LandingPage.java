package ave4testing.pageobjects;


import ave4testing.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent
   {
       private WebDriver driver;

       public LandingPage(WebDriver driver)
       {
             super(driver);
              // initialization
             this.driver = driver;
             PageFactory.initElements(driver,this);
       }


       //WebElement userEmails = driver.findElement(By.id("userEmail"))
       //PageFactory - reduce the syntax of creating a new element
       @FindBy(id="userEmail")
       WebElement userEmail;

       @FindBy(id="userPassword")
       WebElement passwordEle;

       @FindBy(id="login")
       WebElement submit;


       public ProductCatalog loginApplication(String email, String password)
       {
           userEmail.sendKeys(email);
           passwordEle.sendKeys(password);
           submit.click();
           ProductCatalog productCatalog = new ProductCatalog(driver);
           return productCatalog;
       }


       public void goTo()
       {

           driver.get("https://rahulshettyacademy.com/client");
       }

   }
