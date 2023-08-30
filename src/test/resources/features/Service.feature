Feature: Create, update and delet user
  @PostUser
  Scenario: Create user successfully.
    When I consume the endpoint and I send the user information email, username password firstname lastname
    Then I validate the response services

  @PutUser
  Scenario: Update user successfully.
    When I consume endpoint and I send the user information email, username password firstname lastname
    Then I validate response service

  @DeleteUser
  Scenario: Delete user successfully.
    When I consume the endpoint and I send id
    Then I can validate the phone