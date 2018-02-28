package Helpers;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.Select;

public class DriverHelper {

    public WebDriver driver;
    public String baseUrl;

    public DriverHelper(WebDriver webDriver, String baseUrl){
        driver = webDriver;
        this.baseUrl = baseUrl;
    }

    public Object executeJavaScript(String script){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        return js.executeScript(script);
    }

    public void selectElementFromDropDown(WebElement element, Boolean byValue, String value){
        Select select = new Select(element);

        if (byValue)
            select.selectByValue(value);
    }

    public void uploadFile(String id, String file){
        executeJavaScript("$('#" + id + "').css({ 'visibility' : 'visible', 'opacity' : '2','width':'auto', 'height':'auto', 'z-index':'98'})");

        String filePath = new java.io.File("").getAbsolutePath();
        filePath += "\\src\\test\\java\\" + file;

        WebElement fileUpload = driver.findElement(By.id(id));
        fileUpload.sendKeys(filePath);
    }

    public Boolean isLocalStorage(String key){
        LocalStorage localStorage = ((WebStorage)driver).getLocalStorage();
        return !(localStorage.getItem(key) == null);
    }
}

