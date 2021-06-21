package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {

    public WebDriver driver;

    private By signOut = By.linkText("Sign out");
    private By myAccount = By.cssSelector("a[title='View my customer account'] span");
    private By homeButton = By.cssSelector("a[title='Home']");

    public MyAccountPage(WebDriver driver){
        this.driver=driver;
    }

    public void clickOnSignOutButton(){
        driver.findElement(signOut).click();
    }

    public void clickOnHomeButton(){
        driver.findElement(homeButton).click();
    }

}
