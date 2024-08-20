package pages;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public String expectedUrl;
    public String actualUrl;
    public List<String> dropdownItems;

    LocalDate today = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public String expectedDate = today.format(formatter);

    public boolean isMenuTitleVisible(String menuTitle){
        switch (menuTitle.toLowerCase()){
            case "home":
                return homepageHomeHeader.isDisplayed();
            case "online admission":
                return homepageOnlineAdmission.isDisplayed();
            case "exam result":
                return homepageExamResult.isDisplayed();
            case "about us":
                return homepageAboutUs.isDisplayed();
            case "course":
                return homepageCourse.isDisplayed();
            case "gallery":
                return homepageGallery.isDisplayed();
            case "news":
                return homepageNews.isDisplayed();
            case "contact":
                return homepageContact.isDisplayed();
            default:
                throw new IllegalArgumentException("Menu title " + menuTitle + " is not defined");
        }
    }

    public void menuNavigation(String menuTitle){
        switch (menuTitle.toLowerCase()){
            case "home":
                homepageHomeHeader.click();
                expectedUrl = "https://qa.wonderworldcollege.com/frontend";
                break;
            case "online admission":
                homepageOnlineAdmission.click();
                expectedUrl = "https://qa.wonderworldcollege.com/online_admission";
                break;
            case "exam result":
                homepageExamResult.click();
                expectedUrl = "https://qa.wonderworldcollege.com/examresult";
                break;
            case "about us":
                homepageAboutUs.click();
                expectedUrl = "https://qa.wonderworldcollege.com/page/about-us";
                break;
            case "course":
                homepageCourse.click();
                expectedUrl = "https://qa.wonderworldcollege.com/page/course";
                break;
            case "gallery":
                homepageGallery.click();
                expectedUrl = "https://qa.wonderworldcollege.com/page/gallery";
                break;
            case "news":
                homepageNews.click();
                expectedUrl = "https://qa.wonderworldcollege.com/page/news";
                break;
            case "contact":
                homepageContact.click();
                expectedUrl = "https://qa.wonderworldcollege.com/page/contact-us";
                break;
            default:
                throw new IllegalArgumentException("Menu title " + menuTitle + " is not defined");
        }
    }

    @FindBy(xpath = "//a[@class='logo']")
    public WebElement homepageLogo;

    @FindBy(xpath = "//div[text()='Latest News']")
    public WebElement latestNews;

    @FindBy(xpath = "(//a[text()='Home'])[1]")
    public WebElement homepageHomeHeader;

    @FindBy(xpath = "(//a[text()='Online Admission'])[1]")
    public WebElement homepageOnlineAdmission;

    @FindBy(xpath = "(//a[text()='Exam Result'])[1]")
    public WebElement homepageExamResult;

    @FindBy(xpath = "(//a[text()='About Us'])[1]")
    public WebElement homepageAboutUs;

    @FindBy(xpath = "(//a[text()='Course'])[1]")
    public WebElement homepageCourse;

    @FindBy(xpath = "(//a[text()='Gallery'])[1]")
    public WebElement homepageGallery;

    @FindBy(xpath = "(//a[text()='News'])[1]")
    public WebElement homepageNews;

    @FindBy(xpath = "(//a[text()='Contact'])[1]")
    public WebElement homepageContact;

    //Academics dropdown
    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    public WebElement academicDropdownLink;

    @FindBy(linkText = "Facilities")
    public WebElement facilitiesLink;

    @FindBy(linkText = "School Uniform")
    public WebElement schoolUniformLink;

    @FindBy(linkText = "Principal Message")
    public WebElement principalMessageLink;

    @FindBy(linkText = "Know Us")
    public WebElement knowUsLink;

    @FindBy(linkText = "Approach")
    public WebElement approachLink;

    @FindBy(linkText = "Teacher")
    public WebElement teacherLink;

    @FindBy(linkText = "Houses & Mentoring")
    public WebElement housesMentoringLink;

    @FindBy(linkText = "Student Council")
    public WebElement studentCouncilLink;

    public Map<String, WebElement> dropdownElements = new HashMap<>();

    public void initElementMap(){
        dropdownElements.put("Facilities", facilitiesLink);
        dropdownElements.put("School Uniform", schoolUniformLink);
        dropdownElements.put("Principal Message", principalMessageLink);
        dropdownElements.put("Know Us", knowUsLink);
        dropdownElements.put("Approach", approachLink);
        dropdownElements.put("Teacher", teacherLink);
        dropdownElements.put("Houses & Mentoring", housesMentoringLink);
        dropdownElements.put("Student Council", studentCouncilLink);
        }

   @FindBy(xpath = "//h4[text()='Instructions']")
   public WebElement instructionsElement;


    //Basic Details Section Elements on Online Admission Page
    @FindBy(xpath = "//select[@id='class_id']")
    public WebElement classSection;

    @FindBy(xpath = "//input[@id='firstname']")
    public WebElement firstNameSection;

    @FindBy(xpath = "//input[@id='lastname']")
    public WebElement lastNameSection;

    @FindBy(xpath = "//select[@name='gender']")
    public WebElement genderSection;

    @FindBy(xpath = "//input[@name='dob']")
    public WebElement dateOfBirthSection;

    @FindBy(xpath = "//input[@name='mobileno']")
    public WebElement mobileNumberSection;

    @FindBy(xpath = "(//input[@name='email'])[2]")
    public WebElement emailSection;

    public Map<String, WebElement> detailsElements = new HashMap<>();
    public void initDetailsElements(){
        detailsElements.put("Class",classSection);
        detailsElements.put("First Name",firstNameSection);
        detailsElements.put("Last Name",lastNameSection);
        detailsElements.put("Gender",genderSection);
        detailsElements.put("Date Of Birth",dateOfBirthSection);
        detailsElements.put("Mobile Number",mobileNumberSection);
        detailsElements.put("Email text boxes",emailSection);
        detailsElements.put("Father",fatherNameSection);
        detailsElements.put("Mother",motherNameSection);
        detailsElements.put("Guardian Name",guardianNameSection);
        detailsElements.put("Guardian Relation",guardianRelationSection);
        detailsElements.put("Guardian Email",guardianEmailSection);
        detailsElements.put("Guardian Photo",guardianPhotoSection);
        detailsElements.put("Guardian Phone",guardianPhoneSection);
        detailsElements.put("Guardian Occupation",guardianOccupationSection);
        detailsElements.put("Guardian Address",guardianAddressSection);
        detailsElements.put("National Identification Number",nationalIDSection);
        detailsElements.put("Previous School Details",previousSchoolSection);
    }

    public void checkElementVisibilityAndEditability(String elements){
        initDetailsElements();
        WebElement checkElements = detailsElements.get(elements);
        checkElements.isDisplayed();
        checkElements.isEnabled();
    }

    @FindBy(xpath = "//input[@name='file']")
    public WebElement photoUploadInput;

    @FindBy(xpath = "(//button[text()='Remove'])[1]")
    public WebElement removePhotoButton;

    @FindBy(xpath = "//p[text()='The Class field is required.']")
    public WebElement classFieldErrorMessage;

    @FindBy(xpath = "//p[text()='The Class field is required.']")
    public WebElement firstNameFieldErrorMessage;

    @FindBy(xpath = "//p[text()='The Gender field is required.']")
    public WebElement genderFieldErrorMessage;

    //OnlineAdmission Page submit button
    @FindBy(xpath = "//button[@class='onlineformbtn mt10']")
    public WebElement submitButtonOnlineAdmission;

    //Parent Details Section Elements on Online Admission Page
    @FindBy(xpath = "//input[@name='father_name']")
    public WebElement fatherNameSection;

    @FindBy(xpath = "//input[@name='mother_name']")
    public WebElement motherNameSection;

    //Guardian Details Section Elements on Online Admission Page

    @FindBy(xpath = "//label[text()='If Guardian Is']")
    public WebElement ifGuardianIsText;

    @FindBy(xpath = "//input[@value='father']")
    public WebElement fatherRadioButton;

    @FindBy(xpath = "//input[@value='mother']")
    public WebElement motherRadioButton;

    @FindBy(xpath = "//input[@value='other']")
    public WebElement otherRadioButton;

    @FindBy(xpath = "//input[@name='guardian_name']")
    public WebElement guardianNameSection;

    @FindBy(xpath = "//input[@name='guardian_relation']")
    public WebElement guardianRelationSection;

    @FindBy(xpath = "//input[@name='guardian_email']")
    public WebElement guardianEmailSection;

    @FindBy(xpath = "//input[@name='guardian_pic']")
    public WebElement guardianPhotoSection;

    @FindBy(xpath = "//input[@name='guardian_phone']")
    public WebElement guardianPhoneSection;

    @FindBy(xpath = "//input[@name='guardian_occupation']")
    public WebElement guardianOccupationSection;

    @FindBy(xpath = "//textarea[@name='guardian_address']")
    public WebElement guardianAddressSection;

    //Guardian Details Mandatory Fields Elements
    @FindBy(xpath = "//p[text()='The Guardian field is required.']")
    public WebElement ifGuardianIsFieldErrorMessage;

    @FindBy(xpath = "//p[text()='The Guardian Name field is required.']")
    public WebElement guardianNameFieldErrorMessage;

    @FindBy(xpath = "//p[text()='The Guardian Relation field is required.']")
    public WebElement guardianRelationFieldErrorMessage;

    //Miscellaneous Details Section Elements on Online Admission
    @FindBy(xpath = "//input[@id='adhar_no']")
    public WebElement nationalIDSection;

    @FindBy(xpath = "//textarea[@name='previous_school']")
    public WebElement previousSchoolSection;


    //Upload Documents button on Online Admission Page
    @FindBy(xpath = "//input[@id='document']")
    public WebElement uploadDocument;

    //
    @FindBy(xpath = "(//th[@class='datepicker-switch'])[1]")
    public WebElement datePickerYear;

    @FindBy(xpath = "(//th[@class='prev'])[1]")
    public WebElement datePickerPrev;

    @FindBy(xpath = "//span[text()='1993']")
    public WebElement dateOfYear;

    @FindBy(xpath = "//span[text()='Jul']")
    public WebElement dateOfMonth;

    @FindBy(xpath = "//td[text()='5']")
    public WebElement dateOfDay;

    @FindBy(xpath = "//li[text()='Reference No']")
    public WebElement referanceNumber;

    @FindBy(xpath = "//a[text()='I Agree To The Terms And Conditions']")
    public WebElement termsAndConditions;

    @FindBy(xpath = "//input[@id='checkterm']")
    public WebElement getTermsAndConditionsCheckbox;

    @FindBy(xpath = "//span[text()='Not Submitted']")
    public WebElement formStatus;

    @FindBy(xpath = "//span[text()='19/08/2024']")
    public WebElement applicationDateElement;

    //Review Page
    @FindBy(xpath = "//p[text()='Class 3']")
    public WebElement reviewClassField;

    @FindBy(xpath = "//p[text()='Male']")
    public WebElement reviewGenderField;

    @FindBy(xpath = "//button[@id='submitbtn']")
    public WebElement reviewPageSubmitButton;

    @FindBy(xpath = "//div[text()='Form Has Been Submitted Successfully..!! ']")
    public WebElement successfullySubmitElement;

    //US_016 USER LOGIN ACCESS
    @FindBy(xpath = "//a[text()='Login']")
    public WebElement homepageLoginButton;

    @FindBy(xpath = "//h3[text()='User Login']")
    public WebElement userLoginPageLoginText;

    //What's New In Wonder World College
    @FindBy(xpath = "//h3[@class='h3']")
    public WebElement informationAboutCollege;

    //User Login page Username
    @FindBy(xpath = "//input[@name='username']")
    public WebElement username;

    //User Login page Password
    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    //User Login page Submit button
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginPageSignInButton;

    public void userLogin(){
        Driver.getDriver().get(ConfigReader.getProperty("userLoginPage"));
        username.sendKeys(ConfigReader.getProperty("username"));
        password.sendKeys(ConfigReader.getProperty("password"));
        loginPageSignInButton.click();
    }

    //User profile page
    @FindBy(xpath = "//span[text()='My Profile']")
    public WebElement userDashboardPage;

    //Error login message
    @FindBy(xpath = "//div[text()='Invalid Username Or Password']")
    public WebElement errorLoginMessage;

    //Forgot password link
    @FindBy(xpath = "//a[text()=' Forgot Password']")
    public WebElement forgotPassword;

    //Forgot Password page Email text area
    @FindBy(xpath = "//input[@placeholder='Email']")
    public WebElement forgotPasswordEmailInput;

    //Forgot Password page Student radio checkbox
    @FindBy(xpath = "//input[@value='student']")
    public WebElement forgotPasswordStudentCheckbox;

    //Forgot Password page Parent radio checkbox
    @FindBy(xpath = "//input[@value='parent']")
    public WebElement forgotPasswordParentCheckbox;

    //Forgot Password page Submit button
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement forgotPasswordSubmitButton;


    //Forgot Password page Email sending successfully
    @FindBy(xpath = "//div[text()='Email sending succesfully.']")
    public WebElement emailSendingSuccessfully;


    //Forgot Password page Email sending failed
    @FindBy(xpath = "//div[text()='Email sending failed. Please try again.']")
    public WebElement emailSendingFailed;

    //Forgot Password page User Login link
    @FindBy(xpath = "//a[@class='forgot']")
    public WebElement forgotPasswordUserLoginLink;

    //User Login Page Front Site link
    @FindBy(xpath = "//a[@class='forgot pull-right']")
    public WebElement frontSiteLink;

    // =================== LOGIN PANEL - SITE LOGIN ========================

    //Student Login button on Panel Page
    @FindBy(xpath = "//i[@class='fa fa-user']")
    public WebElement studentLoginButton;

    //Parent Login button on Panel Page
    @FindBy(xpath = "//i[@class='material-icons']")
    public WebElement parentLoginButton;

    //Admin Login button on Panel Page
    @FindBy(xpath = "//a[@class='btn btn-lg btn-admin']")
    public WebElement adminLoginButton;

    //Teacher Login button on Panel Page
    @FindBy(xpath = "//a[@class='btn btn-default btn-lg']")
    public WebElement teacherLoginButton;

    //Front Site button on Panel Page
    @FindBy(xpath = "//a[@class='btn btn-lg btn-primary']")
    public WebElement frontSiteButton;

    //Admin Login Site username text box
    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameTextBox;

    //Admin Login Site password text box
    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordTextBox;

    //Admin Login Site SignIn button
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;

    //Admin Login Site Forgot Password link
    @FindBy(xpath = "//a[@class='forgot']")
    public WebElement forgotPasswordLinkonAdminLoginSite;

    //Admin Login Site Front Site link
    @FindBy(xpath = "//i[@class='fa fa-empire']")
    public WebElement frontSiteLinkAdminLoginSite;

    //Admin Login Site User Login link
    @FindBy(xpath = "//i[@class='fa fa-user']")
    public WebElement userLoginLink;

    //Forgot Password >> Email text box
    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailTextBox;

    //Forgot Password >> Submit button
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButtonOnForgotPasswordPage;

    //Recover Password Message
    @FindBy(xpath = "//div[text()='Please Check Your Email To Recover Your Password']")
    public WebElement recoverPasswordMessage;

    //Admin Login method
    public void adminLogin(){
        Driver.getDriver().get(ConfigReader.getProperty("siteLoginPage"));
        usernameTextBox.sendKeys(ConfigReader.getProperty("adminEmail"));
        passwordTextBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        signInButton.click();
    }

    //ADMIN DASHBOARD PAGE - Quick Links
    @FindBy(xpath = "//a[@class='dropdown-toggle drop5']")
    public WebElement sidebarQuickLinks;

    //ADMIN DASHBOARD PAGE - Student Information bar
    @FindBy(xpath = "//span[text()='Student Information']")
    public WebElement studentInformation;

    //ADMIN DASHBOARD PAGE - Student Information bar >> Online Admission link
    @FindBy(xpath = "(//a[text()='Online Admission'])[3]")
    public WebElement onlineAdmissionAdminPanel;

    //ADMIN DASHBOARD PAGE - Student List columns
    @FindBy(xpath = "//th[text()='Reference No']")
    public WebElement referanceNoStudentList;

    //ADMIN DASHBOARD PAGE - Student List columns
    @FindBy(xpath = "//th[text()='Student Name']")
    public WebElement studentNameStudentList;

    //ADMIN DASHBOARD PAGE - Student List columns
    @FindBy(xpath = "//th[text()='Class']")
    public WebElement classStudentList;

    //ADMIN DASHBOARD PAGE - Student List columns
    @FindBy(xpath = "//th[text()='Father Name']")
    public WebElement fatherNameStudentList;

    //ADMIN DASHBOARD PAGE - Student List columns
    @FindBy(xpath = "//th[text()='Date Of Birth']")
    public WebElement dateOfBirthStudentList;

    //ADMIN DASHBOARD PAGE - Student List columns
    @FindBy(xpath = "//th[text()='Gender']")
    public WebElement genderStudentList;

    //ADMIN DASHBOARD PAGE - Student List columns
    @FindBy(xpath = "//th[text()='Category']")
    public WebElement categoryStudentList;

    //ADMIN DASHBOARD PAGE - Student List columns
    @FindBy(xpath = "//th[text()='Student Mobile Number']")
    public WebElement studentMobileNumberStudentList;

    //ADMIN DASHBOARD PAGE - Student List columns
    @FindBy(xpath = "//th[text()='Form Status']")
    public WebElement formStatusStudentList;

    //ADMIN DASHBOARD PAGE - Student List columns
    @FindBy(xpath = "//th[text()='Enrolled']")
    public WebElement enrolledStudentList;

    //ADMIN DASHBOARD PAGE - Student List columns
    @FindBy(xpath = "//th[text()='Created At']")
    public WebElement createdAtStudentList;

    //ADMIN DASHBOARD PAGE - Student List columns
    @FindBy(xpath = "//th[text()='Action']")
    public WebElement actionStudentList;

}
