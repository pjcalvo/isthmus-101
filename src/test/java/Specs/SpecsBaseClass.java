package Specs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.FileDetector;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SpecsBaseClass extends SuperBaseClass{


    @BeforeMethod ()
    public void InitializeTests(Method method) throws MalformedURLException {
        // driver = getDriver(method.getName());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        InitHelpers("https://www.1800contactstest.com/");
        InitPages();

        driver.get(driverHelper.baseUrl);
    }

    @AfterMethod
    public  void CleanUpDriver(){
        driver.quit();
    }


    private WebDriver getDriver(String methodName) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("username","isthmustest");
        capabilities.setCapability("accesskey","2ebbc8f5-98fd-4a05-8ac3-c973e10434fb");

        if (methodName.contains("Firefox"))

            capabilities.setCapability("browserName","Firefox");
        else
            capabilities.setCapability("browserName","Chrome");

        capabilities.setCapability("name",methodName);

        URL url = new URL("https://isthmustest:2ebbc8f5-98fd-4a05-8ac3-c973e10434fb@ondemand.saucelabs.com:443/wd/hub");

        RemoteWebDriver remoteWebDriver = new RemoteWebDriver(url, capabilities);
        remoteWebDriver.setFileDetector(new LocalFileDetector());
        return remoteWebDriver;
    }

}
