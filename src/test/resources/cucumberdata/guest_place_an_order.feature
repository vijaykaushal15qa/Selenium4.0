Feature:Placing an Order as a guest.

  Scenario: Using default payment option
    Given I am guest customer
    And I have product in the cart
    And I'm on the checkout page
    When I am providing the billing details
    | firstname |lastname | country | address_line1 | city | state | zip |email
    | VIJAY |KAUSHAL | United States (US) | Saudagar | Pune | California | 66633 |xyz.abc@try.com
    And I place an order
    Then the order should be placed successfully
