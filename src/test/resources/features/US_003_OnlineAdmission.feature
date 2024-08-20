Feature:Online Admission Page

  @TC_005
  Scenario Outline: Redirect to Online Admission Page
    Given the user is on the homepage
    When the user clicks on the "<menu title>" in the top bar
    Then the user should be redirected to the respective page
    Examples:
      | menu title                   |
      | Online Admission             |

    @TC_006
  Scenario: Instructions Section Display
    Given the user on the Online Admission page
    Then the Instructions section should display the school admission criteria

    @TC_007
  Scenario Outline: Basic Details Section Visibility and Editability
    Given the user on the Online Admission page
    Then the Basic Details section "<elements>" should be display, visible and editable
      Examples:
        | elements            |
        | Class               |
        | First Name          |
        | Last Name           |
        | Gender              |
        | Date Of Birth       |
        | Mobile Number       |
        | Email text boxes    |


      @TC_008
  Scenario: Upload Student Photo in Basic Details Section
    Given the user on the Online Admission page
    When the user upload a photo in the Basic Details section
    Then the photo should be uploaded successfully

      @TC_009
  Scenario: Mandatory Fields in Basic Details Section
    Given the user on the Online Admission page
    Then Class, First Name, and Gender text boxes in the Basic Details section should be mandatory fields

      @TC_010
  Scenario Outline: Parent Detail Section Visibility and Editability
    Given the user on the Online Admission page
    Then the Parent Detail section "<elements>" should be display, visible and editable
        Examples:
          | elements   |
          | Father     |
          | Mother     |

     @TC_011
  Scenario Outline: Guardian Details Section Visibility and Editability
    Given the user on the Online Admission page
    Then the Guardian Details section "<elements>" should be display, visible and editable
    Examples:
      | elements              |
      | Guardian Name         |
      | Guardian Relation     |
      | Guardian Email        |
      | Guardian Photo        |
      | Guardian Phone        |
      | Guardian Occupation   |
      | Guardian Address      |

       @TC_012
  Scenario: Mandatory Fields in Guardian Details Section
    Given the user on the Online Admission page
    Then If Guardian Is, Guardian Name, and Guardian Relation text boxes in the Guardian Details section should be mandatory fields

     @TC_013
  Scenario: Upload Parent Photo in Guardian Details Section
    Given the user on the Online Admission page
    When I upload a photo of the parent in the Guardian Details section
    Then the photo should be uploaded successfully

       @TC_014
  Scenario: Guardian Details 'If Guardian Is' Question Visibility
    Given the user on the Online Admission page
    Then the If Guardian Is question should be visible
    And the radio buttons for Father, Mother, and Other options should be visible and selectable

      @TC_015
  Scenario Outline: Miscellaneous Details Section Visibility and Editability
    Given the user on the Online Admission page
    Then the Miscellaneous Details section "<elements>" should be display, visible and editable
    Examples:
      | elements                        |
      | National Identification Number  |
      | Previous School Details         |

    @TC_016
  Scenario: Upload Documents Section Functionality
    Given the user on the Online Admission page
    When I upload various documents related to the admission in the Upload Documents section
    Then the documents should be uploaded successfully


    @TC_017
    Scenario: Redirect After Form Submission
      Given the user on the Online Admission page
      When the user has entered data in the fields on the Online Admission page
      When the user clicks the Submit button
      Then the user should be redirected to the Review Entered Details and Status page
      And a Reference Number should be generated for the student
      Then the Form Status should be Not Submitted
      And the Application Date should be the date when the submission was made on the Online Admission page
      And the information displayed should match the data entered on the Online Admission page
      And I Agree To The Terms And Conditions checkbox is visible and clickable.

