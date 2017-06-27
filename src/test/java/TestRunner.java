import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;


/**
 * Created by andreapolcz on 6/12/17.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "html:target/cucumber" },
        features = "resources",
        tags = {"@regression"}
)

public class TestRunner {

}
