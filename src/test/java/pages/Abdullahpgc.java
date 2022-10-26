package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Abdullahpgc {
    public Abdullahpgc() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//span[text()='Sign In']")
    public WebElement SignIn;
    @FindBy(xpath = "//input[@id='username']")
    public WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;
    @FindBy(xpath = "//button[text()='Sign In']")
    public WebElement signInButton;
    @FindBy(xpath = "//a[text()='My Account']")
    public WebElement myAccount;

    @FindBy(xpath = "//a[text()='Store Manager']")
    public WebElement storeManager;

    @FindBy(xpath = "(//span[@class='wcfmfa fa-cube'])[1]")
    public WebElement products;

    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement> productsList;

    @FindBy(xpath = "//div[text()='Inventory']")
    public WebElement inventory;

    @FindBy(xpath = "//strong[text()='Manage Stock?']")
    public WebElement manageStock;

    @FindBy(xpath = "//input[@id='manage_stock']")
    public WebElement manageStockClickBox;
    @FindBy(xpath = "//input[@id='stock_qty']")
    public WebElement stockQtyInput;

    @FindBy(xpath = "//strong[text()='Stock Qty']")
    public WebElement stockQty;

    @FindBy(xpath = "//input[@id='wcfm_products_simple_submit_button' and @class='wcfm_submit_button']")
    public WebElement submitButton;

    @FindBy(xpath = "(//*[contains(text(),'Product Successfully Published.')])[1]")
    public WebElement successButton;

    @FindBy(xpath = "//*[@class='wcfm-message wcfm-success']")
    public WebElement successButton1;

    @FindBy(xpath = "//strong[.='Allow Backorders?'] ")
    public WebElement allowBackOrders;

    @FindBy(xpath = "//select[@id='backorders']")
    public WebElement dropDownBackOrders;

    //"(//div[@class='page_collapsible_content_holder'])[4]"
    @FindBy(xpath = "//div[text()='Shipping']")
    public WebElement shipping;

    @FindBy(xpath = "//p[@class='weight wcfm_title']")
    public WebElement weight;

    @FindBy(xpath = "//p[@class='length wcfm_title']")
    public WebElement dimensions;
    @FindBy(xpath = "//input[@id='weight']")
    public WebElement weightInput;
    @FindBy(xpath = "//input[@id='length']")
    public WebElement lengthInput;
    @FindBy(xpath = "//input[@id='width']")
    public WebElement widthInput;
    @FindBy(xpath = "//input[@id='height'] ")
    public WebElement heightInput;

    @FindBy(css = "p[class='_wcfmmp_processing_time wcfm_title']")
    public WebElement processingTime;

    @FindBy(css = "#_wcfmmp_processing_time")
    public WebElement processingTimeDropDown;

    @FindBy(xpath = "(//div[@class='page_collapsible_content_holder'])[5]")
    public WebElement attributes;

    @FindBy(xpath = "//strong[.='Color']")
    public WebElement color;

    @FindBy(xpath = "//strong[.='Size']")
    public WebElement size;

    @FindBy(id = "attributes_is_active_1")
    public WebElement colorCheckBox;

    @FindBy(xpath = "(//button[text()='Select all'])[1]")
    public WebElement colorSelectAll;

    @FindBy(id = "attributes_is_active_2")
    public WebElement sizeCheckBox;

    @FindBy(xpath = "(//button[text()='Select all'])[2]")
    public WebElement sizeSelectAll;

    @FindBy(xpath = "(//ul)[25]/li")
    public List<WebElement> colorList;


    @FindBy(xpath = "(//ul)[26]/li")
    public List<WebElement> sizeList;

    @FindBy(id = "wcfm_products_manage_form_toptan-urun-gosterme-ayarlari_head")
    public WebElement toptanUGA;
    @FindBy(xpath = "//p[@class='piecetype wcfm_title field_61d331d8dc5a9']")
    public WebElement pieceType;
    @FindBy(xpath = "//p[@class='unitpercart wcfm_title field_61d33933d88bd']")
    public WebElement unitPerPiece;
    @FindBy(xpath = "//p[@class='minorderqtytr wcfm_title field_61d33a93da83d']")
    public WebElement minOrderQuantity;
    @FindBy(xpath = "//select[@id='piecetype']")
    public WebElement dropDownPieceType;
    @FindBy(xpath = "//input[@id='unitpercart']")
    public WebElement inputUnitPerPiece;
     @FindBy(xpath = "//input[@id='minorderqtytr']")
    public WebElement inputMinOrderQuantity;


}
