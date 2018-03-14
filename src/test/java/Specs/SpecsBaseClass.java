package Specs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.FileDetector;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SpecsBaseClass extends SuperBaseClass{

    @Parameters ({"environment","baseURL"})
    @BeforeMethod ()
    public void InitializeTests(@Optional String environment, @Optional String baseUrl) throws MalformedURLException {

        if (environment == null )
            environment = "chrome";
        if (baseUrl == null)
            baseUrl = "https://testingcr-demo.glitch.me";
        if (environment.equals("chrome"))
            driver = new ChromeDriver();
        else
            driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        InitHelpers(baseUrl);
        InitPages();

        driver.get(driverHelper.baseUrl);
    }

    @AfterMethod
    public  void CleanUpDriver(){
        driver.quit();
    }


    private WebDriver getDriver(String methodName) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        String username = "pcalvo%40coffeestain.io";
        String accessKey  = "ub264cda2ba2ad53";
        String server = "hub.crossbrowsertesting.com:80";

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("name", "Login Form Example");
        caps.setCapability("build", "1.0");
        caps.setCapability("browserName", "Internet Explorer");
        caps.setCapability("version", "11");
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("screenResolution", "1366x768");
        caps.setCapability("record_video", "true");

        /*if (methodName.contains("Firefox"))

            capabilities.setCapability("browserName","Firefox");
        else
            capabilities.setCapability("browserName","Chrome");

        //capabilities.setCapability("name",methodName);*/

        URL url = new URL("http://"+username+":"+accessKey+"@"+server+"/wd/hub");

        RemoteWebDriver remoteWebDriver = new RemoteWebDriver(url, caps);
        remoteWebDriver.setFileDetector(new LocalFileDetector());
        return remoteWebDriver;
    }
}
