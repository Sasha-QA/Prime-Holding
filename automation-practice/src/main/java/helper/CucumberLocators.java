package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class CucumberLocators {
    public By signInButton = By.linkText("Sign in");
    public By dresses = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a");
    public By signInEMail = By.id("email");
    public By signInPassword = By.name("passwd");
    public By signIn = By.name("SubmitLogin");
    public By myAccount = By.cssSelector("p[class='info-account']");
    public By summerDresses = By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/ul/li[3]/a");
    public By chiffonDress = By.linkText("Printed Chiffon Dress");
    public By addQuantity = By.className("icon-plus");
    public By addToCart = By.name("Submit");
    public By quantityNumber = By.name("quantity_7_34_0_0");
    public By proceedToCheckOut = By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a");
    public By orderDescription = By.linkText("Printed Chiffon Dress");
    public static final String ORDER = "Printed Chiffon Dress";
    public static final String NUMBER_OF_PRODUCT = "5";
    public static final String PRODUCT_CATEGORY = "http://automationpractice.com/index.php?id_category=11&controller=category";
    public static final String PRODUCT_PAGE = "http://automationpractice.com/index.php?id_product=7&controller=product";
}
