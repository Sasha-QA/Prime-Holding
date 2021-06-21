package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage {

    public WebDriver driver;

    private By fourthCheckout = By.cssSelector("button[name='processCarrier'] span");
    private By termsOfService = By.id("cgv");

    public ShippingPage(WebDriver driver) {
        this.driver=driver;
    }

    public void agreeToTermsOfService() {
        driver.findElement(termsOfService).click();
    }

    public PaymentPage clickFourthCheckout() {
        driver.findElement(fourthCheckout).click();
        return new PaymentPage(driver);
    }
}
