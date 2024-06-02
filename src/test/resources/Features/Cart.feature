Feature:Functionality to test cart function in Amazon
  Scenario: Adding a “Monitor” Item in Cart and verifying sub total
    Given I navigate to the "https://www.amazon.in/"
    When I search for "Monitor"
    And I open the First Monitor
    And I add the product to the Shopping Cart
    And I open my cart
    Then verify the "Monitor" price of the Product
    And the "Monitor" subtotal should be accurate

  Scenario: Adding a “Laptop” Item in Cart and verifying sub total
    Given I navigate to the "https://www.amazon.in/"
    When I search for "Laptop"
    And I open the second Laptop
    And I add the product to the Shopping Cart
    And I open my cart
    Then verify the "Laptop" price of the Product
    And the "Laptop" subtotal should be accurate
