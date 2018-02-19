package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {
    @FindBy (css = ".header-signin-link")
    WebElement loginLink;

    @FindBy (xpath = "//span[@data-selenium-id='lblIsSignedIn']")
    WebElement signedInLabel;

    WebDriver driver;

    public Header(WebDriver _driver){
        this.driver = _driver;
        PageFactory.initElements(driver,this);
    }

    public void clickLogin(){
        loginLink.click();
    }

    public boolean isUserSignedIn(){
       return signedInLabel.isDisplayed();
    }
}
