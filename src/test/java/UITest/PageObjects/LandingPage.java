package UITest.PageObjects;

import UITest.Core.Driver.StepsStartHook;
import UITest.HelperLibrary.ExplicitWait;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.pmw.tinylog.Logger;

public class LandingPage {

    private ExplicitWait explicitWait;

    public LandingPage(StepsStartHook stepsStartHook){
        PageFactory.initElements(stepsStartHook.getDriver(), this);
        this.explicitWait = stepsStartHook.getExplicitWait();
    }

    @FindBy(how = How.XPATH, using = "//header/nav/div[@class='secondary-nav']/a[1]")
    private WebElement lnkLocale;

    @FindBy(how = How.XPATH, using = "//header/nav/div[@class='primary-nav']/button[1]")
    private WebElement lnkFlyers;

    @FindBy(how = How.CLASS_NAME, using = "postal-code")
    private WebElement tbPostalCodeSearch;


    @FindBy(how=How.XPATH, using="//article[@id='primary-content-flyers-article']//button[@class='flipp-button']")
    private WebElement browseFlyers;

    public void changeLocale(String currentLocale, String toLocale){
        if(currentLocale.equalsIgnoreCase(toLocale)){
            Logger.warn("Current locale and change to locale are same");
            return;
        }
        explicitWait.waitForElementVisible(lnkLocale).click();
    }

    public WebElement getLnkFlyers(){
        return lnkFlyers;
    }

    public WebElement getLnkLocale() { return lnkLocale; }

    public void clickBrowseFlyers(){
        explicitWait.waitForElementVisible(browseFlyers).click();
    }

}
