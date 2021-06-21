import helper.ContainerClass;
import helper.CucumberLocators;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import page.HomePage;
import page.SummerDressesPage;

import java.io.IOException;

public class CucumberBuyDresses{

    private static WebDriver driver;
    public WebDriverWait waiter;
    CucumberLocators cucumber = new CucumberLocators();

        @Before
        public void setUp() throws IOException {
            driver = new ChromeDriver();
            waiter = new WebDriverWait(driver, 60);
            driver.manage().window().maximize();
        }

        @Given("open Automation Practice homepage")
        public void openHomePage(){
            driver.navigate().to(ContainerClass.HOMEPAGE_URL);
        }

        @When("customer choose Summer dresses category from Dresses category")
        public void openSummerDresses(){
            Actions action = new Actions(driver);
            WebElement dress = driver.findElement(cucumber.dresses);
            action.moveToElement(dress).moveToElement(driver.findElement(cucumber.summerDresses)).click().build().perform();
        }

        @Then("webpage with Summer dresses opens up")
        public void verifySummerDresses () {
            Assert.assertEquals(driver.getCurrentUrl(), cucumber.PRODUCT_CATEGORY);
        }

        @When("clicking on Printed Chiffon dress")
        public void clickOnProduct () {
            driver.findElement(cucumber.chiffonDress).click();
        }

        @Then("webpage with clicked product is open")
        public void isProductOpen () {
            Assert.assertEquals(driver.getCurrentUrl(), cucumber.PRODUCT_PAGE);
        }

        @When("adding 4 more dresses to the cart")
        public void addFiveDresses () {
            for (int i = 0; i < 4; i++) {
                driver.findElement(cucumber.addQuantity).click();
            }
            driver.findElement(cucumber.addToCart).click();
        }

        @And("customers click on Proceed to checkout button")
        public void clickOnProceedToCheckoutButton () {
            driver.findElement(cucumber.proceedToCheckOut).click();
        }

        @Then("webpage with cart and 5 dresses in it opens up")
        public void verifyProductsInTheCart () {
            String product = driver.findElement(cucumber.orderDescription).getText();
            String quantity = driver.findElement(cucumber.quantityNumber).getText();
            Assert.assertTrue(product.contains(cucumber.ORDER), "Error!");
            Assert.assertTrue(quantity.contains(cucumber.NUMBER_OF_PRODUCT), "Error!");
        }
    }
