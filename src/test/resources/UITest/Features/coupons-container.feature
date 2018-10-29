Feature: Coupons container page navigation
  Scenario: As a user I should be able to navigate to the coupons page from the flyers page
    Given I have navigated to the landing page of Flipp in "en-ca" locale with "Flyers" in primary navigation
    When I click on the Browse Flyers button
    Then I navigate to the Flyers page
    When I click the Coupons link on the left pane
    Then I navigate to the Coupons page
