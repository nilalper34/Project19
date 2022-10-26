package tests.US_08;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
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
        extentTest=extentReports.createTest("Pozitif Test","Geçerli  bir stok miktari belirlenir");
        AbdullahReusableMethods.loginProductsPage();
        // Açilan sayfada aşağı kısımda bulunan menülerden  "Inventory" butonuna tıklanır
        Thread.sleep(2000);
        jse.executeScript("arguments[0].scrollIntoView(true);", hub.inventory);
        jse.executeScript("arguments[0].click();", hub.inventory);
        extentTest.info("Açilan sayfada aşağı kısımda bulunan menülerden  \"Inventory\" butonuna tıklandı");

        // Açılan sayfada "Manage Stock?"  yazısının görürünür olduğu test edilir
        Thread.sleep(2000);
        Assert.assertTrue(hub.manageStock.isDisplayed());
        extentTest.info("Açılan sayfada \"Manage Stock?\"  yazısının görürünür olduğu test edildi");
        // Manage Stock?  check box'ına tıklanır
        Thread.sleep(2000);
        if (!hub.manageStockClickBox.isSelected())
            hub.manageStockClickBox.click();
        extentTest.info("Manage Stock?  check box'ına tıklandı");
        // Açılan kısımda "Stock Qty" yazısının görünür olduğunu test edilir.
        Assert.assertTrue(hub.stockQty.isDisplayed());
        extentTest.info("Açılan kısımda \"Stock Qty\" yazısının görünür olduğunu test edildi");
        // Stock Qty alanına geçerli bir stok miktari girilir
        Thread.sleep(2000);
        hub.stockQtyInput.clear();
        hub.stockQtyInput.sendKeys("" + random.nextInt(100) );
        extentTest.info("Stock Qty alanına geçerli bir stok miktari girilir");

        AbdullahReusableMethods.validation();

    }
}
