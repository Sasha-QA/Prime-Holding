import helper.ContainerClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

import java.awt.*;

public class CartTest extends BaseTest {
    private By shippingTermsAndServices = By.cssSelector("p[class='fancybox-error']");


    @Test(priority = 0)
    public void testBuyDressByBankWire() {
        HomePage homePage = new HomePage(createWebDriver());
        SummerDressesPage summerDressesPage = homePage.clickOnDresses();
        AddDressToCartPage addDress = summerDressesPage.clickChiffonDress();
        addDress.clickOpenPicture();
        addDress.closeOpenPicture();
        addDress.seeNextPictures();
        addDress.seePreviousPicture();
        addDress.setAddToCart();
        SummaryCheckout summaryCheckout = addDress.clickProceedCheckout();
        SignInCheckoutPage havingAccount = summaryCheckout.proceedToSecondCheckout();
        havingAccount.enterEmailToSignIn(ContainerClass.EXSISTING_EMAIL);
        havingAccount.enterPasswordToSignIn(ContainerClass.PASSWORD);
        AddressCheckoutPage addressCheckout = havingAccount.clickOnSignButton();
        ShippingPage shippingPage = addressCheckout.clickThirdCheckout();
        shippingPage.agreeToTermsOfService();
        PaymentPage paymentPage = shippingPage.clickFourthCheckout();
        ConfirmOrderPage confirmOrder = paymentPage.choosePayingByBankWire();
        confirmOrder.clickOnConfirmOrderButton();

        String actual = driver.findElement(confirmOrder.orderConfirmationMessageByBankWire).getText();
        Assert.assertTrue(actual.contains(ContainerClass.EXPECTED_MESSAGE), "Non-existing message");
    }

    @Test(priority = 1)
    public void testBuyDressByCheck() {
        HomePage homePage = new HomePage(createWebDriver());
        SummerDressesPage summerDressesPage = homePage.clickOnDresses();
        AddDressToCartPage addDress = summerDressesPage.clickChiffonDress();
        addDress.clickOpenPicture();
        addDress.closeOpenPicture();
        addDress.seeNextPictures();
        addDress.seePreviousPicture();
        addDress.setAddToCart();
        SummaryCheckout summaryCheckout = addDress.clickProceedCheckout();
        SignInCheckoutPage havingAccount = summaryCheckout.proceedToSecondCheckout();
        havingAccount.enterEmailToSignIn(ContainerClass.EXSISTING_EMAIL);
        havingAccount.enterPasswordToSignIn(ContainerClass.PASSWORD);
        AddressCheckoutPage addressCheckout = havingAccount.clickOnSignButton();
        ShippingPage shippingPage = addressCheckout.clickThirdCheckout();
        shippingPage.agreeToTermsOfService();
        PaymentPage paymentPage = shippingPage.clickFourthCheckout();
        ConfirmOrderPage confirmOrder = paymentPage.choosePayingByCheck();
        confirmOrder.clickOnConfirmOrderButton();

        String actual = driver.findElement(confirmOrder.orderConfirmationMessageByCheck).getText();
        Assert.assertTrue(actual.contains(ContainerClass.CHECK_MESSAGE), "Non-existing message");
    }

    @Test(priority = 2)
    public void testNotAgreeToTermsAndServices() {
        HomePage homePage = new HomePage(createWebDriver());
        SummerDressesPage summerDressesPage = homePage.clickOnDresses();
        AddDressToCartPage addDress = summerDressesPage.clickChiffonDress();
        addDress.clickOpenPicture();
        addDress.closeOpenPicture();
        addDress.seeNextPictures();
        addDress.seePreviousPicture();
        addDress.setAddToCart();
        SummaryCheckout summaryCheckout = addDress.clickProceedCheckout();
        SignInCheckoutPage havingAccount = summaryCheckout.proceedToSecondCheckout();
        havingAccount.enterEmailToSignIn(ContainerClass.EXSISTING_EMAIL);
        havingAccount.enterPasswordToSignIn(ContainerClass.PASSWORD);
        AddressCheckoutPage addressCheckout = havingAccount.clickOnSignButton();
        ShippingPage shippingPage = addressCheckout.clickThirdCheckout();
        PaymentPage paymentPage = shippingPage.clickFourthCheckout();

        String actual = driver.findElement(shippingTermsAndServices).getText();
        Assert.assertTrue(actual.contains(ContainerClass.TERMS_AND_SERVICE), "Error!");
    }

    @Test(priority = 3)
    public void testBuyDressWithCreatingAnAccount() {
        HomePage homePage = new HomePage(createWebDriver());
        SummerDressesPage summerDressesPage = homePage.clickOnDresses();
        AddDressToCartPage addDress = summerDressesPage.clickChiffonDress();
        addDress.clickOpenPicture();
        addDress.closeOpenPicture();
        addDress.seeNextPictures();
        addDress.seePreviousPicture();
        addDress.setAddToCart();
        SummaryCheckout summaryCheckout = addDress.clickProceedCheckout();
        SignInCheckoutPage signInStep = summaryCheckout.proceedToSecondCheckout();
        signInStep.enterEmailToCreateAnAccount(ContainerClass.VALID_EMAIL);
        CreateAnAccountCheckoutPage createAnAccount = signInStep.clickCreateAnAccountButton();
        createAnAccount.clickGenderBoxMr();
        createAnAccount.enterFirstName(ContainerClass.FIRST_NAME);
        createAnAccount.enterLastName(ContainerClass.LAST_NAME);
        createAnAccount.enterPassword(ContainerClass.PASSWORD);
        createAnAccount.selectDay(ContainerClass.DAY);
        createAnAccount.selectMonth(ContainerClass.MONTH);
        createAnAccount.selectYear(ContainerClass.YEAR);
        createAnAccount.signForNewsletter();
        createAnAccount.setSpecialOffer();
        createAnAccount.setFirstNameAddress(ContainerClass.FIRST_NAME);
        createAnAccount.setLastNameAddress(ContainerClass.LAST_NAME);
        createAnAccount.setAddress1(ContainerClass.ADDRESS1);
        createAnAccount.setAddress2(ContainerClass.ADDRESS2);
        createAnAccount.setCompany(ContainerClass.COMPANY);
        createAnAccount.setCompanyCity(ContainerClass.CITY);
        createAnAccount.selectState(ContainerClass.STATE);
        createAnAccount.setZipCode(ContainerClass.POSTCODE);
        createAnAccount.selectCountry(ContainerClass.COUNTRY);
        createAnAccount.setAdditionalInformation(ContainerClass.ADDITIONAL_INFO);
        createAnAccount.setHomePhone(ContainerClass.HOME_PHONE);
        createAnAccount.setMobilePhone(ContainerClass.MOBILE_PHONE);
        createAnAccount.setAlias(ContainerClass.ALIAS);
        createAnAccount.clickRegisterButton();
        AddressCheckoutPage addressCheckout = createAnAccount.clickRegisterButton();
        ShippingPage shippingPage = addressCheckout.clickThirdCheckout();
        shippingPage.agreeToTermsOfService();
        PaymentPage paymentPage = shippingPage.clickFourthCheckout();
        ConfirmOrderPage confirmOrder = paymentPage.choosePayingByCheck();
        confirmOrder.clickOnConfirmOrderButton();

        String actual = driver.findElement(confirmOrder.orderConfirmationMessageByCheck).getText();
        Assert.assertTrue(actual.contains(ContainerClass.CHECK_MESSAGE), "Non-existing message");
    }
}

