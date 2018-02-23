package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.Paths;

public class DriverHelper {

    public WebDriver driver;
    public String baseUrl;

    public DriverHelper(WebDriver webDriver, String baseUrl){
        driver = webDriver;
        this.baseUrl = baseUrl;
    }

    public void executeJavaScript(String script){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript(script);
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



}

