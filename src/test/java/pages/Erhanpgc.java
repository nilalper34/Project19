package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Erhanpgc {
    public Erhanpgc() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[contains(text(),'Register')]")
    public WebElement registerButton;

    @FindBy(xpath = "//span[contains(text(),'Sign In')]")
    public WebElement signInButton;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement signInUserName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement signInPassword;


    @FindBy(xpath = "//button[@value='Sign In']")
    public WebElement confirmSignIn;





    @FindBy(xpath = "//input[@id='reg_username']")
    public WebElement registerUsername;

    @FindBy(xpath = "//input[@id='reg_email']")
    public WebElement registerEmail;

    @FindBy(xpath = "//input[@id='reg_password']")
    public WebElement registerPassword;

    @FindBy(xpath = "//a[@class='register_as_vendor']")
    public WebElement registerAsVendor;

    @FindBy(xpath = "//input[@id='user_email']")
    public WebElement vendorEmail;


    @FindBy(xpath = "//input[@name='wcfm_email_verified_input']")
    public WebElement vendorEmailMessage;

    @FindBy(xpath = "//input[@id='passoword']")
    public WebElement vendorPassword;

    @FindBy(xpath = "//input[@id='confirm_pwd']")
    public WebElement vendorConfirmPassword;


    @FindBy(xpath = "(//div//a[contains(@class,'banner-item elementor') and contains(text(),'Shop Now')])[2]")
   // @FindBy(linkText = "Shop Now")
    public WebElement shopNowLink;

    @FindBy(xpath = "//a[contains(text(),'My Account')]")
    public WebElement myAccountLink;

    @FindBy(xpath = "//a[contains(text(),'Orders')]")
    public WebElement ordersLink;

    @FindBy(xpath = "//a[contains(text(),'Browse products')]")
    public WebElement browseProductsLink;

    @FindBy(xpath = "//a[contains(text(),'Go Shop')]")
    public WebElement goShopButton;

    @FindBy(xpath = "//a[contains(text(),'Add to cart')]")
    public List<WebElement> avaliableItemsInStock;

    @FindBy(xpath = "//span[@class='cart-label']//span[contains(text(),'Cart')]")
    public WebElement cartLink;

    @FindBy(xpath = "//span[@class='cart-count']")
    public WebElement countOfItemsInCart;

    @FindBy(xpath = "//a[contains(text(),'View cart')]")
    public WebElement viewCartButton;

    @FindBy(xpath = "//td[@data-title='Price']//bdi")
    public List<WebElement> itemPriceTags;

    @FindBy(xpath = "//input[@class='input-text qty text']")
    public List<WebElement> itemAmounts;

    @FindBy(xpath = "//td[@data-title='Subtotal']//bdi")
    public List<WebElement> itemSubtotals;

    @FindBy(xpath = "//button[@title='Plus']")
    public List<WebElement> plusButtons;

    @FindBy(xpath = "//button[@title='Minus']")
    public List<WebElement> minusButtons;

    @FindBy(xpath = "(//button[@title='Minus'])[1]")
    public WebElement firstMinusButton;

    @FindBy(xpath = "//input[@type='number']")
    public List<WebElement> numberOfItems;

    @FindBy(xpath = "//button[@name='update_cart']")
    public WebElement updateCartButton;

    @FindBy(xpath = "//button[@name='clear_cart']")
    public WebElement clearCartButton;

    @FindBy(xpath = "//button[@name='apply_coupon']")
    public WebElement applyCouponButton;

    @FindBy(xpath = "//a[contains(@class,'continue-shopping')] ")
    public WebElement continueShoppingButton;

    @FindBy(xpath = "//p[@class='woocommerce-shipping-destination']")
    public WebElement cartShippingDestination;

    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
    public WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//input[@id='billing_city']")
    public WebElement billingCityBox;



    @FindBy(xpath = "//input[@id='billing_first_name']")
    public WebElement billingFirstNameBox;

    @FindBy(xpath = "//input[@id='billing_last_name_field']")
    public WebElement billingLastNameBox;

    @FindBy(xpath = "//div[@data-id='fc8fa76']")
    public WebElement homeDecorationLink;

}
