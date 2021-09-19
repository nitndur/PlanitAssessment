package tests;

import org.testng.annotations.Test;
import pages.ContactPage;
import pages.HomePage;
import testBase.BaseTest;
import utilities.ExtentReports.*;

public class TC02_VerifySuccessfulContactSubmissionTest extends BaseTest {
    @Test
    public void VerifyHappyPath(){
        ExtentTestManager.startTest("Successful Contact Submission","VerifySuccessfulContactSubmissionTest");
        ContactPage contactPage;
        HomePage homePage = new HomePage(driver);
        String name = prop.getProperty("foreName");
        String email = prop.getProperty("email");
        String msg = prop.getProperty("msg");
        contactPage = homePage.clickContact();
        contactPage.enterMandatoryFields(name,email,msg)
                   .clickSubmit()
                   .verifySuccessMessage(name);
    }
}
