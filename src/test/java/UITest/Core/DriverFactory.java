package UITest.Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private WebDriver driver;
    private String browserName;
    private int waitTimeout;

    public DriverFactory(String browserName, String driverLocation, int waitTimeout){
        System.setProperty("webdriver.gecko.driver", driverLocation + "geckodriver");
        System.setProperty("webdriver.chrome.driver", driverLocation + "chromedriver");
        this.browserName = browserName;
        this.waitTimeout = waitTimeout;
    }

    public WebDriver createWebDriver() throws Exception {

        switch ( browserName.toUpperCase() ){
            case "CHROME":
                driver = new ChromeDriver();
                break;
            case "FIREFOX":
                driver = new FirefoxDriver();
                break;
            case "SAFARI":
                driver = new SafariDriver();
                break;
            case "IE":
                driver = new InternetExplorerDriver();
            default:
                throw new Exception();
        }

        driver.manage().timeouts().implicitlyWait(this.waitTimeout, TimeUnit.SECONDS);
        return driver;
    }
}
