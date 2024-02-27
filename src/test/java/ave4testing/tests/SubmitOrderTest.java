package ave4testing.tests;

import ave4testing.TestComponents.BaseTest;
import ave4testing.pageobjects.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class SubmitOrderTest extends BaseTest
{


    String productName = "ZARA COAT 3";

    @Test(dataProvider="getData",groups= {"Purchase"})
    public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {

        ProductCatalog productCatalog = landingPage.loginApplication(input.get("email"), input.get("password"));
        List<WebElement> product = productCatalog.getProductList();
        productCatalog.addProductToCart(input.get("product"));
        CartPage cartPage = productCatalog.goToCartPage();

        Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.SelectCountry("Philippines");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
        String confirmMessage = confirmationPage.verifyConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        //orders


    }


    @Test(dependsOnMethods = {"submitOrder"})
    public void OrderHistoryTest() {
        ProductCatalog productCatalog = landingPage.loginApplication("ave4testing@gmail.com", "Iamking@000");
        OrderPage ordersPage = productCatalog.goToOrderPage();
        Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));

    }

    @DataProvider
    public Object [] [] getData() throws IOException {
        List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//ave4testing//data//PurchaseOrder.json");
        return new Object[][]  {{data.get(0)}, {data.get(1) },{data.get(2)} };

    }


    public String Screenshot (String testCaseName) throws IOException {
       TakesScreenshot ts = (TakesScreenshot)driver;
       File source = ts.getScreenshotAs(OutputType.FILE);
       File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
       FileUtils.copyFile(source,file);
       return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
    }


//    @DataProvider
//    public Object [] [] getData()
//    {
//        HashMap<String, String> map = new HashMap<String, String>();
//        map.put("email", "anshika@gmail.com");
//        map.put("password", "Iamking@000");
//        map.put("product", "ZARA COAT 3");
//
//        HashMap<String, String> map1 = new HashMap<String, String>();
//        map1.put("email", "shetty@gmail.com");
//        map1.put("password", "Iamking@000");
//        map1.put("product", "ADIDAS ORIGINAL");
//        return new Object[][]  {{map}, {map1} };
//
//    }



}


