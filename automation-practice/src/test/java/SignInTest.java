import helper.ContainerClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SignInPage;
import page.HomePage;
import page.MyAccountPage;
import page.PersonalInfoPage;

public class SignInTest extends BaseTest {

    @Test(priority = 0)
    public void testSignIn() {
        HomePage homePage = new HomePage(createWebDriver());
        SignInPage signInPage = homePage.clickOnSignInButton();
        signInPage.enterEmailToSignIn(ContainerClass.EXSISTING_EMAIL);
        signInPage.enterPasswordToSignIn(ContainerClass.PASSWORD);
        signInPage.clickOnSignInButton();

        String actual = driver.findElement(signInPage.myAccount).getText();
        String expected = PersonalInfoPage.ACCOUNT_IS_MADE;
        Assert.assertTrue(actual.contains(expected), "Error!");
    }

    @Test(priority = 3)
    public void signInInvalidPassword() {
        HomePage homePage = new HomePage(createWebDriver());
        SignInPage signInPage = homePage.clickOnSignInButton();
        signInPage.enterEmailToSignIn(ContainerClass.EXSISTING_EMAIL);
        signInPage.enterPasswordToSignIn(ContainerClass.WRONG_PASSWORD);
        signInPage.clickOnSignInButton();
        String actual = driver.findElement(signInPage.wrongCredential).getText();
        String expected = ContainerClass.AUTHENTIFICATION_FAILED;
        Assert.assertTrue(actual.contains(expected), "Error!");
    }

    @Test(priority = 4)
    public void signInInvalidEmail() {
        HomePage homePage = new HomePage(createWebDriver());
        SignInPage signInPage = homePage.clickOnSignInButton();
        signInPage.enterEmailToSignIn(ContainerClass.TYPO_IN_EMAIL2);
        signInPage.enterPasswordToSignIn(ContainerClass.PASSWORD);
        signInPage.clickOnSignInButton();
        String actual = driver.findElement(signInPage.wrongCredential).getText();
        String expected = ContainerClass.AUTHENTIFICATION_FAILED;
        Assert.assertTrue(actual.contains(expected), "Error!");
    }

    @Test(priority = 5)
    public void signOut(){
        HomePage homePage = new HomePage(createWebDriver());
        SignInPage signInPage = homePage.clickOnSignInButton();
        signInPage.enterEmailToSignIn(ContainerClass.EXSISTING_EMAIL);
        signInPage.enterPasswordToSignIn(ContainerClass.PASSWORD);
        MyAccountPage myAccount = signInPage.clickOnSignInButton();
        myAccount.clickOnSignOutButton();
        Assert.assertEquals(homePage.getCurrentUrl(), SignInPage.URL_SIGN_IN);
    }

    @Test(priority = 6)
    public void fromMyAccountToHomepage(){
        HomePage homePage = new HomePage(createWebDriver());
        SignInPage signInPage = homePage.clickOnSignInButton();
        signInPage.enterEmailToSignIn(ContainerClass.EXSISTING_EMAIL);
        signInPage.enterPasswordToSignIn(ContainerClass.PASSWORD);
        MyAccountPage myAccount = signInPage.clickOnSignInButton();
        myAccount.clickOnHomeButton();
        Assert.assertEquals(homePage.getCurrentUrl(), HomePage.HOMEPAGE_URL);
    }
}
