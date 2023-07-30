Feature: Registration invalid data check

  Scenario: Registration with invalid data
    Given I am on the home page
    When I click on 'Sign in' button at the right corner of the page
    And I click on 'No account? Create one here' link
    And I fill the form with invalid data
    And I click on 'Save' button
    And I check that 'First name' highlighted in red
    And I check that pop-up with text 'Invalid format.' appear under field
