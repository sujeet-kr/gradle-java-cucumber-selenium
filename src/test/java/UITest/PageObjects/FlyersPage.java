package UITest.PageObjects;

import UITest.Core.Driver.StepsStartHook;
import UITest.HelperLibrary.ExplicitWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FlyersPage {

    private ExplicitWait explicitWait;

    public FlyersPage(StepsStartHook stepsStartHook){
        PageFactory.initElements(stepsStartHook.getDriver(), this);
        this.explicitWait = stepsStartHook.getExplicitWait();
    }

    @FindBy(how = How.ID, using ="coupons-link")
    private WebElement couponsLink;

    public WebElement getCouponsLink(){
        return this.couponsLink;
    }

    public void clickCoupons(){
        explicitWait.waitForElementVisible(couponsLink).click();
    }

}
