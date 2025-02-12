Feature: Test Log In

  @ValidLogin
  Scenario: Validate successful login
    Given User navigate to test site
    When User enters credentials
      | userName | student     |
      | password | Password123 |
    Then User login successful

  @InvalidLogin
  Scenario: Validate unsuccessful login
    Given User navigate to test site
    When User enters credentials
      | userName | student     |
      | password | Password345 |
    Then User login unsuccessful

  @GoToHome
  Scenario: Validate navigate to home
    Given User navigate to test site
    When User navigate to Home
    Then Home page displayed