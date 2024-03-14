package ave4testing.stepDefinitions;

import ave4testing.TestComponents.BaseTest;
import ave4testing.pageobjects.LandingPage;
import io.cucumber.java.en.Given;

import java.io.IOException;

public class StepDefinitionImpl extends BaseTest {

    public LandingPage landingPage;
    @Given("I landed on Ecommerce Page")
    public void I_landed_on_Ecommerce_Page() throws IOException {
        landingPage = launchApplication();
    }

}
