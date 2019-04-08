import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {
    AndroidDriver<AndroidElement> driver;

    public void OpenApp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.1.0");
        capabilities.setCapability("deviceName", "Google Pixel");
        capabilities.setCapability("udid", "192.168.159.101:5555"); //adb devices -l
        capabilities.setCapability("appPackage", "com.android.dialer");
        capabilities.setCapability("appActivity", "com.android.dialer.DialtactsActivity");
        capabilities.setCapability("noReset", "true");

        URL url = new URL("http://0.0.0.0:4723/wd/hub");

        driver = new AndroidDriver<AndroidElement>(url, capabilities);
    }

    public void SendKeys(String object, String value) {
        driver.findElement(By.xpath(object)).sendKeys(value);
    }

    public void Click(String obj) {

        driver.findElement(By.id(obj)).click();
    }

    public void VerifyText(String actualtext,String expected){
        Assert.assertEquals(actualtext,expected);

    }

    @AfterTest
    public void Quite() {

        driver.quit();
    }

}
