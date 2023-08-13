Feature: Price drop checking

  Scenario: Check price drop

    Given I am on the home page
    And I click on 'Prices drop' link at the bottom of the page
    Then I check that every product has old and new price
    And I check that promo price for every product calculates correct
    And I check all assertions
