package util;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class Hooks {

    DriverFactory driverFactory = new DriverFactory();
    public static String browser;
    public static String port;

    @Before
    public void setUp() throws MalformedURLException {
        browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
        port = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("port");
        driverFactory.setDriver(browser,port);
    }

    @After
    public void quitBrowser() {
        DriverFactory.getDriver().quit();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "failed_login.png");
        }
    }



}
