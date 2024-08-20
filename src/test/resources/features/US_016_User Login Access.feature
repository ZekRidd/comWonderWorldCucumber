Feature: User Login Access and Functionality

  @TC_018
  Scenario: Visibility and Redirection of Login Button
    Given the user is on the homepage
    Then the Login button should be visible on the top bar of the homepage
    When the user clicks on the Login button
    Then the user should be redirected to the userlogin page

  @TC_019
  Scenario: Layout of User Login Page
    Given the user is on the user login page
    Then there should be a login window on the left side
    And there should be information about What's New In Wonder World College on the right side

  @TC_020
  Scenario: Successful Login with Valid Credentials
    Given the user is on the user login page
    When the user enters valid registered credentials
    Then the user clicks on the Sign In button
    And the user should be redirected to the their personal panel

  @TC_021
  Scenario: Unsuccessful Login with Invalid Credentials
    Given the user is on the user login page
    When the user enters incorrect or missing credentials
    Then the user clicks on the Sign In button
    And the user should see an error message indicating invalid login information

  @TC_022
  Scenario: Redirect to Forgot Password Page
    Given the user is on the user login page
    Then the user clicks on the forget password link
    And the user should be redirected to the ufpassword page

  @TC_023
  Scenario: Reset Password with Valid Email
    Given the user is on the forgot password page
    When the user enters a valid email in the relevant textbox
    And the user selects the appropriate panels
    And the user clicks the submit button
    Then a password reset email should be sent to the email address entered

  @TC_024
  Scenario: Return to User Login Page from Forgot Password Page
    Given the user is on the forgot password page
    When the user clicks on the user login link on the forgot password page
    And the user should be redirected to the userlogin page

  @TC_025
  Scenario: Redirect to Homepage from User Login Page
    Given the user is on the user login page
    When the user clicks on the link to return to the Front Site
    And the user should be redirected to the homepage