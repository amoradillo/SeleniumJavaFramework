package ave4testing.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage
   {
       WebDriver driver;

       public LandingPage(WebDriver driver)
       {
            // initialization
             this.driver = driver;
             PageFactory.initElements(driver,this);
       }


       //WebElement userEmails = driver.findElement(By.id("userEmail"))
       //PageFactory - reduce the syntax of creating a new element
       @FindBy(id="userEmail")
       WebElement userEmail;

       @FindBy(id="userPassword")
       WebElement password;

       @FindBy(id="login")
       WebElement submit;
       @FindBy(css="[class*='flyInOut']")
       WebElement errorMessage;

   }
