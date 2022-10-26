package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RecepPage {
    public RecepPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement hubcSignIn;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement userEmail;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement userPassword;

    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement ikinciLogin;
    @FindBy(xpath = "(//*[text()='My Account'])[2]")
    public static WebElement myAccound;
    @FindBy(xpath = "(//*[text()='My Account'])[2]")
    public static WebElement myAccoundYazi;


    @FindBy(xpath = "//*[text()='Store Manager']")
    public static WebElement storManager;

    @FindBy(xpath = "(//*[text()='Store Manager'])[1]")
    public WebElement storManagerYazi;


    @FindBy(xpath = "//*[@class='wcfmfa fa-gift']")
    public WebElement coupons;

    @FindBy(xpath = "//*[@id='add_new_coupon_dashboard']")
    public WebElement addNew;

    @FindBy(xpath = "//*[@id='title']")
    public WebElement couponCode;

    @FindBy(xpath = "//*[@id='description']")
    public WebElement descriptionCode;

    @FindBy(xpath = "//*[@name='discount_type']")
    public WebElement discount_type;

    @FindBy(xpath = "//*[@id='coupon_amount']")
    public WebElement coupon_amount;

    @FindBy(xpath = "//*[@id='expiry_date']")
    public WebElement expiry_date;

    @FindBy(xpath = "//*[text()='19']")
    public WebElement date;

    @FindBy(xpath = "//*[@id='free_shipping']")
    public WebElement free_shipping;

    @FindBy(xpath = "//*[@id='show_on_store']")
    public WebElement show_on_store;
    @FindBy(xpath = "//*[@id='minimum_amount']")
    public WebElement minimum_amount;

    @FindBy(xpath = "//*[@id='maximum_amount']")
    public WebElement maximum_amount;

    @FindBy(xpath = "//*[@id='individual_use']")
    public WebElement individual_use;

    @FindBy(xpath = "//*[@id='exclude_sale_items']")
    public WebElement exclude_sale_items;

    @FindBy(xpath = "(//*[@class='select2-search__field'])[4]")
    public WebElement excludeCategories;

    @FindBy(xpath = "(//*[@class='select2-search__field'])[2]")
    public WebElement forMan;

    @FindBy(xpath = "//*[@id='coupons_manage_limit']")
    public WebElement limitButton;

    @FindBy(xpath = "//*[@id='usage_limit']")
    public WebElement usage_limit;

    @FindBy(xpath = "//*[@id='limit_usage_to_x_items']")
    public WebElement usageToItems;

    @FindBy(xpath = "//*[@id='usage_limit_per_user']")
    public WebElement limit_per_user;


}