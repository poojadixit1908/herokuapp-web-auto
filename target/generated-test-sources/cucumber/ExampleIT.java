import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
features = {"/Users/poojasharma/Work/code/herokuapp-web-auto/src/test/resources/features/example.feature:8"},
plugin = {"json:target/cucumber-reports/2.json"},
monochrome = false,
glue = { "com.herokuapp" })
public class ExampleIT {
}
