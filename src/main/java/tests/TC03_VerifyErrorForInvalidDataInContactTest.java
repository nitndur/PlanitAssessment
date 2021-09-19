package tests;

import org.testng.annotations.Test;
import pages.ContactPage;
import pages.HomePage;
import testBase.BaseTest;
import utilities.ExtentReports.*;

public class TC03_VerifyErrorForInvalidDataInContactTest extends BaseTest {
    @Test
    public void VerifyErrorMsgForInvalidData(){
        ExtentTestManager.startTest("Invalid data error message","VerifyErrorMsgForInvalidData");
        ContactPage contactPage;
        HomePage homePage = new HomePage(driver);
        String invalidEmail = prop.getProperty("invalidEmail");

        contactPage = homePage.clickContact();
        contactPage.enterInvalidEmail(invalidEmail)
                   .verifyInvalidEmailMsg();
    }
}
