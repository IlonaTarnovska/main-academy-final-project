Feature: Check categories

  Scenario: Check pop up categories

    Given I am on the home page
    Then I hover mouse over 'CLOTHES'
    Then I check that 'MEN' and 'WOMEN' sub menu items appears
    Then I hover mouse over 'ACCESSORIES'
    Then I check that 'STATIONERY' and 'HOME ACCESSORIES' sub menu items appears
    Then I hover mouse over 'ART'
    And I check that no any sub category appears
    And I check all assertions

