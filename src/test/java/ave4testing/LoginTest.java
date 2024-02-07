package ave4testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ave4testing.pageobjects.LandingPage;

public class LoginTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goTo();
        landingPage.loginApplication("ave4testing@gmail.com","Iamking@000");




    }
}
