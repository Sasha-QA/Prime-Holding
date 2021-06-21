package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {

    public WebDriver driver;

    private By bankWire = By.className("bankwire");
    private By bankCheck = By.className("cheque");

    public PaymentPage(WebDriver driver){
        this.driver=driver;
    }

    public ConfirmOrderPage choosePayingByBankWire() {
        driver.findElement(bankWire).click();
        return new ConfirmOrderPage(driver);
    }

    public ConfirmOrderPage choosePayingByCheck() {
        driver.findElement(bankCheck).click();
        return new ConfirmOrderPage(driver);
    }

}
