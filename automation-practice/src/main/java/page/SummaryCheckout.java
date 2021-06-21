package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SummaryCheckout {

    public WebDriver driver;

    private By secondCheckout = By.cssSelector("a[class='button btn btn-default standard-checkout button-medium'] span");

    public SummaryCheckout(WebDriver driver){
        this.driver=driver;
    }

    public SignInCheckoutPage proceedToSecondCheckout() {
       driver.findElement(secondCheckout).click();
        return new SignInCheckoutPage(driver);
    }
}
