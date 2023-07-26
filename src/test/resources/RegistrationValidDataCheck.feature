Feature: Registration check

  Scenario: Registration with valid data
    Given I am on the home page
    When I click on 'Sign in' button at the right corner of the page
    And I click on 'No account? Create one here' link
    And I fill the form with valid data
    And I click on 'Save' button
    Then I should see my name appear near the cart button