Feature: Adding to cart check

  Scenario: Check adding to cart items

    Given I am on the home page
    Then In the search field I enter 'Bear' and press 'Enter'
    Then On the 'SEARCH RESULTS' page I click on 'Brown Bear Notebook'
    Then I change 'Paper type' to 'Doted'
    Then I change 'Quantity' to '5'
    Then I click on 'ADD TO CART' button
    Then I check that new window with title 'Product successfully added to your shopping cart' appears
    Then I check that correct 'Paper Type' 'Doted' and 'Quantity' '5' is shown on the left side of the window
    And I check that 'Total' calculated correct
