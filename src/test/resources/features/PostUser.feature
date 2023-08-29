Feature: Create user

  @PostUser
  Scenario Outline: Create user successfully.
    When I consume the endpoint "<endpoint>" and I send the user information email "<email>", username "<username>" password "<password>" firstname "<firstname>" lastname "<lastname>"
    Then I validate the response service <code>

    Examples:
      | email               | username | password | firstname | lastname | endpoint | code |
      | guije12@hotmail.com | guibo    | ytyeuub  | Guillermo | Garcia   | /users   | 200  |