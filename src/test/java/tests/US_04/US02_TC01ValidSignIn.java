package tests.US_04;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Erhanpgc;
import utilities.ConfigReader;
import utilities.Driver;

public class US02_TC01ValidSignIn {
    public static Actions actions = new Actions(Driver.getDriver());
    public static JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    public static Erhanpgc erhanpgc = new Erhanpgc();
    public static SoftAssert softAssert = new SoftAssert();
    @Test
    public static void ValidSignInVendor() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));
        erhanpgc.signInButton.click();
        erhanpgc.signInUserName.sendKeys(ConfigReader.getProperty("hbcValidUserMailErhan"));
        erhanpgc.signInPassword.sendKeys(ConfigReader.getProperty("hbcValidPasswordErhan"));
        erhanpgc.confirmSignIn.click();
        Thread.sleep(3000);

    }
}
