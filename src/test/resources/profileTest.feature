Feature: Test Profile API

  Scenario: get the profile of a user
    Given with valid credentials
    When get the profile of a user
    Then user should get profile details
    