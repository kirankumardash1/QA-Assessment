package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features",
        glue = {"stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-pretty.html",
                "json:target/cucumber-reports/cucumber-report.json",
                "rerun:target/cucumber-reports/rerun.txt",
                })

public class TestRunner extends AbstractTestNGCucumberTests {

}

