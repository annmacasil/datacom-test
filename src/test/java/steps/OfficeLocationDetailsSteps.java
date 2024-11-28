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
    public void iClickOnTheLocation(String locationName)  {
        locDetails.clickLocation(locationName);

    }

    @Then("I see the following details for {string} office in {string} : address {string}, phone number {string} and email {string}")
    public void iSeeTheDetailsAddressPhoneNumberEmail(String officeLocation, String location, String address, String phone, String email) {
        locDetails.verifyAddress(address, location);
        locDetails.verifyPhoneNumber(phone, location);
        locDetails.verifyEmail(email, location);
    }
    @Given("I am in {string} location tab of {string} page")
    public void iAmInLocationTabOfPage(String location, String officeLocation) {
        locDetails.clickLocation(location);
    }

    @When("I select an office location {string}")
    public void iSelectAnOfficeLocation(String officeLocation) {
        locDetails.selectOfficeLocation(officeLocation);
    }

    @When("I click on the Get Directions link for {string} office")
    public void iClickOnTheGetDirectionsLink(String officeLocation){
        locDetails.clickGetDirectionsLink(officeLocation);
    }
    @When("I click on the Phone Number link in {string} office")
    public void iClickOnThePhoneNumberLink(String officeLocation){
        locDetails.clickPhoneNumberLink(officeLocation);
    }

    @When("I click on the Email link in {string} office")
    public void iClickOnTheEmailLink(String officeLocation){
       locDetails.clickEmailLink(officeLocation);
    }

    @Then("I am navigated to Google Maps")
    public void iAmNavigatedToGoogleMaps() {
        locDetails.verifyGetDirectionsLink();

    }
    @Then("I verify the phone link is correct in {string} location")
    public void iSeeAnAlertPopUpToPickAnAppForCall(String officeLocation) {
        locDetails.verifyPhoneLink(officeLocation);

    }

    @Then("I verify the mailto link is correct in {string} location")
    public void iVerifyMailToIsCorrectl(String officeLocation) {
        locDetails.verifyMailToLink(officeLocation);

    }

    @After
    public void tearDown(){
        locDetails.closeBrowser();
    }


}
