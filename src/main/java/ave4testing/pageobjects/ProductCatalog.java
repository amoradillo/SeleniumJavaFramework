package ave4testing.pageobjects;


import ave4testing.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog extends AbstractComponent {
    WebDriver driver;

    public ProductCatalog(WebDriver driver) {
        super(driver);
        // initialization
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    // List<WebElemet> products = driver.findElements(By.cssSelector(".mb-3"));
    @FindBy(css = "mb-3")
    ArrayList<WebElement> products;

    By productsBy = By.cssSelector(".mb-3");
    By addToCart = By.cssSelector(".card-body button:last-of-type");


    public ArrayList<WebElement> getProductList()
    {
        waitForElementToAppear(productsBy);
        return products;
    }

    public WebElement getProductByName(String productName)
    {
        WebElement prod = getProductList().stream().filter(product->
                product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        return prod;
    }

    public void addProductToCard(String productName)
    {
         WebElement prod = getProductByName(productName);
         prod.findElement(addToCart).click();
    }

}


