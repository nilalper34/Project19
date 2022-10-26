package tests.US_11;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

public class TC_003_WithMethods extends TestBaseRapor {
    public Abdullahpgc hub = new Abdullahpgc();
    public Actions actions = new Actions(Driver.getDriver());
    public SoftAssert softAssert = new SoftAssert();
    public Random random = new Random();
    public JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    public WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    public Faker faker = new Faker();

    @Test
    public void testCase003() throws InterruptedException {
        extentTest=extentReports.createTest("Pozitif Test","Minimum quantity");
        AbdullahReusableMethods.loginProductsPage();
        //Açilan sayfada aşağı kısımda bulunan menülerden  "Toptan Ürün Gösterme Ayarları" butonuna tıklanır
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();
        hub.toptanUGA.click();
        extentTest.info("Açilan sayfada aşağı kısımda bulunan menülerden  \"Toptan Ürün Gösterme Ayarları\" butonuna tıklandı");
        //Açılan sayfada "Min Order Quantity?" yazısının görünür olduğu test edilir
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(hub.minOrderQuantity));
        Assert.assertTrue(hub.minOrderQuantity.isDisplayed());
        extentTest.info("Açılan sayfada \"Min Order Quantity?\" yazısının görünür olduğu test edildi");
        // "Min Order Quantity?" alanının erişilebilir olduğu test edilir ve ilgili alana geçerli bir sayi girilir
        wait.until(ExpectedConditions.visibilityOf(hub.inputMinOrderQuantity));
        hub.inputMinOrderQuantity.isEnabled();
        hub.inputMinOrderQuantity.clear();
        hub.inputMinOrderQuantity.sendKeys(""+random.nextInt(100));
        extentTest.info("\"Min Order Quantity?\" alanının erişilebilir olduğu test edilir ve ilgili alana geçerli bir sayi girildi");
        AbdullahReusableMethods.validation();
    }
}
