package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmOrderPage {

    public WebDriver driver;

    private By confirmOrderButton = By.cssSelector("button[class='button btn btn-default button-medium'] span");
    public By orderConfirmationMessageByBankWire = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > strong:nth-child(13)");
    public By orderConfirmationMessageByCheck = By.cssSelector("h3[class='page-subheading']");

    public ConfirmOrderPage(WebDriver driver){
        this.driver=driver;
    }

    public void clickOnConfirmOrderButton() {
        driver.findElement(confirmOrderButton).click();
    }

}
