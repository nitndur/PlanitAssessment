package tests;

import org.testng.annotations.Test;
import pages.ContactPage;
import pages.HomePage;
import testBase.BaseTest;
import utilities.ExtentReports.*;

public class TC01_VerifyErrorsWhenMandatoryFieldsMissingInContactTest extends BaseTest {
    @Test
    public void VerifyErrorMessage(){
        ExtentTestManager.startTest("Missing mandatory fields","VerifyErrorsWhenMandatoryFieldsMissingInContact");
        ContactPage contactPage;
        HomePage homePage = new HomePage(driver);
        String name = prop.getProperty("foreName");
        String email = prop.getProperty("email");
        String msg = prop.getProperty("msg");
        contactPage = homePage.clickContact();
        contactPage.clickSubmit()
                   .verifyMissingMandatoryFieldErrors()
                   .enterMandatoryFields(name,email,msg)
                   .verifyErrorMsgDisappear();
    }
}
