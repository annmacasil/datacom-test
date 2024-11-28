package testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@smoke", features = {"src/test/resources/features"}, glue = {"steps"},
        plugin = {})

public class SmokeTest extends AbstractTestNGCucumberTests {

}
