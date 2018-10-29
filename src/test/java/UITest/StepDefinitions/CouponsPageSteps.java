package UITest.StepDefinitions;

import UITest.PageObjects.CouponsPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class CouponsPageSteps {

    private CouponsPage couponsPage;

    public CouponsPageSteps(CouponsPage couponsPage){
        this.couponsPage = couponsPage;
    }

    @Then("^I navigate to the Coupons page$")
    public void iNavigateToTheCouponsPage() throws Throwable {
        assertThat(couponsPage.getCouponsContainer().isDisplayed()).isTrue();
    }
}
