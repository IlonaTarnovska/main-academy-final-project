Feature: Sorting products

  Scenario: Check sorting products

    Given I am on the home page
    Then I click on the 'All products >' under the 'POPULAR PRODUCTS' section
    Then I sort products as 'Name, A to Z'
    Then I check that sorting by name ascending is correct
    Then I sort products as 'Name, Z to A'
    Then I check that sorting by name descending is correct
    Then I sort products as 'Price, low to high'
    Then I check that sorting by Price ascending is correct
    Then I sort products as 'Price, high to low'
    Then I check that sorting by Price Descending is correct