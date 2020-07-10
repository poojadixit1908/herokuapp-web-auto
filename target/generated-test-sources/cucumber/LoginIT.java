import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
features = {"/Users/poojasharma/Work/code/herokuapp-web-auto/src/test/resources/features/login.feature:3"},
plugin = {"json:target/cucumber-reports/1.json"},
monochrome = false,
glue = { "com.herokuapp" })
public class LoginIT {
}
