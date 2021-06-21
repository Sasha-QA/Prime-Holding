import helper.ContainerClass;
import helper.CucumberLocators;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import page.HomePage;
import page.PersonalInfoPage;
import page.SignInPage;

import java.io.IOException;

public class CucumberSignInTest extends BaseTest{

    private static WebDriver driver;
    public WebDriverWait waiter;
    CucumberLocators cucumber = new CucumberLocators();

    @Before
    public void setUp() throws IOException {
        driver = new ChromeDriver();
        waiter = new WebDriverWait(driver, 60);
        driver.manage().window().maximize();
    }

    @Given("customer already has an account on the site")
    public void haveAnAccount(){
      driver.findElement(cucumber.signInButton).click();
    }

    @When("customer enter valid email")
    public void enterEmail(){
        WebElement email = driver.findElement(cucumber.signInEMail);
        email.sendKeys(ContainerClass.EXSISTING_EMAIL);
    }

    @And("customer enter valid password")
    public void enterPassword(){
        WebElement password = driver.findElement(cucumber.signInPassword);
        password.sendKeys(ContainerClass.PASSWORD);
    }

    @Then("customer is successfully transfered to his account")
    public void successfullyLogedIn(){
        driver.findElement(cucumber.signIn).click();
        String actual = driver.findElement(cucumber.myAccount).getText();
        String expected = PersonalInfoPage.ACCOUNT_IS_MADE;
        Assert.assertTrue(actual.contains(expected), "Error!");
    }
}
