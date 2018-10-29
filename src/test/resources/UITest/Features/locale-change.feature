
Feature: Flipp Application Locale change

  @regression
  @production
  Scenario: As a user I should be able to change the locale from English to French
    Given I have navigated to the landing page of Flipp in "en-ca" locale with "Flyers" in primary navigation
    When I change the locale from "en-ca" to "fr-ca"
    Then I should see the url change to the "fr-ca" locale
    And I should see the "English" link available to change locale back to "en-ca"
    And I should see the "Flyers" link on the page header bar visible as "Circulaires"

  @regression
  @smoke
  Scenario: As a user I should be able to change the locale from French to English
    Given I have navigated to the landing page of Flipp in "fr-ca" locale with "Circulaires" in primary navigation
    When I change the locale from "fr-ca" to "en-ca"
    Then I should see the url change to the "fr-ca" locale
    And I should see the "Français" link available to change locale back to "Français"
    And I should see the "Flyers" link on the page header bar visible as "Flyers"


