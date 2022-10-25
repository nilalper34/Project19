package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Ahmetpgc {

    public Ahmetpgc(){
        PageFactory.initElements(Driver.getDriver(),this);


    }
    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement ilkSigIn;

}
