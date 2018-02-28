package Pages;

import Helpers.DataHelper;
import Model.User;
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

    @FindBy(xpath = "//div[@data-selenium-id='keepMeSignedIn']//label")
    WebElement rememberMeCheck;

    @FindBy(xpath = "//input[@value='Sign In']")
    WebElement submitButton;

    @FindBy(css = ".input-error")
    WebElement errorMessage;

    WebDriver driver;

    DataHelper dataHelper;

    public SignInModal(WebDriver _driver, DataHelper dataHelper){
        this.driver =_driver;
        PageFactory.initElements(this.driver,this);
        this.dataHelper = dataHelper;
    }

    public void signInUser(User _testUser, Boolean rememberMe){

        this.emailInput.sendKeys(_testUser.email);
        this.passwordInput.sendKeys(_testUser.password);

        if(rememberMe){
            rememberMeCheck.click();
        }

        this.submitButton.click();

    }

    public void signInUser(User _testUser){

        signInUser(_testUser, false);
    }

    public void signInUser(){

       signInUser(dataHelper.existingUser());
    }

    public String errorMessageContent(){
        return errorMessage.getText();
    }
}
