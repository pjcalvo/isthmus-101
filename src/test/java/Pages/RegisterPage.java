package Pages;

import Helpers.DataHelper;
import Model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    @FindBy(xpath = "//input[@id='inputFirstName']")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='inputLastName']")
    WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='inputUsername']")
    WebElement userNameInput;

    @FindBy(xpath = "//input[@id='inputPassword']")
    WebElement passwordInput;

    @FindBy(xpath = "//button[@id='buttonRegistrarse']")
    WebElement registerBtn;

    @FindBy(css = ".div.alert.alert-danger")
    WebElement alreadyRegisteredMessage;

    WebDriver driver;

    DataHelper dataHelper;

    public RegisterPage(WebDriver _driver, DataHelper dataHelper){
        this.driver =_driver;
        PageFactory.initElements(this.driver,this);
        this.dataHelper = dataHelper;
    }

    public void registerUser(User _testUser){

        this.firstNameInput.sendKeys(_testUser.firstName);
        this.lastNameInput.sendKeys(_testUser.lastName);
        this.userNameInput.sendKeys(_testUser.userName);
        this.userNameInput.sendKeys(_testUser.password);
        this.registerBtn.click();
    }

    public void registerUser(){
        registerUser(dataHelper.existingUser());
    }

    public String errorMessageContent(){
        return alreadyRegisteredMessage.getText();
    }
}