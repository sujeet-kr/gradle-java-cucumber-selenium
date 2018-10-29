package UITest.StepDefinitions;

import UITest.Core.Driver.StepsStartHook;
import UITest.PageObjects.LandingPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class LandingPageSteps {
    private LandingPage landingPage;
    private StepsStartHook stepsStartHook;

    public LandingPageSteps (LandingPage landingPage, StepsStartHook stepsStartHook ){
        this.landingPage = landingPage;
        this.stepsStartHook = stepsStartHook;
    }

    @When("^I change the locale from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void iChangeTheLocaleFromTo(String fromLocale, String toLocale) throws Throwable {
        landingPage.changeLocale(fromLocale, toLocale);
        assertThat(landingPage.getLnkFlyers().getText()).isEqualToIgnoringCase("Circulaires");
    }

    @Given("^I have navigated to the landing page of Flipp in \"([^\"]*)\" locale with \"([^\"]*)\" in primary navigation$")
    public void iHaveNavigatedToTheLandingPageOfFlippInLocaleWithInPrimaryNavigation(String locale, String assertionText) throws Throwable {
        if (locale.equalsIgnoreCase("en-ca")){
            stepsStartHook.getDriver().get(stepsStartHook.getDataFileReader().getEnvironmentData().get("prod").get("url-en-ca").asText());
        } else {
            stepsStartHook.getDriver().get(stepsStartHook.getDataFileReader().getEnvironmentData().get("prod").get("url-fr-ca").asText());
        }
        assertThat(landingPage.getLnkFlyers().getText()).isEqualToIgnoringCase(assertionText);
    }

    @When("^I click on the Browse Flyers button$")
    public void iClickOnTheBrowseFlyersButton() throws Throwable {
        landingPage.clickBrowseFlyers();
    }


    //TODO add login to call url from data file
    @Then("^I should see the url change to the \"([^\"]*)\" locale$")
    public void iShouldSeeTheUrlChangeToTheLocale(String locale) throws Throwable {
        if(locale.equalsIgnoreCase("en-ca")){
            assertThat(stepsStartHook.getDriver().getCurrentUrl().toString()).isEqualToIgnoringCase("");
        } else {
            assertThat(stepsStartHook.getDriver().getCurrentUrl().toString()).isEqualToIgnoringCase("https://www.flipp.com/accueil?locale=fr-ca");
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
