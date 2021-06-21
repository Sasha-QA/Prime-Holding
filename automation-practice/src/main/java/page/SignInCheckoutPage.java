package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInCheckoutPage {

    public WebDriver driver;

    private By signInEMail = By.id("email");
    private By signInPassword = By.name("passwd");
    private By signInButton = By.name("SubmitLogin");
    private By createAnAccountEmail = By.id("email_create");
    private By createAnAccountButton = By.cssSelector("button[id='SubmitCreate'] span");

    public SignInCheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterPasswordToSignIn(String password) {
        driver.findElement(signInPassword).sendKeys(password);
    }

    public void enterEmailToSignIn(String email) {
        driver.findElement(signInEMail).sendKeys(email);
    }

    public AddressCheckoutPage clickOnSignButton() {
        driver.findElement(signInButton).click();
        return new AddressCheckoutPage(driver);
    }

    public void enterEmailToCreateAnAccount(String email) {
        driver.findElement(createAnAccountEmail).sendKeys(email);
    }

    public CreateAnAccountCheckoutPage clickCreateAnAccountButton(){
        driver.findElement(createAnAccountButton).click();
        return new CreateAnAccountCheckoutPage(driver);
    }


}
