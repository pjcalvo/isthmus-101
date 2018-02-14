package Pages;

import com.sun.xml.internal.ws.server.sei.MessageFiller;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInModal{

    @FindBy(xpath = "//input[@data-selenium-id='txtEmailAddress']")
    WebElement emailInput;

    @FindBy(xpath = "//input[@data-selenium-id='txtPassword']")
    WebElement passwordInput;

    @FindBy(xpath = "//input[@value='Sign In']")
    WebElement submitButton;

    WebDriver driver;

    public SignInModal(WebDriver _driver){
        this.driver =_driver;
        PageFactory.initElements(this.driver,this);
    }

    public void signInUser(String emailInput, String password){

        this.emailInput.sendKeys(emailInput);
        this.passwordInput.sendKeys(password);
        this.submitButton.click();

        driver.manage().deleteAllCookies();
    }
}
