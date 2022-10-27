package tests.US_017;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Senerpgc;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.IOException;

public class US017_TC003 {

    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void Test01() throws InterruptedException, IOException {


        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));

        Senerpgc senerpgc=new Senerpgc();
        senerpgc.ilkSigninButonu.click();
        senerpgc.email.sendKeys(ConfigReader.getProperty("userEmailMSO"));
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("userPasswordMSO"))
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        Assert.assertTrue(senerpgc.signOut.isDisplayed());

        Thread.sleep(2000);
        jse.executeScript("arguments[0].scrollIntoView(true);", senerpgc.myAccount);
        jse.executeScript("arguments[0].click();", senerpgc.myAccount);

        senerpgc.storeManagerButton.click();
        senerpgc.customersButton.click();
        senerpgc.addNewButton.click();
        Faker faker=new Faker();
        senerpgc.userNameKutucugu.sendKeys(faker.name().username());
        actions.sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB).sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.TAB).sendKeys("Java")
                .sendKeys(Keys.TAB).sendKeys("Kava")
                .sendKeys(Keys.TAB).sendKeys("Kava Ltd. Sti.")
                .sendKeys(Keys.TAB).sendKeys("+905554443322")
                .sendKeys(Keys.TAB).sendKeys("Erdem Mahallesi 672 Sokak")
                .sendKeys(Keys.TAB).sendKeys("Elif Apt. No:75 D:6")
                .sendKeys(Keys.TAB).sendKeys("Turkey")
                .sendKeys(Keys.ENTER).sendKeys(Keys.TAB).sendKeys("Konak").perform();

        Thread.sleep(2000);

        Select select=new Select(senerpgc.stateDDMIlk);
        select.selectByIndex(35);

        actions.sendKeys(Keys.TAB).sendKeys("35145").perform();
        senerpgc.sameAsBillingKutucugu.click();

        actions.sendKeys(Keys.TAB).sendKeys("Ali")
                .sendKeys(Keys.TAB).sendKeys("Bak")
                .sendKeys(Keys.TAB).sendKeys("---")
                .sendKeys(Keys.TAB).sendKeys("Baris Mahallesi 111 Sokak").perform();
        Thread.sleep(1000);

        actions.sendKeys(Keys.TAB).sendKeys("Yesil Apt. No:25 D:5").perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.TAB).sendKeys("Turkey")
                .sendKeys(Keys.ENTER).sendKeys(Keys.TAB).sendKeys("Buca").perform();


        select=new Select(senerpgc.stateDDMIkinci);
        select.selectByIndex(35);
        Thread.sleep(3000);

        actions.sendKeys(Keys.TAB).sendKeys("35125").perform();

        Thread.sleep(2000);
        senerpgc.ilkSubmitButton.click();
        Thread.sleep(2000);


        Assert.assertTrue(senerpgc.successfullyYazisi.isDisplayed());



    }
}
