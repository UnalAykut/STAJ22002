package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"stepDefinitions", "util"},
        tags = "",
        plugin = {"summary", "pretty", "html:Reports/CucumberReport/Reports.html"}
)
public class Runner extends AbstractTestNGCucumberTests {
    // Static driver initialization removed as it's handled in Hooks class
}