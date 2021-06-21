package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddDressToCartPage {

    public WebDriver driver;

    private By colorGreen = By.id("color_15");
    private By previousPicture = By.linkText("Previous");
    private By nextPicture = By.linkText("Next");
    private By openPicture = By.id("view_full_size");
    private By closePicture = By.cssSelector("a[title='Close']");
    private By addToCart = By.name("Submit");
    private By continueShopping = By.className("continue btn btn-default button exclusive-medium");
    private By proceedCheckout = By.xpath("//span[normalize-space()='Proceed to checkout']");

    public AddDressToCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void seeNextPictures() {
        driver.findElement(nextPicture).click();
    }

    public void seePreviousPicture() {
        driver.findElement(previousPicture).click();
    }

    public void clickOpenPicture() {
        driver.findElement(openPicture).click();
    }

    public void closeOpenPicture() {
        driver.findElement(closePicture).click();
    }

    public void chooseColor() {
        driver.findElement(colorGreen).click();
    }

    public void setAddToCart() {
        driver.findElement(addToCart).click();
    }

    public SummaryCheckout clickContinueShopping(){
        driver.findElement(continueShopping).click();
        return new SummaryCheckout(driver);
    }

    public SummaryCheckout clickProceedCheckout() {
        driver.findElement(proceedCheckout).click();
        return new SummaryCheckout(driver);
    }

}
