import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@SmokeTest",
        features = {"classpath:features"},
        glue = {"gradle.cucumber"})
public class RunSmokeTests {
}