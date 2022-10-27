package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Saadetpgc {

        public Saadetpgc(){

                PageFactory.initElements(Driver.getDriver(),this);
        }

        @FindBy(xpath = "//*[text()='Sign In']")
        public WebElement signin;

        @FindBy(xpath = "//*[@id='username']")
        public WebElement username;

        @FindBy(xpath = "//*[@id='password']")
        public WebElement password;

        @FindBy( xpath = "//*[@class='woocommerce-button button woocommerce-form-login__submit']")
        public WebElement signinButton;

        @FindBy(xpath = "//*[@id=\"menu-item-1079\"]/a")
        public WebElement myAccount;

        @FindBy(xpath = "//*[text()='Sign Out']")
        public WebElement signout;

        @FindBy(xpath = "//*[text()='Store Manager']")
        public WebElement storeManager;

        @FindBy(xpath = "//*[@class='wcfm_menu_items wcfm_menu_wcfm-products']")
        public WebElement products;

        @FindBy(xpath = "(//*[text()='Status'])[1]")
        public WebElement status;

        @FindBy(xpath = "(//*[text()='Stock'])[1]")
        public WebElement stock;

        @FindBy(xpath = "(//*[text()='Price'])[1]")
        public WebElement price;

        @FindBy(xpath = "(//*[text()='Date'])[1]")
        public WebElement date;

        @FindBy(xpath = "(//*[text()='Add New'])[1]")
        public WebElement addNewButton;

        @FindBy(xpath = "//input[@id='is_virtual']")
        public WebElement virtualClick;
        @FindBy(xpath = "(//*[text()='Virtual'])[1]")
        public WebElement virtualText;

        @FindBy(xpath = "//*[@id='is_downloadable']")
        public WebElement downloadableClick;

        @FindBy(xpath = "(//*[text()='Downloadable'])[1]")
        public WebElement downloadableText;

        @FindBy(xpath = "//*[@id='pro_title']")
        public WebElement productTitle;

        @FindBy(xpath = "(//*[text()='Sale Price ($)'])[1]")
        public WebElement salePrice;

        @FindBy(xpath = "//*[@id='featured_img_display']")
        public WebElement featuredDisplay;

        @FindBy(xpath = "//*[@id='menu-item-browse']")
        public WebElement mediaLibrary;

        @FindBy(xpath = "(//*[@class='thumbnail'])[1]")
        public WebElement resim1;

        @FindBy(xpath = "(//*[@class='thumbnail'])[10]")
        public WebElement resim2;

        @FindBy(xpath = "(//*[@class='thumbnail'])[1]")
        public WebElement bisikletResmi1;

        @FindBy(xpath = "(//*[@class='thumbnail'])[10]")
        public WebElement bisikletResmi2;

        @FindBy(xpath = "//*[text()='Select']")
        public WebElement selectButton;

        @FindBy(xpath = "//*[@id='gallery_img_gimage_0_display']")
        public WebElement galleryDisplay;

        @FindBy(xpath = "(//*[@class='button media-button button-primary button-large media-button-select'])[2]")
        public WebElement addToGallery;

        @FindBy(xpath = "//input[@id='wcfm_products_simple_submit_button']")
        public WebElement submitButton;

        @FindBy (xpath = "//*[@class='wcfm-message wcfm-success']")
        public WebElement successfullyMessage;

        @FindBy(xpath = "//*[@id=\"wcfm-products\"]/tbody/tr")
        public List<WebElement> urunIsimList;

        @FindBy(xpath = "(//*[text()='Short Description'])[1]")
        public WebElement shortDescriptionText;

        @FindBy(xpath = "//*[@id='excerpt_ifr']")  //iframe
        public WebElement shortDescriptionIframe;

        @FindBy(xpath = "(//*[@id='tinymce'])[1]")
        public WebElement shortDescriptionBox;

        @FindBy(xpath = "(//*[text()='Description'])[1]")
        public WebElement descritionText;

        @FindBy(xpath = "//*[@id='description_ifr']")  //iframe
        public WebElement descritionIframe;

        @FindBy(xpath = "//*[@id=\"tinymce\"]/p")
        public WebElement descritionBox;

        @FindBy(xpath = "//input[@value='433']")
        public WebElement bisikletBox;

        @FindBy(xpath = "//*[@class='product_cats_checklist_item checklist_item_413']")
        public WebElement besinTakviyeleriText;

        @FindBy(xpath = "//input[@value='413']")
        public WebElement besinTakviyeleriBox;

        @FindBy(xpath = "//*[@class='product_cats_checklist_item checklist_item_225']")
        public WebElement bestSellerText;

        @FindBy(xpath = "//input[@value='225']")
        public WebElement bestSellerBox;

        @FindBy(xpath = "//*[@class='product_cats_checklist_item checklist_item_230']")
        public WebElement electronicsText;

        @FindBy(xpath = "//input[@value='230']")
        public WebElement electronicsBox;

        @FindBy(xpath = "//*[@class='product_cats_checklist_item checklist_item_228']")
        public WebElement homeAndGardenText;

        @FindBy(xpath = "//input[@value='228']")
        public WebElement homeAndGardenBox;

        @FindBy(xpath = "//*[@id=\"product_cats_checklist\"]/li[31]/span[1]")
        public WebElement uncategorizedSekmesi;

        @FindBy(xpath = "//*[@class='product_cats_checklist_item checklist_item_440']")
        public WebElement indirimliUrunlerText;

        @FindBy(xpath = "//input[@value='440']")
        public WebElement indirimliUrunlerBox;

        @FindBy(xpath = "//*[@class='product_cats_checklist_item checklist_item_232']")
        public WebElement booksMusicFilmText;

        @FindBy(xpath = "//input[@value='232']")
        public WebElement booksMusicFilmBox;

        @FindBy(xpath = "(//span[@style='visibility: visible;'])[9]")
        public WebElement menSekmesi;

        @FindBy(xpath = "//*[@class='product_cats_checklist_item checklist_item_362']")
        public WebElement cosmeticText1;

        @FindBy(xpath = "//input[@value='362']")
        public WebElement cosmeticBox1;

        @FindBy(xpath = "(//span[@style='visibility: visible;'])[11]")
        public WebElement womenSekmesi;

        @FindBy(xpath = "//*[@class='product_cats_checklist_item checklist_item_358']")
        public WebElement cosmeticText2;

        @FindBy(xpath = "//input[@value='358']")
        public WebElement cosmeticBox2;

        @FindBy(xpath = "//*[@class='product_cats_checklist_item checklist_item_449']")
        public WebElement modaAndGiyimText;

        @FindBy(xpath = "//input[@value='449']")
        public WebElement modaAndGiyimBox;

        @FindBy(xpath = "//*[@class='product_cats_checklist_item checklist_item_233']")
        public WebElement toysAndGamesText;

        @FindBy(xpath = "//input[@value='233']")
        public WebElement toysAndGamesBox;

        @FindBy(xpath = "//*[@class='product_cats_checklist_item checklist_item_229']")
        public WebElement accessoriesText;

        @FindBy(xpath = "//input[@value='229']")
        public WebElement accessoriesBox;

        @FindBy(xpath = "//*[@class='product_cats_checklist_item checklist_item_226']")
        public WebElement newArrivalsText;

        @FindBy(xpath = "//input[@value='226']")
        public WebElement newArrivalsBox;

        @FindBy(xpath = "//*[@class='product_cats_checklist_item checklist_item_35']")
        public WebElement elegantAutoGroupText;

        @FindBy(xpath = "//input[@value='35']")
        public WebElement elegantAutoGroupBox;

        @FindBy(xpath = "//*[@class='product_cats_checklist_item checklist_item_41']")
        public WebElement greenGrassText;

        @FindBy(xpath = "//*[@id=\"product_brand\"]/li[16]/input")
        public WebElement greenGrassBox;


        @FindBy(xpath = "//*[@class='product_cats_checklist_item checklist_item_46']")
        public WebElement nodeJsText;

        @FindBy(xpath = "//*[@value='46']")
        public WebElement nodeJsBox;

        @FindBy(xpath = "//*[@class='product_cats_checklist_item checklist_item_47']")
        public WebElement nS8Text;

        @FindBy(xpath = "//*[@value='47']")
        public WebElement nS8Box;

        @FindBy(xpath = "//*[@class='product_cats_checklist_item checklist_item_50']")
        public WebElement redText;

        @FindBy(xpath = "//*[@value='50']")
        public WebElement redBox;

        @FindBy(xpath = "//*[@class='product_cats_checklist_item checklist_item_52']")
        public WebElement skySuiteTechText;

        @FindBy(xpath = "//*[@value='52']")
        public WebElement skySuiteTechBox;

        @FindBy(xpath = "//*[@class='product_cats_checklist_item checklist_item_55']")
        public WebElement sterlingText;

        @FindBy(xpath = "//*[@value='55']")
        public WebElement sterlingBox;

}

