package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SummerDressesPage {

    public WebDriver driver;

    private By chiffonDress = By.linkText("Printed Chiffon Dress");

    public SummerDressesPage(WebDriver driver) {
        this.driver = driver;
    }

    public AddDressToCartPage clickChiffonDress() {
        driver.findElement(chiffonDress).click();
        return new AddDressToCartPage(driver);
    }

}
