package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {

    static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static synchronized WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public WebDriver setDriver(String browser, String port) throws MalformedURLException {
        switch (browser){
            case "Chrome" :
                WebDriverManager.chromedriver().clearDriverCache();
                WebDriverManager.chromedriver().clearResolutionCache();
                WebDriverManager.chromedriver().setup();
                driverThreadLocal.set(new ChromeDriver());
                break;
            case "Firefox" :
                WebDriverManager.firefoxdriver().clearDriverCache();
                WebDriverManager.firefoxdriver().clearResolutionCache();
                WebDriverManager.firefoxdriver().setup();
                driverThreadLocal.set(new FirefoxDriver());
                break;
            case "Edge" :
                WebDriverManager.edgedriver().clearDriverCache();
                WebDriverManager.edgedriver().clearResolutionCache();
                WebDriverManager.edgedriver().setup();
                driverThreadLocal.set(new EdgeDriver());
                break;
            case "Chrome-Grid" :
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                driverThreadLocal.set(new RemoteWebDriver(new URL(port),options));
                break;
            case "Firefox-Grid" :
                FirefoxOptions options2 = new FirefoxOptions();
                options2.addArguments("start-maximized");
                driverThreadLocal.set(new RemoteWebDriver(new URL(port),options2));
                break;
            case "Edge-Grid" :
                EdgeOptions options3 = new EdgeOptions();
                options3.addArguments("start-maximized");
                driverThreadLocal.set(new RemoteWebDriver(new URL(port),options3));
                break;

        }
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

}
