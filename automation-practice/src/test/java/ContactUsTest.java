import helper.ContainerClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.ContactUsPage;
import page.HomePage;

public class ContactUsTest extends BaseTest{

    @Test(priority = 0)
    public void testContactUs(){
        HomePage homePage = new HomePage(createWebDriver());
        ContactUsPage contactUs = homePage.clickContactUsButton();
        contactUs.selectSubjectHeading(ContainerClass.SUBJECT_HEADING);
        contactUs.setEmailAddress(ContainerClass.EXSISTING_EMAIL);
        contactUs.setOrderReference(ContainerClass.ORDER_REFERENCE);
        contactUs.setMessageField(ContainerClass.TEXT_MESSAGE);
        contactUs.clickSendButton();

        String actual = driver.findElement(contactUs.messageIsSent).getText();
        String expected = ContainerClass.MESSAGE_IS_SENT;
        Assert.assertTrue(actual.contains(expected), "Error!");
    }

   @Test(priority = 1)
    public void testBlankMessageInvalid(){
        HomePage homePage = new HomePage(createWebDriver());
        ContactUsPage contactUs = homePage.clickContactUsButton();
        contactUs.selectSubjectHeading(ContainerClass.SUBJECT_HEADING);
        contactUs.setEmailAddress(ContainerClass.EXSISTING_EMAIL);
        contactUs.setOrderReference(ContainerClass.ORDER_REFERENCE);
        contactUs.clickSendButton();

        String actual = driver.findElement(contactUs.errorBlankField).getText();
        String expected = ContainerClass.BLANK_MESSAGE;
        Assert.assertTrue(actual.contains(expected), "Error!");
    }

    @Test(priority = 2)
    public void testBlankSubjectInvalid(){
        HomePage homePage = new HomePage(createWebDriver());
        ContactUsPage contactUs = homePage.clickContactUsButton();
        contactUs.setEmailAddress(ContainerClass.EXSISTING_EMAIL);
        contactUs.setOrderReference(ContainerClass.ORDER_REFERENCE);
        contactUs.setMessageField(ContainerClass.TEXT_MESSAGE);
        contactUs.clickSendButton();

        String actual = driver.findElement(contactUs.errorChooseSubject).getText();
        String expected = ContainerClass.ERROR_MESSAGE;
        Assert.assertTrue(actual.contains(expected), "Error!");
    }

    @Test(priority = 3)
    public void testBlankEmailInvalid(){
        HomePage homePage = new HomePage(createWebDriver());
        ContactUsPage contactUs = homePage.clickContactUsButton();
        contactUs.selectSubjectHeading(ContainerClass.SUBJECT_HEADING);
        contactUs.setOrderReference(ContainerClass.ORDER_REFERENCE);
        contactUs.setMessageField(ContainerClass.TEXT_MESSAGE);
        contactUs.clickSendButton();

        String actual = driver.findElement(contactUs.errorBlankField).getText();
        String expected = ContainerClass.INVALID_EMAIL_ADDRESS;
        Assert.assertTrue(actual.contains(expected), "Error!");
    }
}
