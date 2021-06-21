package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

    public WebDriver driver;

    private By signInButton = By.linkText("Sign in");
    private By signOutButton = By.linkText("Sign out");
    private By dresses = By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > header:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(6) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)");
    private By summerDresses = By.cssSelector("li[class='sfHover'] a[title='Summer Dresses']");
    private By contactUs = By.linkText("Contact us");
    public static final String HOMEPAGE_URL = "http://automationpractice.com/index.php";

   public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public SignInPage clickOnSignInButton() {
        driver.findElement(signInButton).click();
        return new SignInPage(driver);
    }

    public void clickOnSignOutButton() {
        driver.findElement(signOutButton).click();
    }

    public SummerDressesPage clickOnDresses() {
        Actions action = new Actions(driver);
        WebElement dress = driver.findElement(dresses);
        action.moveToElement(dress).moveToElement(driver.findElement(summerDresses)).click().build().perform();
        return new SummerDressesPage(driver);
    }

    public String getCurrentUrl() {
        String url = driver.getCurrentUrl();
        return url;
    }

    public ContactUsPage clickContactUsButton(){
        driver.findElement(contactUs).click();
        return new ContactUsPage(driver);
    }
}
