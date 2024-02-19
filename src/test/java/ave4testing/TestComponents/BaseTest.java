package ave4testing.TestComponents;

import ave4testing.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public WebDriver initializeDriver() throws IOException {
       //properties class

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src//main//java//ave4testing//resources//GlobalData.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome"))
        {
            this.driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox"))
        {
           this.driver  = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge"))
        {
            this.driver  = new EdgeDriver();
        }


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;

    }

//    public void launchApplication()
//    {
//        initializeDriver()
//    }

    public LandingPage launchApplication() throws IOException
    {
         driver = initializeDriver();
         LandingPage landingPage = new LandingPage(driver);
         landingPage.goTo();
         return landingPage;
    }

    public void tearDown()
    {
        driver.close();
    }



}
