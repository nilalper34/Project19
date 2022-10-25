package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Ahmetpgc {

    public Ahmetpgc(){
        PageFactory.initElements(Driver.getDriver(),this);


    }
    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement ilkSigIn;

    @FindBy (xpath = "//*[@id='username']")
    public WebElement gmail;

    @FindBy (xpath = "//*[text()='Sign Out']")
    public WebElement signOut;

    @FindBy (xpath = "//*[text()='Store Manager']")
    public WebElement storeManager;

    @FindBy (xpath = "(//*[@class='wcfm_menu_item '])[13]")
    public WebElement reports;

    @FindBy (xpath = "//*[text()='Sales by date']")
    public WebElement salesByDate;

    @FindBy (xpath = "//*[text()='Year']")
    public WebElement yearButonu;

    @FindBy (xpath = "//*[@class='chart-sidebar']")
    public WebElement tablo;

    @FindBy (xpath = "(//*[@class='main'])[2]")
    public WebElement grafik;

    @FindBy (xpath = "//*[text()='Last Month']")
    public WebElement lastMonth;

    @FindBy (xpath = "(//*[text()='This Month'])[1]")
    public WebElement thisMonth;

    @FindBy (xpath = "//*[text()='Last 7 Days']")
    public WebElement last7Days;

    @FindBy (xpath = "//*[@type='text']")
    public WebElement custom;

    @FindBy (xpath = "(//*[text()='3'])[2]")
    public WebElement ilkTarih;

    @FindBy (xpath = "(//*[text()='9'])[2]")
    public WebElement sonTarih;

    @FindBy (xpath = "//*[text()='Sales by product']")
    public WebElement salesByProduct;

    @FindBy (xpath = "(//*[text()='Mathilda Aksesuar Güneş Gözlüğü 3lü Set kemiksetgozluk'])[1]")
    public WebElement urun;

}
