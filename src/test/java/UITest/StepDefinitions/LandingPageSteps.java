package UITest.StepDefinitions;

import UITest.Core.Hooks;
import UITest.PageObjects.LandingPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class LandingPageSteps {
    private LandingPage landingPage;
    private Hooks hooks;

    public LandingPageSteps (LandingPage landingPage, Hooks hooks){
        this.landingPage = landingPage;
        this.hooks = hooks;
    }

    @When("^I change the locale from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void iChangeTheLocaleFromTo(String fromLocale, String toLocale) throws Throwable {
        landingPage.changeLocale(fromLocale, toLocale);
//        assertThat(landingPage.getLnkFlyers().getText()).isEqualToIgnoringCase("Circulaires");
    }

    @Given("^I have navigated to the landing page of Flipp in \"([^\"]*)\" locale with \"([^\"]*)\" in primary navigation$")
    public void iHaveNavigatedToTheLandingPageOfFlippInLocaleWithInPrimaryNavigation(String locale, String assertionText) throws Throwable {
        if (locale.equalsIgnoreCase("en-ca")){
            hooks.getDriver().get(hooks.getDataFile().get("url-en-ca").asText());
        } else {
            hooks.getDriver().get(hooks.getDataFile().get("url-fr-ca").asText());
        }
        assertThat(landingPage.getLnkFlyers().getText()).isEqualToIgnoringCase(assertionText);
    }

    @When("^I click on the Browse Flyers button$")
    public void iClickOnTheBrowseFlyersButton() throws Throwable {
        landingPage.clickBrowseFlyers();
    }


    @Then("^I should see the url change to the \"([^\"]*)\" locale$")
    public void iShouldSeeTheUrlChangeToTheLocale(String locale) throws Throwable {
        if(locale.equalsIgnoreCase("fr-ca")){
            assertThat(hooks.getDriver().getCurrentUrl()).isEqualToIgnoringCase(hooks.getDataFile().get("url-fr-ca").asText());
        } else {
            assertThat(hooks.getDriver().getCurrentUrl()).isEqualToIgnoringCase(hooks.getDataFile().get("url-en-ca").asText());
        }
    }

    @And("^I should see the \"([^\"]*)\" link available to change locale back to \"([^\"]*)\"$")
    public void iShouldSeeTheLinkAvailableToChangeLocaleBackTo(String localeText, String locale) throws Throwable {
        assertThat(landingPage.getLnkLocale().getText()).isEqualToIgnoringCase(localeText);
    }

    @And("^I should see the \"([^\"]*)\" link on the page header bar visible as \"([^\"]*)\"$")
    public void iShouldSeeTheLinkOnThePageHeaderBarVisibleAs(String element, String elementText) throws Throwable {
        assertThat(landingPage.getLnkFlyers().getText()).isEqualToIgnoringCase(elementText);
    }
}
