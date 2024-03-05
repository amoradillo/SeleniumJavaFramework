package ave4testing.pageobjects;


import ave4testing.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponent {
    WebDriver driver;

    @FindBy(css = ".totalRow button")
    WebElement checkoutEle;

    @FindBy(css = ".cartSection h3")
    private List<WebElement> cartProducts;



    public CartPage(WebDriver driver) {
        super(driver);
        // initialization
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public Boolean VerifyProductDisplay(String productName) {
        Boolean match = cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
        return match;

    }

    public CheckoutPage goToCheckout() {
        waitForWebElementToAppear(checkoutEle);

        checkoutEle.click();
        return new CheckoutPage(driver);


    }






}


