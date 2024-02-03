package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"stepDefinitions","util"},
        tags = "@SearchPage or @LoginPage",
        plugin = {
                "pretty",
                "summary",
                "html:Reports/CucumberReport/Reports.html",
                "json:Reports/CucumberReport/Report",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = false
)
public class parallelRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}


