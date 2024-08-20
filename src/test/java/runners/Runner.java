package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-reports.html"}, //Cucumber reports
        features = "src/test/resources/features", //Cucumber - Steps linked
        glue = "stepdefinitions", // Steps path
        tags = "@TC_032",
        dryRun = false
)


public class Runner {

}
