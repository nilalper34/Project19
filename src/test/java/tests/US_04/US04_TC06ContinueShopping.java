package tests.US_04;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.Erhanpgc;
import utilities.Driver;


public class US04_TC06ContinueShopping  {

    public static Erhanpgc erhanpgc = new Erhanpgc();
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Test(priority = 6)
    public void tc06_ContinueShopping() throws InterruptedException {

        US04_TC01AddFiveItems.tc01AddFiveItems();

        jse.executeScript("arguments[0].scrollIntoView(true);", erhanpgc.continueShoppingButton);
        jse.executeScript("arguments[0].click();", erhanpgc.continueShoppingButton);
    }
}
