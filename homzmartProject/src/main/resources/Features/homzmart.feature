@smoke
Feature: Registration
  Scenario: User Registration
    Given user is on the registration page
    When user enters valid registration information
    And user sign out and register with same email
    Then user should see an error message saying Email address already exists
    When user enters a not valid phone number
    Then user should see an error message indicates that Mobile is required
    When user fills all required data leaves confirm password placeholder empty
    Then user should see an error message indicates that Confirm Password is required
    When the user fills in the registration fields with an unconventional email

  Scenario: Browse products by category
    Given I am on the website homepage
    When I click on the Furniture category
    Then I should see a list of products related to beds and beech
    And I should be able to filter the products by price and other attributes

  Scenario: View product details
    Given I am on a product page
    Then I should see a large image of the product
    And I should see the product name, price, and description
    And I should be able to read customer reviews and ratings

  Scenario: Search for products
    Given I am on the IKEA homepage
    When I enter shelf in the search bar
    Then I should see a list of products that match the search term

  Scenario: Add products to cart
    Given I am browsing the Living Room category
    When I click Add to cart on a product
    Then I should see success message of the added item
    And the product should be added to my cart
    And I should see the updated cart total

  Scenario: Update cart quantities
    Given I have a product in my cart
    When I change the quantity to two and the cart total should be updated accordingly

  Scenario: Remove products from cart
    Given I have a item in my cart
    When I click Remove on the product
    Then the product should be removed from my cart

  Scenario: Checkout as a guest
    Given I have items in my cart
    When I proceed to checkout
    Then I should be able to enter my shipping information without creating an account

  Scenario: Checkout with an existing account
    Given I am logged in to my Homzmart account
    When I go to checkout
    Then I should see my stored shipping information
    And I should be able to see payment methods

  Scenario: Contact customer support
    Given I am on the Homzmart homepage
    When I click on the Contact Us link
    Then I should see a variety of contact options, such as phone number, email address
