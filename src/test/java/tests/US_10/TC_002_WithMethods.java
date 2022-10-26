package tests.US_10;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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
        extentTest=extentReports.createTest("Pozitif Test","Size secenegi; small, medium, large, extra large olmali");
        AbdullahReusableMethods.loginProductsPage();
        //Açilan sayfada aşağı kısımda bulunan menülerden  "Attributes" butonuna tıklanır
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();
        hub.attributes.click();
        extentTest.info("Açilan sayfada aşağı kısımda bulunan menülerden  \"Attributes\" butonuna tıklandı");
        // Açılan sayfada "Size" check box'ının görünür olduğu test edilir
        wait .until(ExpectedConditions.visibilityOf(hub.size));
        Assert.assertTrue(hub.size.isDisplayed());
        extentTest.info("Açılan sayfada \"Size\" check box'ının görünür olduğu test edildi");
        // "Sİze" check box'ına tıklanır
        Thread.sleep(2000);
        if(hub.sizeCheckBox.isSelected()){
            hub.sizeCheckBox.click();
            hub.sizeCheckBox.click();
        }else hub.sizeCheckBox.click();
        extentTest.info("\"Sİze\" check box'ına tıklanır");

        //Açılan sayfada "Select All" butonunun erişilebilir olduğu test edilir ve butona tıklanır
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(hub.sizeSelectAll));
        Assert.assertTrue(hub.sizeSelectAll.isEnabled());
        hub.sizeSelectAll.click();
        extentTest.info("Açılan sayfada \"Select All\" butonunun erişilebilir olduğu test edilir ve butona tıklandı");

        //Açılan listede small, medium, large, extra large seçeneklerinin olduğunu test eder
        Thread.sleep(3000);

        String actualList="";
        String expectedList="×aaLarge×alarge×Extra Large×Large×Medium×Small×x large×xxlarge";
        for(WebElement w : hub.sizeList){
            actualList+=  w.getText();
        }
        System.out.println("actualList = " + actualList);
        Assert.assertTrue(actualList.contains(expectedList));
        hub.sizeCheckBox.click();
        extentTest.info("Açılan listede small, medium, large, extra large seçeneklerinin olduğunu test edildi");

        AbdullahReusableMethods.validation();
    }
}
