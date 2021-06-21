package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressCheckoutPage {

    public WebDriver driver;

    private By thirdCheckout = By.cssSelector("button[name='processAddress'] span");

    public AddressCheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public ShippingPage clickThirdCheckout() {
        driver.findElement(thirdCheckout).click();
        return new ShippingPage(driver);
    }

}
