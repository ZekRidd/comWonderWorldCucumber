package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.tr.Fakat;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;

import javax.swing.text.TabSet;
import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class Steps {

    private String pageSource;
    private String newPageSource;

    HomePage homepage = new HomePage();

    Faker faker = new Faker();

    public String classField;
    public String firstName;
    public String gender;
    public String dateOfBirth;
    public String email;
    public String guardianName;
    public String currentWindowHandle;
    public String newWindowHandle;
    public Set<String> allWindowHandles;

    @Given("the user navigates to the website URL")
    public void theUserNavigatesToTheWebsiteURL() {
        Driver.getDriver().get(ConfigReader.getProperty("pageUrl"));
    }

    @Then("the homepage should be visible")
    public void theHomepageShouldBeVisible() {
        homepage.homepageLogo.isDisplayed();
    }

    @And("the user closes the page")
    public void theUserClosesThePage() {
        Driver.closeDriver();
    }

    @Given("the user is on the homepage")
    public void the_user_is_on_the_homepage() {
        Driver.getDriver().get(ConfigReader.getProperty("pageUrl"));
        pageSource = Driver.getDriver().getPageSource();
    }

    @When("the user clikcs on the site logo in the top bar")
    public void the_user_clikcs_on_the_site_logo_in_the_top_bar() {
        homepage.homepageLogo.click();
        newPageSource = Driver.getDriver().getPageSource();
    }

    @When("the homepage should refresh")
    public void the_homepage_should_refresh() {
        Assert.assertEquals(pageSource, newPageSource);
    }

    @And("the Latest News information should be visible as scrolling text in the top bar")
    public void theLatestNewsInformationShouldBeVisibleAsScrollingTextInTheTopBar() {
        homepage.latestNews.isDisplayed();
    }

    @And("the following menu {string} should be visible on the top bar")
    public void theFollowingMenuShouldBeVisibleOnTheTopBar(String title) {
        homepage.isMenuTitleVisible(title);
    }

    @When("the user clicks on the {string} in the top bar")
    public void theUserClicksOnTheInTheTopBar(String menuTitle) {
        homepage.menuNavigation(menuTitle);
    }

    @Then("the user should be redirected to the respective page")
    public void theUserShouldBeRedirectedToTheRespectivePage() {
        homepage.actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(homepage.expectedUrl, homepage.actualUrl);
    }

    @When("the user clicks the Academics menu in the top bar")
    public void theUserClicksTheAcademicsMenuInTheTopBar() {
        homepage.academicDropdownLink.click();
    }

    @Then("the user verifies that the dropdown {string} are visible")
    public void theUserVerifiesThatTheDropdownAreVisible(String elements) {
        homepage.initElementMap();
        WebElement element = homepage.dropdownElements.get(elements);
        if(element == null){
            throw new NoSuchElementException("Element with name " + elements + " not found in the map ");
        }
        if(!element.isDisplayed()){
            throw new AssertionError("Element " + elements + " is not visible on the page");
        } else {
            System.out.println("Element " + elements + " is visible");
        }
    }

    @Given("the user on the Online Admission page")
    public void theUserOnTheOnlineAdmissionPage() {
        Driver.getDriver().get(ConfigReader.getProperty("onlineAdmission"));

    }

    @Then("the Instructions section should display the school admission criteria")
    public void theInstructionsSectionShouldDisplayTheSchoolAdmissionCriteria() {
        homepage.instructionsElement.isDisplayed();
    }

    @Then("the Basic Details section {string} should be display, visible and editable")
    public void theBasicDetailsSectionShouldBeDisplayVisibleAndEditable(String elements) {
        homepage.checkElementVisibilityAndEditability(elements);
    }

    @When("the user upload a photo in the Basic Details section")
    public void theUserUploadAPhotoInTheBasicDetailsSection() {
        File photoFile = new File("src/test/resources/testphoto.png");
        String photoPath = photoFile.getAbsolutePath();
        homepage.photoUploadInput.sendKeys(photoPath);
    }

    @Then("the photo should be uploaded successfully")
    public void thePhotoShouldBeUploadedSuccessfully() {
        homepage.removePhotoButton.isDisplayed();
    }

    @Then("Class, First Name, and Gender text boxes in the Basic Details section should be mandatory fields")
    public void classFirstNameAndGenderTextBoxesInTheBasicDetailsSectionShouldBeMandatoryFields() {
        homepage.submitButtonOnlineAdmission.click();
        homepage.classFieldErrorMessage.isDisplayed();
        homepage.firstNameFieldErrorMessage.isDisplayed();
        homepage.genderFieldErrorMessage.isDisplayed();
    }

    @Then("the Parent Detail section {string} should be display, visible and editable")
    public void theParentDetailSectionShouldBeDisplayVisibleAndEditable(String elements) {
        homepage.checkElementVisibilityAndEditability(elements);

    }

    @Then("the Guardian Details section {string} should be display, visible and editable")
    public void theGuardianDetailsSectionShouldBeDisplayVisibleAndEditable(String elements) {
        homepage.checkElementVisibilityAndEditability(elements);
    }

    @Then("If Guardian Is, Guardian Name, and Guardian Relation text boxes in the Guardian Details section should be mandatory fields")
    public void ıfGuardianIsGuardianNameAndGuardianRelationTextBoxesInTheGuardianDetailsSectionShouldBeMandatoryFields() {
        homepage.submitButtonOnlineAdmission.click();
        homepage.ifGuardianIsFieldErrorMessage.isDisplayed();
        homepage.guardianNameFieldErrorMessage.isDisplayed();
        homepage.guardianRelationFieldErrorMessage.isDisplayed();

    }

    @When("I upload a photo of the parent in the Guardian Details section")
    public void iUploadAPhotoOfTheParentInTheGuardianDetailsSection() {
        File photoFile = new File("src/test/resources/testphoto.png");
        String photoPath = photoFile.getAbsolutePath();
        homepage.guardianPhotoSection.sendKeys(photoPath);

    }

    @Then("the If Guardian Is question should be visible")
    public void theIfGuardianIsQuestionShouldBeVisible() {
       Assert.assertTrue(homepage.ifGuardianIsText.isDisplayed());
    }

    @And("the radio buttons for Father, Mother, and Other options should be visible and selectable")
    public void theRadioButtonsForFatherMotherAndOtherOptionsShouldBeVisibleAndSelectable() {
       Assert.assertTrue(homepage.fatherRadioButton.isDisplayed() && homepage.fatherRadioButton.isEnabled());
       Assert.assertTrue(homepage.motherRadioButton.isDisplayed() && homepage.motherRadioButton.isEnabled());
       Assert.assertTrue(homepage.otherRadioButton.isDisplayed() && homepage.otherRadioButton.isEnabled());

       homepage.fatherRadioButton.click();
       Assert.assertTrue(homepage.fatherRadioButton.isSelected());
    }

    @Then("the Miscellaneous Details section {string} should be display, visible and editable")
    public void theMiscellaneousDetailsSectionShouldBeDisplayVisibleAndEditable(String elements) {
        homepage.checkElementVisibilityAndEditability(elements);
    }

    @When("I upload various documents related to the admission in the Upload Documents section")
    public void iUploadVariousDocumentsRelatedToTheAdmissionInTheUploadDocumentsSection() {
        File photoFile = new File("src/test/resources/testphoto.png");
        File pdfFile = new File("src/test/resources/test1.pdf");
        String photoPath = photoFile.getAbsolutePath();
        String pdfPath = pdfFile.getAbsolutePath();
        homepage.uploadDocument.sendKeys(photoPath);
        homepage.uploadDocument.sendKeys(pdfPath);
        
    }

    @Then("the documents should be uploaded successfully")
    public void theDocumentsShouldBeUploadedSuccessfully() {
        homepage.removePhotoButton.isDisplayed();
    }

    @When("the user has entered data in the fields on the Online Admission page")
    public void theUserHasEnteredDataInTheFieldsOnTheOnlineAdmissionPage() {

        Select dropdownClass = new Select(homepage.classSection);
        dropdownClass.selectByIndex(3);
        classField = dropdownClass.getFirstSelectedOption().getText();
        homepage.firstNameSection.sendKeys("Feyzi");
        firstName = "Feyzi";

        Select dropdownGender = new Select(homepage.genderSection);
        dropdownGender.selectByIndex(1);
        gender = dropdownGender.getFirstSelectedOption().getText();

        homepage.dateOfBirthSection.click();
        homepage.dateOfDay.click();
        dateOfBirth = homepage.dateOfBirthSection.getText();

        homepage.emailSection.sendKeys(faker.internet().emailAddress());
        email = homepage.emailSection.getText();

        homepage.fatherRadioButton.click();
        homepage.guardianNameSection.sendKeys("John");
        guardianName = "John";
    }

    @When("the user clicks the Submit button")
    public void theUserClicksTheSubmitButton() {
        homepage.submitButtonOnlineAdmission.click();
    }

    @Then("the user should be redirected to the Review Entered Details and Status page")
    public void theUserShouldBeRedirectedToTheReviewEnteredDetailsAndStatusPage() {
        homepage.termsAndConditions.isDisplayed();
        
    }

    @And("a Reference Number should be generated for the student")
    public void aReferenceNumberShouldBeGeneratedForTheStudent() {
        Assert.assertTrue(homepage.referanceNumber.isDisplayed());
    }

    @Then("the Form Status should be Not Submitted")
    public void theFormStatusShouldBeNotSubmitted() {
        Assert.assertEquals("Not Submitted", homepage.formStatus.getText());
    }

    @And("the Application Date should be the date when the submission was made on the Online Admission page")
    public void theApplicationDateShouldBeTheDateWhenTheSubmissionWasMadeOnTheOnlineAdmissionPage() {
        Assert.assertEquals(homepage.expectedDate,homepage.applicationDateElement.getText());
    }

    @Then("the information displayed should match the data entered on the Online Admission page")
    public void theInformationDisplayedShouldMatchTheDataEnteredOnTheOnlineAdmissionPage() {
        Assert.assertEquals(classField,homepage.reviewClassField.getText());
        Assert.assertEquals(gender,homepage.reviewGenderField.getText());
    }

    @Then("I Agree To The Terms And Conditions checkbox is visible and clickable.")
    public void iAgreeToTheTermsAndConditionsCheckboxIsVisibleAndClickable() throws InterruptedException {
        homepage.getTermsAndConditionsCheckbox.isDisplayed();
        homepage.getTermsAndConditionsCheckbox.isEnabled();
        homepage.getTermsAndConditionsCheckbox.click();
        homepage.reviewPageSubmitButton.click();
        homepage.successfullySubmitElement.isDisplayed();
    }

    @Then("the Login button should be visible on the top bar of the homepage")
    public void theLoginButtonShouldBeVisibleOnTheTopBarOfTheHomepage() {
        homepage.homepageLoginButton.isDisplayed();

    }

    @When("the user clicks on the Login button")
    public void theUserClicksOnTheLoginButton() {
        homepage.homepageLoginButton.click();
    }

    @Then("the user should be redirected to the userlogin page")
    public void theUserShouldBeRedirectedToTheUserloginPage() {
        Assert.assertEquals(ConfigReader.getProperty("userLoginPage"),Driver.getDriver().getCurrentUrl());
    }

    @Given("the user is on the user login page")
    public void theUserIsOnTheUserLoginPage() {
        Driver.getDriver().get(ConfigReader.getProperty("userLoginPage"));
    }

    @Then("there should be a login window on the left side")
    public void thereShouldBeALoginWindowOnTheLeftSide() {
        Assert.assertTrue(homepage.userLoginPageLoginText.isDisplayed());
    }

    @And("there should be information about What's New In Wonder World College on the right side")
    public void thereShouldBeInformationAboutWhatSNewInWonderWorldCollegeOnTheRightSide() {
        Assert.assertTrue(homepage.informationAboutCollege.isDisplayed());
    }

    @When("the user enters valid registered credentials")
    public void theUserEntersValidRegisteredCredentials() {
        homepage.username.sendKeys(ConfigReader.getProperty("username"));
        homepage.password.sendKeys(ConfigReader.getProperty("password"));

    }

    @Then("the user clicks on the Sign In button")
    public void theUserClicksOnTheSignInButton() {
        homepage.loginPageSignInButton.click();
    }

    @And("the user should be redirected to the their personal panel")
    public void theUserShouldBeRedirectedToTheTheirPersonalPanel() {
        homepage.userDashboardPage.isDisplayed();
    }

    @When("the user enters incorrect or missing credentials")
    public void theUserEntersIncorrectOrMissingCredentials() {
        homepage.username.sendKeys(ConfigReader.getProperty("invalidUsername"));
        homepage.password.sendKeys(ConfigReader.getProperty("invalidPassword"));
    }

    @And("the user should see an error message indicating invalid login information")
    public void theUserShouldSeeAnErrorMessageIndicatingInvalidLoginInformation() {
        homepage.errorLoginMessage.isDisplayed();
    }

    @Then("the user clicks on the forget password link")
    public void theUserClicksOnTheForgetPasswordLink() {
        homepage.forgotPassword.click();
    }

    @And("the user should be redirected to the ufpassword page")
    public void theUserShouldBeRedirectedToTheUfpasswordPage() {
        Assert.assertEquals(ConfigReader.getProperty("forgotPasswordPage"),Driver.getDriver().getCurrentUrl());
    }

    @Given("the user is on the forgot password page")
    public void the_user_is_on_the_forgot_password_page() {
       Driver.getDriver().get(ConfigReader.getProperty("forgotPasswordPage"));
    }
    @When("the user enters a valid email in the relevant textbox")
    public void the_user_enters_a_valid_email_in_the_relevant_textbox() {
        homepage.forgotPasswordEmailInput.sendKeys(ConfigReader.getProperty("validStudentEmail"));

    }
    @When("the user selects the appropriate panels")
    public void the_user_selects_the_appropriate_panels() {
        homepage.forgotPasswordStudentCheckbox.click();

    }
    @When("the user clicks the submit button")
    public void the_user_clicks_the_submit_button() {
        homepage.forgotPasswordSubmitButton.click();

    }
    @Then("a password reset email should be sent to the email address entered")
    public void a_password_reset_email_should_be_sent_to_the_email_address_entered() {
        Assert.assertTrue(homepage.emailSendingFailed.isDisplayed());

    }

    @When("the user clicks on the user login link on the forgot password page")
    public void theUserClicksOnTheUserLoginLinkOnTheForgotPasswordPage() {
        homepage.forgotPasswordUserLoginLink.click();
    }

    @When("the user clicks on the link to return to the Front Site")
    public void theUserClicksOnTheLinkToReturnToTheFrontSite() {
        currentWindowHandle = Driver.getDriver().getWindowHandle();
        homepage.frontSiteLink.click();
    }

    @And("the user should be redirected to the homepage")
    public void theUserShouldBeRedirectedToTheHomepage() {
        allWindowHandles = Driver.getDriver().getWindowHandles();
        for (String eachWindowHandles : allWindowHandles){
            if(!eachWindowHandles.equals(currentWindowHandle)){
                newWindowHandle = eachWindowHandles;
            }
        }

        Driver.getDriver().switchTo().window(newWindowHandle);

        String expectedUrl = ConfigReader.getProperty("pageUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Given("the URL for accessing the school panels is accessible")
    public void theURLForAccessingTheSchoolPanelsIsAccessible() {
        Driver.getDriver().get(ConfigReader.getProperty("panelPage"));
    }

    @Then("it should be reachable")
    public void itShouldBeReachable() {
        Assert.assertEquals(ConfigReader.getProperty("panelPage"),Driver.getDriver().getCurrentUrl());
    }

    @Given("the user is on the panels page")
    public void the_user_is_on_the_panels_page() {
       Driver.getDriver().get(ConfigReader.getProperty("panelPage"));
    }
    @When("the user clicks on the Admin login button")
    public void the_user_clicks_on_the_admin_login_button() {
        currentWindowHandle = Driver.getDriver().getWindowHandle();
        homepage.adminLoginButton.click();

    }
    @Then("the user should be redirected to the site login page")
    public void the_user_should_be_redirected_to_the_site_login_page() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        allWindowHandles = Driver.getDriver().getWindowHandles();
        for (String eachWindowHandles : allWindowHandles){
            if(!eachWindowHandles.equals(currentWindowHandle)){
                newWindowHandle = eachWindowHandles;
            }
        }

        Driver.getDriver().switchTo().window(newWindowHandle);
        String expectedUrl = ConfigReader.getProperty("siteLoginPage"); //https://qa.wonderworldcollege.com/site/login
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Given("the user is on the sitelogin page")
    public void theUserIsOnTheSiteloginPage() {
        Driver.getDriver().get(ConfigReader.getProperty("siteLoginPage"));
    }

    @When("the Username and Password text boxes should be visible")
    public void theUsernameAndPasswordTextBoxesShouldBeVisible() {
        homepage.usernameTextBox.isDisplayed();
        homepage.passwordTextBox.isDisplayed();
    }

    @And("the SignIn button should be visible and functional")
    public void theSignInButtonShouldBeVisibleAndFunctional() {
        homepage.signInButton.isDisplayed();
        homepage.signInButton.isEnabled();

    }

    @When("the user clicks on the Forgot password link")
    public void theUserClicksOnTheForgotPasswordLink() {
        homepage.forgotPasswordLinkonAdminLoginSite.click();
    }

    @Then("it should open a page with an email text box and a Submit button")
    public void itShouldOpenAPageWithAnEmailTextBoxAndASubmitButton() {
        homepage.emailTextBox.isDisplayed();
        homepage.submitButtonOnForgotPasswordPage.isDisplayed();
    }

    @And("the email text box and Submit button should be visible and functional")
    public void theEmailTextBoxAndSubmitButtonShouldBeVisibleAndFunctional() {
        homepage.emailTextBox.sendKeys(ConfigReader.getProperty("adminEmail2"));
        homepage.submitButtonOnForgotPasswordPage.click();
        homepage.recoverPasswordMessage.isDisplayed();
    }

    @When("the user enters a registered email and password")
    public void theUserEntersARegisteredEmailAndPassword() {
        homepage.usernameTextBox.sendKeys(ConfigReader.getProperty("adminEmail2"));
        homepage.passwordTextBox.sendKeys(ConfigReader.getProperty("adminPassword"));
    }

    @And("the user clicks the SignIn button")
    public void theUserClicksTheSignInButton() {
        homepage.signInButton.click();
    }

    @Then("access to the admin panel should be granted")
    public void accessToTheAdminPanelShouldBeGranted() {
        String expectedUrl = ConfigReader.getProperty("adminDashboard");
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Given("the admin is logged in to the admin panel")
    public void theAdminIsLoggedInToTheAdminPanel() {
        homepage.adminLogin();
    }

    @When("the admin views the sidebar")
    public void theAdminViewsTheSidebar() {
        homepage.sidebarQuickLinks.isDisplayed();
    }

    @Then("the Online Admission link should be displayed under Student Information menu")
    public void theOnlineAdmissionLinkShouldBeDisplayedUnderStudentInformationMenu() {
        homepage.studentInformation.click();
        homepage.onlineAdmissionAdminPanel.isDisplayed();
    }

    @When("the admin clicks on the Online Admission link")
    public void theAdminClicksOnTheOnlineAdmissionLink() {
        homepage.studentInformation.click();
        homepage.onlineAdmissionAdminPanel.click();

    }

    @Then("the Student List page should be displayed with colums")
    public void theStudentListPageShouldBeDisplayedWithColums() {
        homepage.referanceNoStudentList.isDisplayed();
        homepage.studentNameStudentList.isDisplayed();
        homepage.classStudentList.isDisplayed();
        homepage.fatherNameStudentList.isDisplayed();
        homepage.dateOfBirthStudentList.isDisplayed();
        homepage.genderStudentList.isDisplayed();
        homepage.categoryStudentList.isDisplayed();
        homepage.studentMobileNumberStudentList.isDisplayed();
        homepage.formStatusStudentList.isDisplayed();
        homepage.enrolledStudentList.isDisplayed();
        homepage.createdAtStudentList.isDisplayed();
        homepage.actionStudentList.isDisplayed();
    }
}