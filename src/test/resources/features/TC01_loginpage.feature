Feature: Login Feature for the demo application

  Background:
    Given I am on the login page of the application

  @smoke
  Scenario Outline: Successful login to the application
    Given I have entered the username as "<username>"
    And  I have entered the password as "<password>"
    When I click on the Sign In button
    Then I should be navigated to the home page
    Examples:
      | username        | password  |
      | admin@email.com | admin@123 |

  Scenario Outline: Successful login to the application
    Given I have entered the username as "<username>"
    And  I have entered the password as "<password>"
    When I click on the Sign In button
    Then I should be navigated to the home page
    Examples:
      | username        | password  |
      | admin@email.com | admin@12343 |

    Scenario: Unsuccessful login to the application
      Given I have entered the username as "invalid@invalid.com"
      And  I have entered the password as "invalid"
      When I click on the Sign In button
