Feature: Admin Panel Access and Login

  @TC_026
  Scenario:Verify URL for Admin Panel Access
    Given the URL for accessing the school panels is accessible
    Then it should be reachable

  @TC_027
  Scenario: Navigate to Admin Panel Login Page
    Given the user is on the panels page
    When the user clicks on the Admin login button
    Then the user should be redirected to the site login page

  @TC_028
  Scenario: Verify Login Functionality
    Given the user is on the sitelogin page
    When the Username and Password text boxes should be visible
    And the SignIn button should be visible and functional

  @TC_029
  Scenario:Verify Forgot Password Link
    Given the user is on the sitelogin page
    When the user clicks on the Forgot password link
    Then it should open a page with an email text box and a Submit button
    And the email text box and Submit button should be visible and functional

  @TC_030
  Scenario: Admin Login with Valid Credentials
    Given the user is on the sitelogin page
    When the user enters a registered email and password
    And the user clicks the SignIn button
    Then access to the admin panel should be granted