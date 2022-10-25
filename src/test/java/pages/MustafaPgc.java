package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class MustafaPgc {

    public MustafaPgc() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//span[text()='Register']")
    public WebElement register;

    @FindBy (xpath = "//a[text()='Become a Vendor']")
    public WebElement becomeAVendor;

    @FindBy (xpath = "(//*[text()='Vendor Registration'])[1]")
    public WebElement vendorRegistrationYazisi;

    @FindBy (xpath = "(//*[text()='Email'])[1]")
    public WebElement emailYazisi;

    @FindBy (xpath = "//input[@id='user_email']")
    public WebElement emailKutusu;

    @FindBy (xpath = "(//*[text()='Password'])[1]")
    public WebElement passwordYazisi;

    @FindBy (xpath = "//input[@id='passoword']")
    public WebElement passwordKutusu;

    @FindBy (xpath = "(//*[text()='Confirm Password'])[1]")
    public WebElement confirmPasswordYazisi;

    @FindBy (xpath = "//input[@id='confirm_pwd']")
    public WebElement confirmPasswordKutusu;

    @FindBy (xpath = "//input[@class='wcfm_submit_button']")
    public WebElement register2Buton;

    @FindBy (xpath = "//*[@class='wcfm-message wcfm-error']")
    public WebElement emailGerekliYazisiilk;

    @FindBy (xpath = "//*[contains(text(),'Email: This field is required.')]")
    public WebElement emailGerekliYazisi;

    @FindBy (xpath = "//*[text()='Welcome to Hubcomfy!']")
    public WebElement welcomeToHubcomfyText;

    @FindBy (xpath = "//*[text()='Sign In']")
    public WebElement signIn;

    @FindBy (xpath = "//*[@id='username']")
    public WebElement signInUsername;

    @FindBy (xpath = "//*[@id='password']")
    public WebElement signInPassword;

    @FindBy (xpath = "//*[@name='login']")
    public WebElement signIn2butonu;

    @FindBy (xpath = "(//*[@class='w-icon-account'])[1]")
    public WebElement myAccountSimge;

    @FindBy (xpath = "//a[text()='My Account']")
    public WebElement myAccountButton;

    @FindBy (xpath = "//*[@class='page-title']")
    public WebElement myAccountYazisi;


//Verification
    @FindBy (xpath = "//div[@class='email']")
    public WebElement verificationEmail;

    @FindBy (xpath = "//input[@placeholder='Verification Code']")
    public WebElement verificationCodeKutusu;

    @FindBy (xpath = "(//*[@class='subject'])[1]")
    public WebElement tempMailBox;

    @FindBy (css = "(div>#read>div>iframe")
    public WebElement iframe;

    @FindBy (xpath = "//*[@id='body_content_inner']")
    public WebElement tempVCodeText;

    @FindBy (xpath = "//span[@class='icon-box-icon icon-orders']")
    public WebElement orders;

    @FindBy (xpath = "//span[@class='icon-box-icon icon-downloads']")
    public WebElement downloads;

    @FindBy (xpath = "//span[@class='icon-box-icon icon-addresses']")
    public WebElement addresses;

    @FindBy (xpath = "//span[@class='icon-box-icon icon-account']")
    public WebElement accountDetails;

    @FindBy (xpath = "//span[@class='icon-box-icon icon-wishlist']")
    public WebElement wishlist;

    @FindBy (xpath = "//span[@class='icon-box-icon icon-logout']")
    public WebElement logout;

    @FindBy (xpath = "//a[text()='Dashboard']")
    public WebElement dashboardMenu;

    @FindBy (xpath = "//a[text()='Store Manager']")
    public WebElement storeManagerMenu;

    @FindBy (xpath = "//a[text()='Orders']")
    public WebElement ordersMenu;

    @FindBy (xpath = "//a[text()='Downloads']")
    public WebElement downloadsMenu;

    @FindBy (xpath = "//a[text()='Addresses']")
    public WebElement addressesMenu;

    @FindBy (xpath = "//a[text()='Account details']")
    public WebElement accountDetailsMenu;

    @FindBy (xpath = "//li")
    public List<WebElement> menuListWE;

    @FindBy (xpath = "(//a[text()='Wishlist'])[1]")
    public WebElement wishlistMenu;

    @FindBy (xpath = "//*[text()='Support Tickets']")
    public WebElement supportTicketMenu;

    @FindBy (xpath = "//*[text()='Followings']")
    public WebElement followingsMenu;

    @FindBy (xpath = "(//*[text()='Logout'])[1]")
    public WebElement logoutMenu;

    @FindBy (xpath = "(//a[text()='Trending'])[1]")
    public WebElement trendingKategori;

    @FindBy (xpath = "(//a[text()='New Arrivals'])[1]")
    public WebElement newArrivalsKategori;

    @FindBy (xpath = "(//a[text()='Best Seller'])[1]")
    public WebElement bestSellerKategori;

    @FindBy (xpath = "//a[@href='/product-category/trending/'][contains(text(),'See all')]")
    public WebElement trendingTumunuGor;

    @FindBy (xpath = "//a[@href='/product-category/new-arrivals/'][contains(text(),'See all')]")
    public WebElement newArrivalsTumunuGor;

    @FindBy (xpath = "//a[@href='/product-category/best-seller/'][contains(text(),'See all')]")
    public WebElement BestSellerTumunuGor;

    @FindBy (xpath = "//a[text()='Home']")
    public WebElement anaSayfa;

    @FindBy (xpath = "//select[@name='orderby']")
    public WebElement dropDownMenu;

    @FindBy (xpath = "(//a[text()='Shop Now'])[2]")
    public WebElement shopNowButonu;


    @FindBy (xpath = "//*[text()='Registration Successfully Completed.']")                  //test07
    public WebElement registrationCompletedYazisi;

    @FindBy (xpath = "//div[text()='Password and Confirm-password are not same.']")         //test08
    public WebElement passwordNotSameYazisi;

    @FindBy (xpath = "//*[contains(text(),'Email Verification Code: This field is required.')]")    //test10
    public WebElement verificationCodeGerekliYazisi;

    @FindBy (xpath = "//span[@class='price']")
    public List<WebElement> urunFiyatLowToHighListWE;    // urunFiyatHighToLowListWE

    @FindBy (xpath = "//span[@class='price']")
    public List<WebElement> urunFiyatHighToLowListWE;


// yahooo mail
    @FindBy (xpath = "//input[@id='login-username']")
    public WebElement yahooUsernameBox;

    @FindBy (xpath = "//input[@id='login-passwd']")
    public WebElement yahooPasswordBox;

    @FindBy (xpath = "")
    public WebElement a5;

    @FindBy (xpath = "//b")
    public WebElement yahooCode;

    @FindBy (xpath = "//span[@class='_yb_pc490 _yb_1u1la']")
    public WebElement yahooMailSimge;

    @FindBy (xpath = "/html[1]/body[1]/header[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/p[1]")
    public WebElement yahooSonGelenMail;

    @FindBy (xpath = "//div[@class='wcfm-message wcfm-error']")
    public WebElement emailExistsError;

}
