Feature:Functionality to test cart function in Amazon
  Scenario: Adding a “Monitor” Item in Cart and verifying sub total
  Given I navigate to the "Amazon.in"
  When I search for “Monitor”
  And I open the First Monitor
  And I add the First Monitor to the Shopping Cart
  And I open my cart
  Then verify the price of the Product
  And the subtotal should be accurate
  
