package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumber.html"},
        glue={"cucumberdata"},
        features = "src/test/resources/cucumberdata"
)
public class JUnitRunnerTest {


}
