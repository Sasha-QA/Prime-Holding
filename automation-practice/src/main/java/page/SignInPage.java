package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {

    public WebDriver driver;

    private By emailCreateAcc = By.id("email_create");
    private By createButton = By.id("SubmitCreate");
    private By signInEMail = By.id("email");
    private By signInPassword = By.name("passwd");
    private By signInButton = By.name("SubmitLogin");
    public By myAccount = By.cssSelector("p[class='info-account']");
    public By wrongCredential = By.cssSelector("div[class='alert alert-danger'] ol li");
    public static final String URL_SIGN_IN = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmailToCreateAccount(String email) {
        driver.findElement(emailCreateAcc).sendKeys(email);
    }

    public PersonalInfoPage clickOnCreateAccountButton() {
        driver.findElement(createButton).click();
        return new PersonalInfoPage(driver);
    }

    public void enterPasswordToSignIn(String password) {
        driver.findElement(signInPassword).sendKeys(password);
    }

    public void enterEmailToSignIn(String email) {
        driver.findElement(signInEMail).sendKeys(email);
    }

    public MyAccountPage clickOnSignInButton() {
        driver.findElement(signInButton).click();
        return new MyAccountPage(driver);
    }

    public String getCurrentUrl() {
        String url = driver.getCurrentUrl();
        return url;
    }

}
