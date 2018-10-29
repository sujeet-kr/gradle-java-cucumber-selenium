package UITest.StepDefinitions;

import UITest.Core.Driver.StepsStartHook;
import UITest.PageObjects.FlyersPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class FlyersPageSteps {

    private FlyersPage flyersPage;

    public FlyersPageSteps(FlyersPage flyersPage){
        this.flyersPage = flyersPage;
    }

    @Then("^I navigate to the Flyers page$")
    public void iNavigateToTheFlyersPage() throws Throwable {
        assertThat(flyersPage.getCouponsLink().isDisplayed()).isTrue();
    }

    @When("^I click the Coupons link on the left pane$")
    public void iClickTheCouponsLinkOnTheLeftPane() throws Throwable {
        flyersPage.clickCoupons();
    }
}
