Feature: Automation Practice add 5 products to the cart

  Scenario: Adding 5 products in the cart and verifying their existence in the cart
    Given open Automation Practice homepage
    When customer choose Summer dresses category from Dresses category
    Then webpage with Summer dresses opens up
    When clicking on Printed Chiffon dress
    Then webpage with clicked product is open
    When adding 4 more dresses to the cart
    And customers click on Proceed to checkout button
    Then webpage with cart and 5 dresses in it opens up
