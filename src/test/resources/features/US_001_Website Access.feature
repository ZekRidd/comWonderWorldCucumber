Feature: US_001_Website Access

  @TC_001
  Scenario: Access the website and verify homepage elements
    Given the user navigates to the website URL
    Then the homepage should be visible
    And the Latest News information should be visible as scrolling text in the top bar
    And the following menu "home" should be visible on the top bar


