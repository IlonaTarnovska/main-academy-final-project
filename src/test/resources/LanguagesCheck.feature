Feature: Language verification

  Scenario: Verify available languages

    Given I am on the home page
    Then I should see 44 languages in the dropdown in the top menu
    And I should see "Українська" language in the dropdown