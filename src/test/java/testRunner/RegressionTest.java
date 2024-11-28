package testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@regression", features = {"src/test/resources/features"}, glue = {"steps"},
        plugin = {})

public class RegressionTest extends AbstractTestNGCucumberTests {

}
