package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {

    public WebDriver driver;

    public By subjectHeading = By.id("id_contact");
    public By emailAddress = By.name("from");
    public By orderReference = By.name("id_order");
    public By messageField = By.id("message");
    public By sendButton = By.cssSelector("#submitMessage");
    public By errorBlankField = By.cssSelector("div[class='alert alert-danger'] ol li");
    public By errorChooseSubject = By.cssSelector("div[class='alert alert-danger'] p");
    public By messageIsSent = By.cssSelector("p[class='alert alert-success']");

    public ContactUsPage(WebDriver driver){
        this.driver=driver;
    }

     public void selectSubjectHeading(String heading){
        Select subject = new Select(driver.findElement(subjectHeading));
        subject.selectByValue(heading);
    }

    public void setEmailAddress(String email){
        driver.findElement(emailAddress).sendKeys(email);
    }

    public void setOrderReference(String reference){
        driver.findElement(orderReference).sendKeys(reference);
    }

    public void setMessageField(String messageText){
        driver.findElement(messageField).sendKeys(messageText);
    }

    public void clickSendButton(){
        driver.findElement(sendButton).click();
    }
}
