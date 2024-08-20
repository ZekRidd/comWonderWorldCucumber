Feature: US_002_Menu Navigation

    @TC_002
    Scenario: Verify top bar menu navigation
      Given the user is on the homepage
      When the user clikcs on the site logo in the top bar
      And the homepage should refresh

    @TC_003
    Scenario Outline: Verify menu title redirections
      Given the user is on the homepage
      When the user clicks on the "<menu title>" in the top bar
      Then the user should be redirected to the respective page
      Examples:
        | menu title       |
        | Home             |
        | Online Admission |
        | Exam Result      |
        | About Us         |
        | Course           |
        | Gallery          |
        | News             |
        | Contact          |

      @TC_004
    Scenario Outline: Verify Academics dropdown menu contents and redirections
      Given the user is on the homepage
      When the user clicks the Academics menu in the top bar
      Then the user verifies that the dropdown "<elements>" are visible
        Examples:
        | elements            |
        | Facilities          |
        | School Uniform      |
        | Principal Message   |
        | Know Us             |
        | Approach            |
        | Teacher             |
        | Houses & Mentoring  |
        | Student Council     |

