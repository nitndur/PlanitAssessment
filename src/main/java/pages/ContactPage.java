package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ContactPage extends BasePage {
    private  WebDriver driver;

    By submitButton = By.linkText("Submit");
    By forename_err = By.id("forename-err");
    By email_err = By.id("email-err");
    By msg_err = By.id("message-err");
    By header_alert = By.cssSelector(".alert");
    By fName_input = By.id("forename");
    By email_input = By.id("email");
    By msg_input = By.id("message");
    By backButton = By.partialLinkText("Back");

    public ContactPage(WebDriver driver){
        super(driver);
        //this.driver = driver;
    }

    public ContactPage clickSubmit(){
        click(submitButton);
        return this;
    }
    public ContactPage verifyMissingMandatoryFieldErrors(){
        Assert.assertTrue(GetText(header_alert).equals("We welcome your feedback - but we won't get it unless you complete the form correctly."),"Error message is not displayed in header alert");
        Assert.assertTrue(GetText(forename_err).equals("Forename is required"),"Forename error message is not displayed");
        Assert.assertTrue(GetText(email_err).equals("Email is required"),"Email error message is not displayed");
        Assert.assertTrue(GetText(msg_err).equals("Message is required"),"Message error message is not displayed");
        return this;
    }

    public ContactPage enterMandatoryFields(String name, String email, String msg){
        enterText(fName_input,name);
        enterText(email_input,email);
        enterText(msg_input,msg);
        return this;
    }

    public void verifyErrorMsgDisappear() {
        Assert.assertFalse(IsElementDisplayed(forename_err),"Forename validation error is still displayed");
        Assert.assertFalse(IsElementDisplayed(email_err),"Email validation error is still displayed");
        Assert.assertFalse(IsElementDisplayed(msg_err),"Message validation error is still displayed");
        Assert.assertTrue(GetText(header_alert).equals("We welcome your feedback - tell it how it is."),"Error message is still displayed in header alert");
    }

    public void verifySuccessMessage(String name){
        String expectedText="Thanks "+name+", we appreciate your feedback.";
        waitForElement(backButton);
         Assert.assertTrue(GetText(header_alert).equals(expectedText),"Contact successfully submitted");
    }
  public ContactPage enterInvalidEmail(String text){
        enterText(email_input,text);
        return this;
  }
  public void verifyInvalidEmailMsg(){
      Assert.assertTrue(GetText(header_alert).equals("We welcome your feedback - but we won't get it unless you complete the form correctly."),"Error message is not displayed in header alert");
        Assert.assertTrue(GetText(email_err).equals("Please enter a valid email"),"Invalid email error message is not displayed");
  }

}
