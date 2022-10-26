package tests.US_03;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.hayrullahpgc;
import utilities.ConfigReader;
import utilities.Driver;

public class US03_TC04 {

    hayrullahpgc hayrullahpgc = new hayrullahpgc();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    SoftAssert softAssert = new SoftAssert();
    Faker faker = new Faker();


    @Test
    public void us03_tc04() throws InterruptedException {
        //1. Vendor  url  adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));

        //2. Vendor  signin butonuna tıklar
        hayrullahpgc.singInButtonMainPage.click();

        //3. Vendor  gecerli bir email girer
        Thread.sleep(2000);
        hayrullahpgc.userNameBox.sendKeys(ConfigReader.getProperty("emailhd"));

        //4. Vendor  gecerli bir password girer
        hayrullahpgc.passwordBox.sendKeys(ConfigReader.getProperty("passwordhd"));

        //5. Vendor  sign in butonuna basar

        hayrullahpgc.getSingInButtonLogIn.click();

        //6. Vendor  sepete tıklar
        Thread.sleep(2000);
        hayrullahpgc.sepet.click();

        //7. Vendor  checkout a tıklar
        Thread.sleep(2000);
        hayrullahpgc.checkout.click();

        //8. Vendor  country'ye tıklar ülke secer
        //9. Vendor street adres satırına adres yazar
        //10. Vendor  town city bilgisi girer
        //11. Vendor  state bilgisi girer
        //12. Vendor  zıp code bilgisi girer

        Thread.sleep(2000);
        hayrullahpgc.companyNameBox.click();
        actions.sendKeys(Keys.TAB).sendKeys("United States",Keys.ENTER,Keys.TAB).
        sendKeys(faker.address().streetAddress(),Keys.TAB).
        sendKeys(Keys.TAB,Keys.TAB,"New York",Keys.ENTER).
        sendKeys(Keys.TAB,faker.address().zipCode()).perform();


    }

}
