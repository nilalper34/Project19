package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class hayrullahpgc {

    public hayrullahpgc() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='Sign In']")
    public WebElement singInButtonMainPage;

    @FindBy(id = "username")
    public WebElement userNameBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordBox;

    @FindBy(name = "login")
    public WebElement getSingInButtonLogIn;

    @FindBy(xpath = "//span[.='Sign Out']")
    public WebElement signOutButton;

    @FindBy(xpath = "//a[text()='My Account']")
    public WebElement myAccount;

    @FindBy(xpath = "//a[.='Store Manager']")
    public WebElement storeManeger;

    @FindBy(xpath = "//a[@href='https://hubcomfy.com/store-manager/reviews/']")
    public WebElement reviews;

    @FindBy(xpath = "//span[.='Product Reviews']")
    public WebElement productReviews;

    @FindBy(xpath = "(//tr//th)[2]")
    public WebElement author;

    @FindBy(xpath = "(//tr//th)[3]")
    public WebElement comment;

    @FindBy(xpath = "(//tr//th)[4]")
    public WebElement rating;

    @FindBy(xpath = "(//tr//th)[6]")
    public WebElement dated;

    @FindBy(xpath = "//a[.='Orders']")
    public WebElement orders;

    @FindBy(xpath = "//a[@class='woocommerce-Button button btn btn-link btn-underline btn-icon-right']")
    public WebElement browseProducts;

    @FindBy(xpath = "//a[.='Sign Out']")
    public WebElement signinOutButton;

    @FindBy(xpath = "(//span[@class='text'])[4]")
    public WebElement products;

    @FindBy(xpath = "//span[.='Add New']")
    public WebElement addNewProduct;

    @FindBy(id = "is_virtual")
    public WebElement virtualCheckbox;

    @FindBy(id = "is_downloadable")
    public WebElement downloadableCheckbox;

    @FindBy(id = "pro_title")
    public WebElement productTitleTextBox;

    @FindBy(id = "sale_price")
    public WebElement salePrinceTextBox;

    @FindBy(xpath = "//li[@class='product-wrap']")
    public List<WebElement> allProducts;

    @FindBy(name = "add-to-cart")
    public WebElement add2Cart;

    @FindBy(xpath = "(//i[@class='w-icon-cart'])[1]")
    public WebElement sepet;

    @FindBy(xpath = "//a[@class='button checkout wc-forward']")
    public WebElement checkout;

    @FindBy(xpath = "(//span[@role='textbox'])[1]")
    public WebElement countryDropDown;

    @FindBy(id = "billing_company")
    public WebElement companyNameBox;

    @FindBy(id = "billing_first_name")
    public WebElement firstName;

    @FindBy(id = "billing_last_name")
    public WebElement lastName;

    @FindBy(xpath = "//button[@id='place_order']")
    public WebElement placeOrder;


}
