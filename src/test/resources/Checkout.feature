Feature: Checkout end-to-end

  Scenario: Checking  end-to-end
    Given I am on the home page
    Then  I enter 'Mug' in the search field and press 'Enter'
    Then  On the 'SEARCH RESULTS' page I click on 'Customizable Mug'
    And I enter 'Best mug ever' in 'Product customization' field
    And I click 'SAVE CUSTOMIZATION'
    And I change 'Quantity' to '1' if not '1' already
    And I click 'ADD TO CART' button
    And I click 'CONTINUE SHOPPING'
    Then I enter 'T-Shirt' in the search field and press 'Enter'
    Then On the 'SEARCH RESULTS' page I click on 'Hummingbird Printed T-Shirt'
    And I select 'Black' color
    And I click 'ADD TO CART' button
    And I click 'PROCEED TO CHECKOUT'
    And On the 'SHOPPING CART' page I check that 'Total' calculated correct
    And I click 'PROCEED TO CHECKOUT'
    And I fill the 'PERSONAL INFORMATION' form with valid data (without password)
    And I check all necessary checkboxes
    And I click 'CONTINUE'
    And I fill the 'ADDRESSES' form with valid data
    And I click 'CONTINUE'
    And I select 'My carrier' in the 'SHIPPING METHOD' section
    And I click 'CONTINUE'
    And I select 'Pay by Check' in the 'PAYMENT' section
    And the amount should equal Subtotal + Shipping
    And I click on 'I agree...' checkbox
    And I click on 'Order with an obligation to pay'
    Then I should see 'YOUR ORDER IS CONFIRMED' on the next page
    And the 'TOTAL' should be calculated correctly
