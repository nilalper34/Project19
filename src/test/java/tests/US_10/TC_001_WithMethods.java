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
        extentTest=extentReports.createTest("Pozitif Test","Renk secenegi; beyaz, siyah, yeşil vs tum renkler belirtilmeli");
        AbdullahReusableMethods.loginProductsPage();
        //Açilan sayfada aşağı kısımda bulunan menülerden  "Attributes" butonuna tıklanır
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();
        hub.attributes.click();
        extentTest.info("Açilan sayfada aşağı kısımda bulunan menülerden  \"Attributes\" butonuna tıklandı");
        //Açılan sayfada "Color" check box'ının görünür olduğu test edilir
        wait .until(ExpectedConditions.visibilityOf(hub.color));
        Assert.assertTrue(hub.color.isDisplayed());
        extentTest.info("Açılan sayfada \"Color\" check box'ının görünür olduğu test edilir");
        //Color check box'ına tıklanır
        Thread.sleep(2000);
        if(hub.sizeCheckBox.isSelected()){
            hub.sizeCheckBox.click();
            hub.sizeCheckBox.click();
        }else hub.sizeCheckBox.click();
        extentTest.info("Color check box'ına tıklandı");

        //Açılan sayfada "Select All" butonunun erişilebilir olduğu test edilir ve butona tıklanır
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(hub.sizeSelectAll));
        Assert.assertTrue(hub.sizeSelectAll.isEnabled());
        hub.sizeSelectAll.click();
        extentTest.info("Açılan sayfada \"Select All\" butonunun erişilebilir olduğu test edilir ve butona tıklandı");

        //Açılan listede "white", "Black", "Green", "Blue","Brown","Dark Blue","Fusya","Gray","Red",
        // "Light Blue","Orange","Pink","Purple",Silver","Turquoise","Yellow"
        // seçeneklerinin erişilebilir olduğunu test eder
        Thread.sleep(3000);

        String actualList="";
        String expectedList="×Black×Blue×Brown×burası çok zor:(×Dark Blue×djdjdj×Fusya×Gray×Green×Grey×java.util.Random@1a07bf6×Kırmızı×Light Blue×mavi×MOR×Orange×Pink×Purple×Red×Silver×Turquoise×violet×white×Yellow";
        for(WebElement w : hub.colorList){
            actualList+=  w.getText();
        }
        System.out.println("actualList = " + actualList);
        Assert.assertTrue(actualList.contains(expectedList));
        hub.sizeCheckBox.click();
        extentTest.info("//Açılan listede \"white\", \"Black\", \"Green\", \"Blue\",\"Brown\",\"Dark Blue\",\"Fusya\",\"Gray\",\"Red\",\n" +
                "        // \"Light Blue\",\"Orange\",\"Pink\",\"Purple\",Silver\",\"Turquoise\",\"Yellow\"\n" +
                "        // seçeneklerinin erişilebilir olduğunu test eder");
        AbdullahReusableMethods.validation();
    }
}
