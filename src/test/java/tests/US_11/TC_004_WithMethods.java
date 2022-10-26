package tests.US_11;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Abdullahpgc;
import utilities.AbdullahReusableMethods;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;
import java.util.Random;

public class TC_004_WithMethods extends TestBaseRapor {
    public Abdullahpgc hub = new Abdullahpgc();
    public Actions actions = new Actions(Driver.getDriver());
    public SoftAssert softAssert = new SoftAssert();
    public Random random = new Random();
    public JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    public WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    public Faker faker = new Faker();

    @Test
    public void testCase004() throws InterruptedException {
        extentTest=extentReports.createTest("Pozitif Test","Toptan urun gösterme ayarları");
        AbdullahReusableMethods.loginProductsPage();
        //Açilan sayfada aşağı kısımda bulunan menülerden  "Toptan Ürün Gösterme Ayarları" butonuna tıklanır
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();
        hub.toptanUGA.click();
        extentTest.info("Açilan sayfada aşağı kısımda bulunan menülerden  \"Toptan Ürün Gösterme Ayarları\" butonuna tıklandı");
        //Açılan sayfada "Piece Type" yazısının görünür olduğu test edilir
        wait.until(ExpectedConditions.visibilityOf(hub.pieceType));
        Assert.assertTrue(hub.pieceType.isDisplayed());
        extentTest.info("Açılan sayfada \"Piece Type\" yazısının görünür olduğu test edildi");
        //Açılan sayfada "Units Per Piece" yazısının görünür olduğu test edilir
        wait .until(ExpectedConditions.visibilityOf(hub.unitPerPiece));
        Assert.assertTrue(hub.unitPerPiece.isDisplayed());
        extentTest.info("Açılan sayfada \"Units Per Piece\" yazısının görünür olduğu test edildi");
        //Açılan sayfada "Min Order Quantity?" yazısının görünür olduğu test edilir
        wait.until(ExpectedConditions.visibilityOf(hub.minOrderQuantity));
        Assert.assertTrue(hub.minOrderQuantity.isDisplayed());
        extentTest.info("Açılan sayfada \"Min Order Quantity?\" yazısının görünür olduğu test edildi");
        //Piece Type drop-down menüsünden random bir seçenek belirlenir
        Select select = new Select(hub.dropDownPieceType);
        Thread.sleep(2000);
        int rastgeleSayi =random.nextInt(select.getOptions().size());
        System.out.println("select.getOptions().size() = " + select.getOptions().size());
        System.out.println("rastgeleSayi = " + rastgeleSayi);
        select.selectByIndex(rastgeleSayi);
        extentTest.info("Piece Type drop-down menüsünden random bir seçenek belirlendi");
        //Units Per Piece alanına geçerli bir değer girilir
        Thread.sleep(2000);
        hub.inputUnitPerPiece.clear();
        hub.inputUnitPerPiece.sendKeys(""+random.nextInt(100));
        extentTest.info("Units Per Piece alanına geçerli bir değer girildi");
        //Min Order Quantity alanına geçerli bir değer girilir
        Thread.sleep(2000);
        hub.inputMinOrderQuantity.clear();
        hub.inputMinOrderQuantity.sendKeys(""+random.nextInt(100));
        extentTest.info("Min Order Quantity alanına geçerli bir değer girildi");
        AbdullahReusableMethods.validation();
    }
}
