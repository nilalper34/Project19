package tests.US_09;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class TC_002_WithMethods extends TestBaseRapor {
    public Abdullahpgc hub = new Abdullahpgc();
    public Actions actions = new Actions(Driver.getDriver());
    public SoftAssert softAssert = new SoftAssert();
    public Random random = new Random();
    public JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    public WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    public Faker faker = new Faker();

    @Test
    public void testCase002() throws InterruptedException {
        extentTest=extentReports.createTest("Pozitif Test","Hacim belirlenmeli");
        AbdullahReusableMethods.loginProductsPage();
        //Açilan sayfada aşağı kısımda bulunan menülerden  "Shipping" butonuna tıklanır
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        hub.shipping.click();
        extentTest.info("Açilan sayfada aşağı kısımda bulunan menülerden  \"Shipping\" butonuna tıklandı");
        //Açılan sayfada "Hacim(volume,capacity)" yazılarının görürünür olduğu test edilir
        Thread.sleep(2000);
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("\"Hacim(volume,capacity)\""));
        extentTest.info("Açılan sayfada \"Hacim(volume,capacity)\" yazılarının görürünür olduğu test edildi");
        AbdullahReusableMethods.validation();
    }
}
