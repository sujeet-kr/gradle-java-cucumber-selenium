package UITest.Core.Driver;

import UITest.HelperLibrary.ExplicitWait;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

import UITest.HelperLibrary.DataFileReader;

public class StepsStartHook {

    public static boolean initialized = false;
    private WebDriver driver;
    private DataFileReader dataFile;
    private ExplicitWait explicitWait;

    @Before
    public void beforeScenario() throws Exception {
        if(!initialized){
            this.driver = new DriverFactory().createWebDriver();
            initialized = true;
            dataFile = new DataFileReader("test-config.yaml");
            explicitWait = new ExplicitWait(this.driver);
        }
    }

    @After
    public void afterScenario(){
        this.driver.close();
        this.driver.quit();
        this.driver = null;
    }

    public WebDriver getDriver(){
        return this.driver;
    }

    public DataFileReader getDataFileReader(){
        return this.dataFile;
    }

    public ExplicitWait getExplicitWait(){
        return this.explicitWait;
    }
}
