package UITest.StepDefinitions;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "src/test/resources/UITest/Features" },
        plugin = {"io.qameta.allure.cucumber3jvm.AllureCucumber3Jvm", "pretty"},
        glue = {"UITest.StepDefinitions","UITest.Core"}
        )
public class CucumberRunnerOptions {
}
