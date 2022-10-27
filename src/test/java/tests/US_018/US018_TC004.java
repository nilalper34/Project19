package tests.US_018;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Senerpgc;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.IOException;

public class US018_TC004 {

    SoftAssert softAssert=new SoftAssert();
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void Test01() throws InterruptedException, IOException {

        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));

        Senerpgc senerpgc = new Senerpgc();
        senerpgc.ilkSigninButonu.click();
        senerpgc.email.sendKeys(ConfigReader.getProperty("userEmailMSO"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("userPasswordMSO"))
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        Assert.assertTrue(senerpgc.signOut.isDisplayed());

        Thread.sleep(2000);
        jse.executeScript("arguments[0].scrollIntoView(true);", senerpgc.myAccount);
        jse.executeScript("arguments[0].click();", senerpgc.myAccount);

        senerpgc.storeManagerButton.click();
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        senerpgc.refundButton.click();

        softAssert.assertTrue(senerpgc.type.isDisplayed(),"Type goruntulenemdi");
        softAssert.assertAll();


    }
}
