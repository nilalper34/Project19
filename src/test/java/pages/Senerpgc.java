package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Senerpgc {

    public Senerpgc() {
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "(//*[text()='Sign In'])[1]")
    public WebElement ilkSigninButonu;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement email;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@value='Sign In']")
    public WebElement ikinciSignInButton;

    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement signOut;

    @FindBy(xpath = "(//a[@href='https://hubcomfy.com/my-account-2/'])[1]")
    public WebElement myAccount;


    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement storeManagerButton;


    @FindBy(xpath = "//span[@class='wcfmfa fa-user-circle']")
    public WebElement customersButton;

    @FindBy(xpath = "//span[text()='Add New']")
    public WebElement addNewButton;

    @FindBy(xpath = "//input[@id='user_name']")
    public WebElement userNameKutucugu;

    @FindBy(xpath = "//select[@id='bstate']")
    public WebElement stateDDMIlk;

    @FindBy(xpath = "//*[@id='wcfm_customer_submit_button']")
    public WebElement ilkSubmitButton;


    @FindBy(xpath = "//*[@class='wcfm-message wcfm-success']")
    public WebElement successfullyYazisi;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement sameAsBillingKutucugu;

    @FindBy(xpath = "//select[@id='sstate']")
    public WebElement stateDDMIkinci;

    @FindBy(xpath = "(//span[@title='Turkey'])[2]")
    public WebElement countryDDMIkinci;

    @FindBy(xpath = "//span[@class='wcfmfa fa-retweet']")
    public WebElement refundButton;

    @FindBy(xpath = "//span[text()='# 5']")
    public WebElement requestId;


    @FindBy(xpath = "//a[text()='#14408']")
    public WebElement orderId;

    @FindBy(xpath = "//span[@class='woocommerce-Price-amount amount']")
    public WebElement amount;

    @FindBy(xpath = "//tbody//tr//td[5]")
    public WebElement type;

    @FindBy(xpath = "//tbody//tr//td[6]")
    public WebElement resaon;


    @FindBy(xpath = "//input[@id='bcity']")
    public WebElement ilkCityKutusu;

    @FindBy(xpath = "//input[@id='scity']")
    public WebElement ikinciCityKutusu;


}
