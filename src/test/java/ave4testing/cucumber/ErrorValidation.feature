
@tag
Feature: Error Validation
  I want to use this template for my feature file


  @ErrorValidation
  Scenario Outline: Error Validation
    Given   I landed on Ecommerce Page
    When   Logged in with username <name> and password <password>
    Then   "Incorrect email or password." message is displayed
    Examples:
      | name  								|  password		    |
      | ave4testing@gmail.com  |  Iamking@0    |


#    "ave4testing@gmail.com","Iamking@000"