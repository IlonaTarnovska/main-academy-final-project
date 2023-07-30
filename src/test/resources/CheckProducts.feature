Feature: Check popular products

  Scenario: Checking products
    Given I am on the home page
    Then I check that 8 products exist in 'POPULAR PRODUCTS' section
    Then I check that every product has name
    Then I check that every product has price
    And I check that all prices bigger than 0