package UITest.HelperLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ExplicitWait {
    private WebDriver driver;
    private int explicitWaitTimeout;

    public ExplicitWait(WebDriver driver, int explicitWaitTimeout){
        this.driver = driver;
        this.explicitWaitTimeout = explicitWaitTimeout;
    }

    private WebDriverWait expWait;

    public WebElement waitForElementVisible(WebElement element){
        expWait = new WebDriverWait(driver, explicitWaitTimeout);
        return expWait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebDriverWait getExpWait(){
        return this.expWait;
    }

}
