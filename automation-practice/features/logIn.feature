Feature: Automation Practice log In process

  Scenario: To login on given page we need valid credentials
    Given customer already has an account on the site
    When customer enter valid email
    And customer enter valid password
    Then customer is successfully transfered to his account