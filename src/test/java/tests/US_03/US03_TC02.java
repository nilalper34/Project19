package tests.US_03;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.hayrullahpgc;
import utilities.ConfigReader;
import utilities.Driver;

public class US03_TC02 {

    hayrullahpgc hayrullahpgc = new hayrullahpgc();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void us03_tc02() throws InterruptedException {


        //1. Vendor  url  adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));

        //2. Vendor  signin butonuna tıklar
        hayrullahpgc.singInButtonMainPage.click();

        //3. Vendor  gecerli bir email girer
        Thread.sleep(2000);
        hayrullahpgc.userNameBox.sendKeys(ConfigReader.getProperty("email01hd"));

        //4. Vendor  gecerli bir password girer
        hayrullahpgc.passwordBox.sendKeys(ConfigReader.getProperty("password01hd"));

        //5. Vendor  sign in butonuna basar
        hayrullahpgc.getSingInButtonLogIn.click();

        //6. Vendor  sign out butonuna basar
        Thread.sleep(2000);
        hayrullahpgc.signOutButton.click();

        //7. Vendor  Orders butonuna basar
        hayrullahpgc.orders.click();

        //8. Vendor  BROWSE PRODUCTS'a tıklar
        hayrullahpgc.browseProducts.click();

        //9. Vendor  5 adet ürünu teker teker secip sepete ekler
        int count = 0;
        boolean besElemanEklendimi = true;

        while (besElemanEklendimi) {
            for (int i = 0; i < hayrullahpgc.allProducts.size(); i++) {
                try {
                    Thread.sleep(2000);
                    hayrullahpgc.allProducts.get(i).click();
                } catch (Exception e) {
                    actions.sendKeys(Keys.PAGE_DOWN);
                }

                try {
                    if (hayrullahpgc.add2Cart.isEnabled()) {
                        hayrullahpgc.add2Cart.click();
                        Driver.getDriver().navigate().back();
                        System.out.println("SEPETE EKLENDI !!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        count++;
                        System.out.println("count : "+count);
                        if (count == 5) {
                            besElemanEklendimi = false;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("eleman eklenemedi");
                }
                Driver.getDriver().navigate().back();


                try {
                    if (hayrullahpgc.browseProducts.isDisplayed()) {
                        Driver.getDriver().navigate().forward();
                    }
                } catch (Exception e) {
                    System.out.println("ileri alindi");
                }



            }




        }
        Driver.closeDriver();


    }

}
