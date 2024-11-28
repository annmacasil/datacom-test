package common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class BasePage {

    public WebDriver driver;

    private long DEFAULT_TIMEOUT = 10;
    private static final Logger log = LoggerFactory.getLogger(BasePage.class);

    // Constructor to initialize the driver
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(String url) throws IOException {
        // driver = initializeWebDriver();
        driver.get(url);

    }
    public void click(By locator, String value){
        WebElement e = driver.findElement(getLocatorByName(locator, value));
        e.click();
        log.info("Element is clicked.." + locator);
    }

    public void click(By locator){
        WebElement e = driver.findElement(locator);
        log.info("Clicking" + e);
        e.click();
        log.info("Element is clicked..");
    }

    public void clickAccept(By locator){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(locator));
            acceptButton.click();
            log.info("Cookies popup accepted!");
        } catch (Exception e) {
            log.info("An error occurred: " + e.getMessage());
        }
    }

    public void enterText(By locator, String text){
        WebElement e = driver.findElement(locator);
        e.sendKeys(text);
        log.info("Entered.." + text + " to the field.");
    }

    public void selectFromDropdownByText(By locator, String option){
        WebElement e = driver.findElement(locator);
        Select dropdown = new Select(e);
        dropdown.selectByVisibleText(option);
        log.info("Dropdown option is selected: " + option);
    }
    public void isDisplayed(By locator) throws Exception{
        WebElement e = driver.findElement(locator);
        e.isDisplayed();
        log.info("Element is displayed..");

    }
    public void isEnabled(By locator) throws Exception{
        WebElement e = driver.findElement(locator);
        e.isEnabled();
        log.info("Element is enabled..");

    }
    public String getText(By locator) {
        WebElement e = driver.findElement(locator);
        waitForVisibility(locator);
        String text = e.getText().toString();
        return text;
    }

    public void scrollDownTo(By locator) {
        WebElement e = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", e);
    }


    public List<String> getElementList(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        List<String> values = new ArrayList<>();

        for (WebElement e : elements)
            values.add(e.getText());

        return values;

    }
    public void waitForVisibility(By locator){
        waitForElement(locator,DEFAULT_TIMEOUT);
    }

    public void waitVisible(By locator){
        waitForElement(locator,DEFAULT_TIMEOUT);
    }

    public void waitForElement(By locator, long timeInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public By getLocatorByName(By locator, String value){
            String xpathString = locator.toString().replace("By.xpath: ", "");
            return By.xpath(String.format(xpathString + "[contains(text(),'%s')]",value));

    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();

    }

    public void closeBrowser() {
        driver.quit();
    }

}
