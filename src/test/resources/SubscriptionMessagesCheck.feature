Feature:  Subscribe with an invalid email

  Scenario:  Verify subscription form
    Given I am on the home page
    When I check subscription label 'Get our latest news and special sales'
    Then I check subscription message 'You may unsubscribe at any moment. For that purpose, please find our contact info in the legal notice.'