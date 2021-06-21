import helper.ContainerClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.PersonalInfoPage;
import page.SignInPage;

public class CreateAnAccountTest extends BaseTest{

    @Test(priority = 0)
    public void testCreateUser() {
        HomePage homePage = new HomePage(createWebDriver());
        SignInPage signInPage = homePage.clickOnSignInButton();
        signInPage.enterEmailToCreateAccount(ContainerClass.VALID_EMAIL);
        PersonalInfoPage personalInfoPage = signInPage.clickOnCreateAccountButton();
        personalInfoPage.clickGenderBoxMr();
        personalInfoPage.enterFirstName(ContainerClass.FIRST_NAME);
        personalInfoPage.enterLastName(ContainerClass.LAST_NAME);
        personalInfoPage.enterPassword(ContainerClass.PASSWORD);
        personalInfoPage.selectDay(ContainerClass.DAY);
        personalInfoPage.selectMonth(ContainerClass.MONTH);
        personalInfoPage.selectYear(ContainerClass.YEAR);
        personalInfoPage.signForNewsletter();
        personalInfoPage.setSpecialOffer();
        personalInfoPage.setFirstNameAddress(ContainerClass.FIRST_NAME);
        personalInfoPage.setLastNameAddress(ContainerClass.FIRST_NAME);
        personalInfoPage.setAddress1(ContainerClass.ADDRESS1);
        personalInfoPage.setAddress2(ContainerClass.ADDRESS2);
        personalInfoPage.setCompany(ContainerClass.COMPANY);
        personalInfoPage.setCompanyCity(ContainerClass.CITY);
        personalInfoPage.selectState(ContainerClass.STATE);
        personalInfoPage.setZipCode(ContainerClass.POSTCODE);
        personalInfoPage.selectCountry(ContainerClass.COUNTRY);
        personalInfoPage.setAdditionalInformation(ContainerClass.ADDITIONAL_INFO);
        personalInfoPage.setHomePhone(ContainerClass.HOME_PHONE);
        personalInfoPage.setMobilePhone(ContainerClass.MOBILE_PHONE);
        personalInfoPage.setAlias(ContainerClass.ALIAS);
        personalInfoPage.clickRegisterButton();

        String actual = driver.findElement(personalInfoPage.myAccount).getText();
        String expected = PersonalInfoPage.ACCOUNT_IS_MADE;
        Assert.assertTrue(actual.contains(expected), "Error!");
    }

    @Test(priority = 1)
    public void createUserInvalidEmail() {
        HomePage homePage = new HomePage(createWebDriver());
        SignInPage signInPage = homePage.clickOnSignInButton();
        signInPage.enterEmailToCreateAccount(ContainerClass.TYPO_IN_EMAIL);
        signInPage.clickOnCreateAccountButton();
        Assert.assertEquals(signInPage.getCurrentUrl(), SignInPage.URL_SIGN_IN);
    }

    @Test(priority = 1)
    public void createUserWithExistingEmail() {
        HomePage homePage = new HomePage(createWebDriver());
        SignInPage signInPage = homePage.clickOnSignInButton();
        signInPage.enterEmailToCreateAccount(ContainerClass.EXSISTING_EMAIL);
        signInPage.clickOnCreateAccountButton();
        Assert.assertEquals(signInPage.getCurrentUrl(), SignInPage.URL_SIGN_IN);
    }

}
