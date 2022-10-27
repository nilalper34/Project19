package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.io.IOException;


public class yaseminpgc {
 public yaseminpgc() throws IOException {

  PageFactory.initElements(Driver.getDriver(), this);
 }

 @FindBy(xpath = "(//*[text()='Sign In'])[1]")
 public WebElement ilkSign_inButonu;

 @FindBy(xpath = "(//input[@id='username'])[1]")
 public WebElement usurname;

 @FindBy(xpath = "//input[@id='password']")
 public WebElement password;
 @FindBy(xpath = "//button[@name='login']")
 public WebElement ikinciSign_inButonu;

 @FindBy(xpath = "//span[text()='Sign Out']")
 public WebElement sign_inOutButonu;

 @FindBy(xpath = "//p[text()='Orders']")
 public WebElement ordersButonu;

 @FindBy(xpath = "//p[text()='Addresses'] ")
 public WebElement addresesButonu;

 @FindBy(xpath = "//p[text()='Account details'] ")
 public WebElement AccountButonu;
 @FindBy(xpath = "//button[text()='Save changes']")
 public WebElement savechangeButonu;

 @FindBy(xpath = "//p[text()='Wishlist'] ")
 public WebElement WishlistButonu;

 @FindBy(xpath = "//p[text()='Logout'] ")
 public WebElement logoutButonu;

 @FindBy(xpath = "//p[text()='Downloads']")
 public WebElement downloandsButonu;

 @FindBy(xpath = "(//*[(text()='Login successful, redirecting...')])[1]")
 public WebElement successButton;

 @FindBy(xpath = "//*[text()='Account details changed successfully.']")
 public WebElement popMessage;

 @FindBy(xpath = "(//a[text()='View'])[1]")
 public WebElement viewButonu;

 @FindBy(xpath = "//div[*='No downloads available yet.']")
 public WebElement nodownloadsyazisi;

 @FindBy(xpath = "//font[text()='Fatura Adresinizi Düzenleyin']")
 public WebElement faturaadresiedit;

 @FindBy(xpath = "//a[text()='Edit Your Shipping Address']")
 public WebElement gönderimadresi;

 @FindBy(xpath = "//a[text()='Store Manager']")
 public WebElement storemanagermenu;
 @FindBy(xpath = "(//span[@class='text'])[7]")
 public WebElement customersMenu;
 @FindBy(xpath = "(//th[text()='Name'])[1]")
 public WebElement baslikname;

 @FindBy(xpath = "(//th[text()='Username'])[1]")
 public WebElement basliklastname;

 @FindBy(xpath = "(//th[text()='Email'])[1]")
 public WebElement baslikemail;

 @FindBy(xpath = "(//th[text()='Location'])[1]")
 public WebElement basliklocation;

 @FindBy(xpath = "(//th[text()='Orders'])[1]")
 public WebElement baslikorders;
 @FindBy(xpath = "(//th[text()='Money Spent'])[1]")
 public WebElement baslikmoneyspent;
 @FindBy(xpath = "(//th[text()='Last Order'])[1]")
 public WebElement basliklastorders;
 @FindBy(xpath = "(//th[text()='Actions'])[1]")
 public WebElement basliklactions;

 @FindBy(xpath = "//span[text()='Print']")
 public WebElement print;
 @FindBy(xpath = "//span[text()='PDF']")
 public WebElement pdf;
 @FindBy(xpath = "//span[text()='Excel']")
 public WebElement excel;
 @FindBy(xpath = "//span[text()='CSV']")
 public WebElement csv;

 @FindBy(xpath = "//span[text()='Add New']")
 public WebElement addnewbutonu;
 @FindBy(xpath = "//input[@id='user_name']")
 public WebElement addusurname;

 @FindBy(xpath = "(//span[@class='select2-selection__rendered'])[1]")
 public WebElement dropdowncountry;

 @FindBy(xpath = "//input[@id='wcfm_customer_submit_button']")
 public WebElement submit;
 @FindBy(xpath = "(//span[@class='text'])[11]")
 public WebElement followersMenu;
 @FindBy(xpath = "//td[text()='No data in the table']")
 public WebElement emptyfollowers;

 @FindBy(xpath = "//*[@id='bstate']")
 public WebElement stateddm;
 @FindBy(xpath = "//a[text()='dosya ismi']")
 public WebElement dosyaismi;
}