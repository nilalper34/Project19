package tests.US_05;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Saadetpgc;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.SaadetMethods;

import java.io.IOException;

public class US005_TC004 {

    @Test
    public void test004() throws InterruptedException, IOException {
        SaadetMethods.products();
        Saadetpgc page = new Saadetpgc();
        Actions actions = new Actions(Driver.getDriver());
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

        //  9-"Add New" e tiklar
        page.addNewButton.click();

        //  10-Featured Image alanina tıklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        page.featuredDisplay.click();

        //  11-Acilan sayfada "Media Library" e tıklar
        Thread.sleep(2000);
        page.mediaLibrary.click();

        //  12-Resmi tiklar
        Thread.sleep(2000);
        jse.executeScript("arguments[0].scrollIntoView(true);" ,page.resim1);
        jse.executeScript("arguments[0].click();" , page.resim1);

        //  13-"SELECT" secenegini tıklar
        page.selectButton.click();

        //  14-Resmin eklendiğini test eder
        Thread.sleep(2000);
        Assert.assertTrue(page.featuredDisplay.isDisplayed(),"Resim eklenememis...");

        //  15-Gallery Image alanina tıklar
        page.galleryDisplay.click();

        //  16-Resmi tiklar
        Thread.sleep(2000);
        jse.executeScript("arguments[0].scrollIntoView(true);" ,page.resim2);
        jse.executeScript("arguments[0].click();" , page.resim2);


        //  17-"ADD TO GALLERY" secenegini tıklar
        jse.executeScript("arguments[0].scrollIntoView(true);" ,page.addToGallery);
        jse.executeScript("arguments[0].click();" , page.addToGallery);

        //  18-Resmin eklendiğini test eder
        Assert.assertTrue(page.galleryDisplay.isDisplayed(),"Resim eklenememis...");

        ReusableMethods.getScreenshot("Resimler Eklenmis...");

        Driver.getDriver().close();
    }
}
