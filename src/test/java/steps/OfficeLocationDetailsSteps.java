package steps;

import common.WebDriverConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.OfficeLocationDetailsPage;

import java.io.IOException;

import static org.testng.Assert.assertTrue;


public class OfficeLocationDetailsSteps {

    public OfficeLocationDetailsPage locDetails;
    private WebDriver driver;

    @Before
    public void setUp() throws IOException {
        WebDriverConfig config = new WebDriverConfig();
        driver = config.initializeWebDriver();

        this.locDetails = new OfficeLocationDetailsPage(driver);

        locDetails.navigateTo("https://datacom.com/nz/en/contact-us");
        locDetails.acceptAllCookies();
    }

    @Given("I am navigated to {string} page")
    public void iAmNavigatedToThePage(String pageName) {
        locDetails.verifyPage(pageName);
    }

    @When("I click on the location {string}")
    public void iClickOnTheLocation(String locationName) throws InterruptedException {
        locDetails.clickLocation(locationName);


    }

    @Then("I see the details: address {string}, phone number {string} and email {string} for location {string}")
    public void iSeeTheDetailsAddressPhoneNumberEmail(String address, String phone, String email, String location) throws InterruptedException {
        //locDetails.verifyOfficeLocationName(officeLocation);
        locDetails.verifyAddress(address, location);
        locDetails.verifyPhoneNumber(phone, location);
        locDetails.verifyEmail(email, location);

    }
    @Given("I am in {string} location tab of {string} page")
    public void iAmInLocationTabOfPage(String location, String officeLocation) {
        locDetails.verifyPage(location);
        locDetails.verifyPage(officeLocation);
    }

    @When("I select an office location {string}")
    public void iSelectAnOfficeLocation(String officeLocation) throws InterruptedException {
        locDetails.selectOfficeLocation(officeLocation);
    }

    @When("I click on the Get Directions link")
    public void iClickOnTheGetDirectionsLink(){
        locDetails.clickGetDirectionsLink();
    }
    @When("I click on the Phone Number link")
    public void iClickOnThePhoneNumberLink(){
       // locDetails.clickPhoneNumberLink();
    }

    @When("I click on the Email link")
    public void iClickOnTheEmailLink(){
       // locDetails.clickEmailLink();
    }

/*    @Then("I am navigated to Google Maps")
    public void iAmNavigatedToGoogleMaps() {
        assertTrue((locDetails.verifyNavigatedPage()).contains("googlemaps"));

    }*/

    @After
    public void tearDown(){
        locDetails.closeBrowser();
    }


}
