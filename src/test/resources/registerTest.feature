Feature: Register Test

  Scenario: Valid user registration
    Given valid user details
    When the user tries to register
    Then the user should be registered successfully and status should be inactive
    Given received api_key
    When try to generate otp
    Then otp generated successfully
    Given received generated otp
    When try to verify with otp
    Then user status should change to active
    Given with above valid credentials
    When user try to login
    Then login successfull