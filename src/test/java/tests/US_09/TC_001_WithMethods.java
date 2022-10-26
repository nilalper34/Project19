package tests.US_09;

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
        extentTest=extentReports.createTest("Pozitif Test","Kilo ve boyut belirlenmeli");
        AbdullahReusableMethods.loginProductsPage();
        //Açilan sayfada aşağı kısımda bulunan menülerden  "Shipping" butonuna tıklanır
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        hub.shipping.click();
        extentTest.info("Açilan sayfada aşağı kısımda bulunan menülerden  \"Shipping\" butonuna tıklandı");
        //Açılan sayfada "Weight(kg)" ve "Dimensions (cm)" yazılarının görürünür olduğu test edilir
        wait.until(ExpectedConditions.visibilityOf(hub.weight));
        Assert.assertTrue(hub.weight.isDisplayed());
        Assert.assertTrue(hub.dimensions.isDisplayed());
        extentTest.info("Açılan sayfada \"Weight(kg)\" ve \"Dimensions (cm)\" yazılarının görürünür olduğu test edildi");
        //Weight(kg) alanına pozitif bir tamsayı girilir
        wait.until(ExpectedConditions.visibilityOf(hub.weightInput));
        hub.weightInput.sendKeys(""+random.nextInt(100));
        extentTest.info("Weight(kg) alanına pozitif bir tamsayı girildi");
        //"Length", "Width","Heighth" alanlarına pozitif bir tamsayı girilir
        wait.until(ExpectedConditions.visibilityOf(hub.lengthInput));
        hub.lengthInput.sendKeys(""+random.nextInt(100));
        wait.until(ExpectedConditions.visibilityOf(hub.widthInput));
        hub.widthInput.sendKeys(""+random.nextInt(100));
        wait.until(ExpectedConditions.visibilityOf(hub.heightInput));
        hub.heightInput.sendKeys(""+random.nextInt(100));
        extentTest.info("\"Length\", \"Width\",\"Heighth\" alanlarına pozitif bir tamsayı girildi");

        AbdullahReusableMethods.validation();

    }
}
