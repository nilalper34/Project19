package tests.US_05;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Saadetpgc;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.SaadetMethods;

import java.io.IOException;

public class US005_TC006 {

    @Test
    public void test006() throws IOException, InterruptedException {
        SaadetMethods.products();
        Saadetpgc page = new Saadetpgc();
        Actions actions = new Actions(Driver.getDriver());
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

        //  9-"Add New" e tiklar
        page.addNewButton.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // 10-"Virtual" a tiklar
        // 11-"Product Title" "Kız Çocuk Bisikleti" girer
        // 12-Price($) ve Sale Price ($) a ("600" ve "550") girer
        page.virtualClick.click();
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("Kız Çocuk Bisikleti")
                .sendKeys(Keys.TAB).sendKeys("600").sendKeys(Keys.TAB).sendKeys("550")
                .perform();

        // 13-Short Description kısmına PEMBE BISIKLET yazar
        // 14-Description kısmına KIZ COCUKLARI BU BISIKLETİ ÇOK SEVECEK yazar
        WebElement iframe1 = page.shortDescriptionIframe;
        Driver.getDriver().switchTo().frame(iframe1);
        page.shortDescriptionBox.sendKeys("PEMBE BISIKLET");
        Driver.getDriver().switchTo().defaultContent();

        actions.sendKeys(Keys.TAB).perform();

        WebElement iframe2 = page.descritionIframe;
        Driver.getDriver().switchTo().frame(iframe2);
        page.descritionBox.sendKeys("KIZ COCUKLARI BU BISIKLETİ ÇOK SEVECEK");
        Driver.getDriver().switchTo().defaultContent();

        ReusableMethods.waitFor(2);

        // 15-Urun resimlerini ekler
        page.featuredDisplay.click();
        page.mediaLibrary.click();
        ReusableMethods.waitFor(2);
        jse.executeScript("arguments[0].scrollIntoView(true);", page.bisikletResmi1);
        jse.executeScript("arguments[0].click();", page.bisikletResmi1);
        page.selectButton.click();
        ReusableMethods.waitFor(2);
        page.galleryDisplay.click();
        ReusableMethods.waitFor(2);
        jse.executeScript("arguments[0].scrollIntoView(true);", page.bisikletResmi2);
        jse.executeScript("arguments[0].click();", page.bisikletResmi2);
        jse.executeScript("arguments[0].scrollIntoView(true);", page.addToGallery);
        jse.executeScript("arguments[0].click();", page.addToGallery);

        // 16-Categories den Bisikleti tıklar
        // 17-Product Brands ten NS8 yi tiklar
        ReusableMethods.waitFor(2);
        page.bisikletBox.click();
        page.nS8Box.click();

        // 18-SUBMIT e tiklar
        ReusableMethods.waitFor(2);
        jse.executeScript("arguments[0].scrollIntoView(true);", page.submitButton);
        jse.executeScript("arguments[0].click();", page.submitButton);

       //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
       // wait.until(ExpectedConditions.visibilityOf(page.successfullyMessage));

        ReusableMethods.waitForVisibility(page.successfullyMessage , 15);

        // 19-Product Successfully Published yazisinin çiktigini Dogrular
        Assert.assertTrue(page.successfullyMessage.getText().contains("Product Successfully Published."),
                "Product Successfully Published. yazisini icermiyor ");
        ReusableMethods.getScreenshot("Successfully Message");


        Driver.getDriver().close();

    }
}
