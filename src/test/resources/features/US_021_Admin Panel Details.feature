Feature: Admin Panel Details Functionality

  @TC_031
  Scenario: Display Online Admission Link in Admin Panel Sidebar
    Given the admin is logged in to the admin panel
    When the admin views the sidebar
    Then the Online Admission link should be displayed under Student Information menu

  @TC_032
  Scenario: Access Student List from Online Admission Link
    Given the admin is logged in to the admin panel
    When the admin clicks on the Online Admission link
    Then the Student List page should be displayed with colums