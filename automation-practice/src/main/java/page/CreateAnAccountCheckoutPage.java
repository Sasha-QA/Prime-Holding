package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAnAccountCheckoutPage {

    public WebDriver driver;

    private By genderMrsBox = By.id("id_gender2");
    private By genderMrBox = By.id("id_gender1");
    private By firstNameField = By.name("customer_firstname");
    private By lastNameField = By.name("customer_lastname");
    private By passwordField = By.name("passwd");
    private By enterDay = By.name("days");
    private By enterMonth = By.name("months");
    private By enterYear = By.name("years");
    private By newsletter = By.id("newsletter");
    private By specialOffer = By.id("optin");
    private By getFirstNameAddress = By.id("firstname");
    private By getLastNameAddress = By.id("lastname");
    private By company = By.id("company");
    private By address = By.id("address1");
    private By address2 = By.id("address2");
    private By city = By.name("city");
    private By state = By.name("id_state");
    private By zipCode = By.name("postcode");
    private By country = By.id("id_country");
    private By additionalInfo = By.id("other");
    private By getHomePhone = By.id("phone");
    private By getMobilePhone = By.id("phone_mobile");
    private By alias = By.id("alias");
    private By registerButton = By.id("submitAccount");



    public CreateAnAccountCheckoutPage(WebDriver driver){
        this.driver=driver;
    }

    public void clickGenderBoxMr() {
        driver.findElement(genderMrBox).click();
    }

    public void clickGenderBoxMrs() {
        driver.findElement(genderMrsBox).click();
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void selectDay(String dayOfBirth) {
        Select day = new Select(driver.findElement(enterDay));
        day.selectByValue(dayOfBirth);
    }

    public void selectMonth(String dateOfMonth) {
        Select month = new Select(driver.findElement(enterMonth));
        month.selectByValue(dateOfMonth);
    }

    public void selectYear(String dateOfYear) {
        Select year = new Select(driver.findElement(enterYear));
        year.selectByValue(dateOfYear);
    }

    public void signForNewsletter() {
        driver.findElement(newsletter).click();
    }

    public void setSpecialOffer() {
        driver.findElement(specialOffer).click();
    }

    public void setFirstNameAddress(String firstNameAddress) {
        driver.findElement(getFirstNameAddress).sendKeys(firstNameAddress);
    }

    public void setLastNameAddress(String lastNameAddress) {
        driver.findElement(getLastNameAddress).sendKeys(lastNameAddress);
    }

    public void setCompany(String companyName) {
        driver.findElement(company).sendKeys(companyName);
    }

    public void setAddress1(String companyAddress) {
        driver.findElement(address).sendKeys(companyAddress);
    }

    public void setAddress2(String companyAddress2) {
        driver.findElement(address2).sendKeys(companyAddress2);
    }

    public void setCompanyCity(String companyCity) {
        driver.findElement(city).sendKeys(companyCity);
    }

    public void selectState(String setState) {
        Select theState = new Select(driver.findElement(state));
        theState.selectByValue(setState);
    }

    public void setZipCode(String postcode) {
        driver.findElement(zipCode).sendKeys(postcode);
    }

    public void selectCountry(String setCountry) {
        Select theCountry = new Select(driver.findElement(country));
        theCountry.selectByValue(setCountry);
    }

    public void setAdditionalInformation(String additionalInformation) {
        driver.findElement(additionalInfo).sendKeys(additionalInformation);
    }

    public void setHomePhone(String homePhone) {
        driver.findElement(getHomePhone).sendKeys(homePhone);
    }

    public void setMobilePhone(String mobilePhone) {
        driver.findElement(getMobilePhone).sendKeys(mobilePhone);
    }

    public void setAlias(String addAlias) {
        driver.findElement(alias).clear();
        driver.findElement(alias).sendKeys(addAlias);
    }

    public AddressCheckoutPage clickRegisterButton() {
        driver.findElement(registerButton).click();
        return new AddressCheckoutPage (driver);
    }

}
