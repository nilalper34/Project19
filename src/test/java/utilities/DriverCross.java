package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverCross {
    private DriverCross(){

    }
    static WebDriver driver;

    public static WebDriver getDriver(String browser){
        browser=(browser==null) ? (ConfigReader.getProperty("browser")) : browser;

        if (driver==null) {

            switch (browser){
                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "safari" :
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;
                case "Firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;

            }



        }
        return driver;
    }

    public static void closeDriver(){
        if (driver!=null){     // driver'a deger atanmissa
            driver.close();
            driver=null;
        }

    }
}
