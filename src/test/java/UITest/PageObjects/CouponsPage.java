package UITest.PageObjects;

import UITest.Core.Driver.StepsStartHook;
import UITest.HelperLibrary.ExplicitWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CouponsPage {

    private ExplicitWait explicitWait;

    public CouponsPage(StepsStartHook stepsStartHook){
        PageFactory.initElements(stepsStartHook.getDriver(), this);
        this.explicitWait = stepsStartHook.getExplicitWait();
    }

    @FindBy(how = How.XPATH, using = "//div[@class='coupons']//div[@class='coupon-container peek']")
    private WebElement couponsContainer;

    public WebElement getCouponsContainer(){
        return this.couponsContainer;
    }

}
