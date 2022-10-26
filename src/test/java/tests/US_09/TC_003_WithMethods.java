package tests.US_09;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
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
        extentTest=extentReports.createTest("Pozitif Test","Ne kadar surede teslimat yapilacagi belirlenmeli");
        AbdullahReusableMethods.loginProductsPage();
        //Açilan sayfada aşağı kısımda bulunan menülerden  "Shipping" butonuna tıklanır
        jse.executeScript("arguments[0].scrollIntoView(true);", hub.shipping);
        jse.executeScript("arguments[0].click();", hub.shipping);
        extentTest.info("Açilan sayfada aşağı kısımda bulunan menülerden  \"Shipping\" butonuna tıklandı");
        //Açılan sayfada "Processing Time" yazısının görürünür olduğu test edilir
        wait.until(ExpectedConditions.visibilityOf(hub.processingTime));
        Assert.assertTrue(hub.processingTime.isDisplayed());
        extentTest.info("Açılan sayfada \"Processing Time\" yazısının görürünür olduğu test edildi");
        //"Processing Time"  drop down menüsünde "1 business day","1-2 business days",
        // "1-3 business days","3-5 business days","1-2 weeks","2-3 weeks","3-4 weeks",
        // "4-6 weeks","6-8 weeks" seçeneklerinin erişilebilr olduğu test edilir
        Select select = new Select(hub.processingTimeDropDown);
        for(WebElement w: select.getOptions()){
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOf(w));
            w.click();
            Assert.assertTrue(w.isDisplayed());
        }
        extentTest.info("\"Processing Time\"  drop down menüsünde \"1 business day\",\"1-2 business days\",\n" +
                "         \"1-3 business days\",\"3-5 business days\",\"1-2 weeks\",\"2-3 weeks\",\"3-4 weeks\",\n" +
                "         \"4-6 weeks\",\"6-8 weeks\" seçeneklerinin erişilebilr olduğu test edildi");
        AbdullahReusableMethods.validation();
    }
}
