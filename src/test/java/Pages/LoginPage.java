package Pages;

import Helpers.DataHelper;
import Model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath = "//input[@id='inputUsername']")
    WebElement userInput;

    @FindBy(xpath = "//input[@id='inputPassword']")
    WebElement passwordInput;

    @FindBy(xpath = "//button[@id='buttonIngresar']")
    WebElement signInBtn;

    @FindBy(xpath = "//a[contains(text(),'Registrarse')]")
    WebElement registerBtn;

    @FindBy(css = ".div.alert.alert-danger")
    WebElement errorMessage;

    WebDriver driver;

    DataHelper dataHelper;

    public LoginPage(WebDriver _driver, DataHelper dataHelper){
        this.driver =_driver;
        PageFactory.initElements(this.driver,this);
        this.dataHelper = dataHelper;
    }

    public void signInUser(User _testUser){

        this.userInput.sendKeys(_testUser.userName);
        this.passwordInput.sendKeys(_testUser.password);
        this.signInBtn.click();

    }

    public void signInUser(){

        signInUser(dataHelper.existingUser());
    }

    public String errorMessageContent(){
        return errorMessage.getText();
    }
}