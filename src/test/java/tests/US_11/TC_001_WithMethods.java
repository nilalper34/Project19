package tests.US_11;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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

public class TC_001_WithMethods extends TestBaseRapor {
    public Abdullahpgc hub = new Abdullahpgc();
    public Actions actions = new Actions(Driver.getDriver());
    public SoftAssert softAssert = new SoftAssert();
    public Random random = new Random();
    public JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    public WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    public Faker faker = new Faker();

    @Test
    public void testCase001() throws InterruptedException {
        extentTest=extentReports.createTest("Pozitif Test","Urun çeşidi");
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
        extentTest.info("Açılan sayfada \"Piece Type\" yazısının görünür olduğu test edilir");
        //Piece Type drop-down menüsünde "-Select-", "Piece", "Carton", "Kg" seçeneklerinin erişilebilir olduğu test edilir+
        Select select = new Select(hub.dropDownPieceType);
        for(WebElement w: select.getOptions()){
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOf(w));
            w.click();
            Assert.assertTrue(w.isDisplayed());
        }
        extentTest.info("Piece Type drop-down menüsünde \"-Select-\", \"Piece\", \"Carton\", \"Kg\" seçeneklerinin erişilebilir olduğu test edildi");
        AbdullahReusableMethods.validation();

    }
}
