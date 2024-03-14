
 @tag
  Feature: Purchase the order from Ecommerce Website
    I want to use this template for my feature file

    Background:
      Given I landed on Ecommerce Page


    @tag1
    Scenario Outline: Positive Test of Purchasing Order
      Given   Logged in with username <name> and <password> "Iamking@000"
      When    I add product <productName> to Cart
      And     Checkout <productName> and submit the order
      Then    "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage
      Examples:
        | name              |  password       | productName  |
        | rahulshetty@gmail.com | Iamking@000 | ZARA COAT 3   |


#    "ave4testing@gmail.com","Iamking@000"