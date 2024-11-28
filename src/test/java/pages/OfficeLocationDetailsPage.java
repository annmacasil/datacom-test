package pages;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class OfficeLocationDetailsPage extends BasePage {
    private final By pageHeaderLocator = By.xpath("//div[2]//h2[@class='cmp-title__text ']");
    private final By acceptButton = By.id("onetrust-accept-btn-handler");
    private final By locationLocator = By.xpath("//div[1]/div[1]/ul/li");
    private final By officeLocationLocator = By.cssSelector(".cmp-location__location__name.open");
    private final By getDirectionsLocator = By.xpath("");

    private static final Logger log = LoggerFactory.getLogger(OfficeLocationDetailsPage.class);

    public OfficeLocationDetailsPage(WebDriver driver) {
        super(driver);
    }


    // cmp-location__location__name open  <div class="cmp...."> <open></open> </div>


    public void verifyPage(String pageName) {
        assertEquals(getText(pageHeaderLocator),pageName );
    }
    public void clickLocation(String locationName){
        By locator = getLocatorByName(locationLocator,locationName);
        log.info("Location office.." + locator);
        //scrollDownTo(locator);
        waitForVisibility(locator);
        click(locator);
    }

    public void acceptAllCookies(){
        waitForVisibility(acceptButton);
        clickAccept(acceptButton);
    }

    public void waitForVisible(String region){
        String identifier = String.format("div[region='%s']", region);
        waitForVisibility(By.cssSelector(identifier));

    }



    public void verifyOfficeLocationName(String officeLocation) throws InterruptedException {
        String expected = getText(officeLocationLocator);
        log.info("Expected value .." +expected);
        assertEquals(expected, officeLocation);
        log.info("Actual Location " + getText(officeLocationLocator) + " vs Expected Location " + officeLocation);
    }

    public void verifyAddress(String address, String region) {
        String identifier = String.format("div[region='%s'] .cmp-location__location__address", region);
        assertEquals(getText(By.cssSelector(identifier)), address);
    }

    public void verifyPhoneNumber(String phone, String region) {
        String identifier = String.format("div[region='%s'] .cmp-location__location__phone a", region);
        assertEquals(getText(By.cssSelector(identifier)), phone);
    }

    public void verifyEmail(String email, String region) {
        String identifier = String.format("div[region='%s'] .cmp-location__location__email a", region);
        assertEquals(getText(By.cssSelector(identifier)), email);
    }

    public void selectOfficeLocation(String officeLocation) throws InterruptedException {
        By loc = getLocatorByName(officeLocationLocator,officeLocation);
        log.info("Office location selected is.." +loc);
    }

    public void clickGetDirectionsLink(){
        click(getDirectionsLocator);
    }

    public void verifyNavigatedPage(){
        getCurrentURL();

    }

}
