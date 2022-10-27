package utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.Abdullahpgc;

import java.time.Duration;
import java.util.Random;

public   class AbdullahReusableMethods extends TestBaseRapor {
    public static Abdullahpgc hub = new Abdullahpgc();
    public static Actions actions = new Actions(Driver.getDriver());
    public static SoftAssert softAssert = new SoftAssert();
    public static Random random = new Random();
    public static JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    public static  WebDriverWait wait =new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    public static Faker faker = new Faker();

    public static void loginProductsPage() throws InterruptedException {

        // Url` ye gidilir
        Driver.getDriver().get("https://hubcomfy.com/");
        extentTest.info("https://hubcomfy.com/ adresine gidildi");
        // "Sign In" butonuna tiklanir
        hub.SignIn.click();
        extentTest.info("\"Sign In\" butonuna tıklandı");
        // Vendor olarak gecerli kullanici bilgileri girilir
        hub.username.sendKeys(ConfigReader.getProperty("hubcomfyUN"));
        hub.password.sendKeys(ConfigReader.getProperty("hubcomfyPW"));
        extentTest.info("Vendor olarak gecerli kullanici bilgileri girildi");
        // "Sign in" butonuna tiklanir
        hub.signInButton.click();
        extentTest.info("Sign in butonuna tiklandı");
        // Acilan sayfada "My Account" butonuna tiklanir
        Thread.sleep(2000);
        jse.executeScript("arguments[0].scrollIntoView(true);", hub.myAccount);
        jse.executeScript("arguments[0].click();", hub.myAccount);
        extentTest.info("Acilan sayfada My Account butonuna tiklandı");
        // Acilan sayfada "Store Manager" butonuna tiklanir
        Thread.sleep(2000);
        hub.storeManager.click();
        extentTest.info("Acilan sayfada Store Manager butonuna tiklandı");
        // Acilan sayfada "Products" butonuna tiklanir
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        hub.products.click();
        extentTest.info("Acilan sayfada Products butonuna tiklandı");
        // Açılan sayfada ürünlerin görünür olduğu test edilir
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        for (WebElement w : hub.productsList) {
            Assert.assertTrue(w.isDisplayed());
        }
        System.out.println(hub.productsList.size());
        int rastgeleSayi= (random.nextInt(hub.productsList.size()));
        System.out.println(rastgeleSayi);
        extentTest.info("Açılan sayfada ürünlerin görünür olduğu test edildi");
        // Rasgele bir ürün ismi üzerine tıklanır
        Thread.sleep(2000);
        hub.productsList.get(rastgeleSayi).click();
        extentTest.info("Rasgele bir ürün ismi üzerine tıklandı");
    }
    public static void validation() throws InterruptedException {
        // Sayfanin alt kısmında bulunan "submit" butonuna tıklanır
        Thread.sleep(2000);
        jse.executeScript("arguments[0].click();", hub.submitButton);
        extentTest.info("Sayfanin alt kısmında bulunan \"submit\" butonuna tıklandı");

        //"Product Successfully Published" yazısının görünür olduğu test edilir.
        String actualText = hub.successButton1.getText();
        String expectedText = "Product Successfully Published.";
        Assert.assertEquals(expectedText, actualText);
        System.out.println("actualText = " + actualText);
        extentTest.info("Product Successfully Published yazısının görünür olduğu test edildi");

        //Sayfa kapatılır
        extentTest.info("Sayfa kapatıldı");
    }
}
