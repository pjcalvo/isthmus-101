import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class FirstSeleniumTest {

    @Test
    public void MyFirstTest() throws InterruptedException {
            // Create a new instance of the Firefox driver
            WebDriver driver = GetWebdriver();

            //Launch the Online Store Website
            driver.get("https://www.1800contactstest.com");

            WebElement signInLink = driver.findElement(By.linkText("Sign In"));
            signInLink.click();
            Thread.sleep(3000);

            WebElement username = driver.findElement(By.xpath("//input[@data-selenium-id='txtEmailAddress']"));
            username.sendKeys("pablo@pablillo.com");

            WebElement  password = driver.findElement(By.xpath("//input[@data-selenium-id='txtPassword']"));
            password.sendKeys("123456");

            WebElement btnSubmit = driver.findElement(By.xpath("//input[@value='Sign In']"));
            btnSubmit.click();

             Thread.sleep(5000);

            WebElement welcome = driver.findElement(By.xpath("//span[@data-selenium-id='lblIsSignedIn']"));
            Assert.assertTrue(welcome.isDisplayed());

            // Close the driver
            driver.quit();
        }

        private WebDriver GetWebdriver(){
            return new ChromeDriver();
        }

}
