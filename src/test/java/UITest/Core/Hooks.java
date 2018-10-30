package UITest.Core;

import UITest.HelperLibrary.ExplicitWait;
import com.fasterxml.jackson.databind.JsonNode;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

import UITest.HelperLibrary.DataFileReader;

public class Hooks {

    private WebDriver driver;
    private JsonNode configFile;
    private JsonNode dataFile;
    private ExplicitWait explicitWait;
    private String env;
    private String browser;
    private String driverLocation;
    private int waitTimeout;

    @Before
    public void beforeScenario() throws Exception {
        this.browser = System.getProperty("browser");
        this.env = System.getProperty("env");

        this.configFile = new DataFileReader("test-config.yaml").getEnvironmentData();
        this.dataFile = new DataFileReader(this.configFile.get(this.env + "-data-file").asText()).getData();

        this.waitTimeout = configFile.get("explicit-wait-timeout").asInt();
        this.driverLocation = dataFile.get("driver-location").asText();

        this.driver = new DriverFactory(browser, driverLocation, waitTimeout).createWebDriver();
        this.explicitWait = new ExplicitWait(this.driver, waitTimeout);
    }

    @After
    public void afterScenario(){
        this.driver.close();
    }

    public WebDriver getDriver(){
        return this.driver;
    }

    public JsonNode getConfigFile(){
        return this.configFile;
    }

    public JsonNode getDataFile() { return this.dataFile; }

    public ExplicitWait getExplicitWait(){
        return this.explicitWait;
    }

    public String getEnvironment(){
        return this.env;
    }

    public String getBrowser() { return this.browser; }
}
