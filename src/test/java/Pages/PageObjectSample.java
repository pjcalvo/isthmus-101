package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectSample {
    @FindBy (css = ".header-signin-link")
    WebElement loginLink;

    @FindBy (xpath = "//span[@data-selenium-id='lblIsSignedIn']")
    WebElement signedInLabel;

    @FindBy (xpath = "//dropdown-menu[contains(.,'Account')]")
    WebElement dropDown;

    @FindBy (linkText = "Sign Out")
    WebElement signOutLink;

    WebDriver driver;

    public PageObjectSample(WebDriver _driver){
        this.driver = _driver;
        PageFactory.initElements(driver,this);
    }

    public void clickLogin(){
        loginLink.click();
    }

    public boolean isUserSignedIn(){
       return signedInLabel.isDisplayed();
    }

    public void signOut(){
        Actions action = new Actions(driver);
        action.moveToElement(dropDown).perform();
        signOutLink.click();
    }
}
