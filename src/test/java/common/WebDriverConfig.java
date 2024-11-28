package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class WebDriverConfig {

    public static final Logger log = LoggerFactory.getLogger(WebDriverConfig.class);
    public WebDriver driver;

    public Properties property;



    public WebDriver initializeWebDriver() throws IOException {
        property = loadFileConfig();
        String browser = property.getProperty("browser");

        switch(browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                try {

                } catch (Exception e) {
                    String errorMessage = String.format("The browser name '%s' is not recognized", browser);
                    throw new WebDriverManagerException(errorMessage, e);
                }
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        log.info("Initializing browser" + browser );

        return driver;

    }

    public Properties loadFileConfig() throws IOException {
        Properties property = new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
        property.load(file);
        return property;

    }


}
