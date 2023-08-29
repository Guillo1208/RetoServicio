Feature: Delete user

  @DeleteUser
  Scenario: Delete user successfully.
    When I consume the endpoint and I send id
    Then I can validate the phone
