import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;


public class TestBase {


    AndroidDriver<AndroidElement> driver;
    JSONParser parser = new JSONParser();
    JSONArray companyList;

    public void OpenApp(String mode,String platformName,String platformVersion,String deviceName,String udid,String appPackage,String appActivity,String noReset) throws MalformedURLException {

        if (mode.contentEquals("Native")){

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", platformName);
            capabilities.setCapability("platformVersion", platformVersion);
            capabilities.setCapability("deviceName", deviceName);
            capabilities.setCapability("udid", udid); //adb devices -l
            capabilities.setCapability("appPackage", appPackage);
            capabilities.setCapability("appActivity", appActivity);
            capabilities.setCapability("noReset", noReset);
            capabilities.setCapability("browsername","null");
            URL url = new URL("http://0.0.0.0:4723/wd/hub");

            driver = new AndroidDriver<AndroidElement>(url, capabilities);

        }else if (mode.equalsIgnoreCase("Web")){

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", platformName);
            capabilities.setCapability("platformVersion", platformVersion);
            capabilities.setCapability("deviceName", deviceName);
            capabilities.setCapability("udid", udid);
            capabilities.setCapability("noReset", noReset);



            System.setProperty("webdriver.chrome.driver","E:\\Local_Drive\\Suppliment_Drivers\\chromedriver.exe");

            //Instantiate Appium Driver
            AppiumDriver<MobileElement> driver = null;
            try {
                driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

            } catch (MalformedURLException e) {
                System.out.println(e.getMessage());
            }
            driver.get("http://www.google.com");
        }
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

    public String readJSONFile(String nodes){
        JSONObject jsonObject;
        try{
            Object obj = parser.parse(new FileReader("C:\\Users\\ASUS\\Desktop\\file1.txt"));

             jsonObject = (JSONObject) obj;


            String author = (String) jsonObject.get(nodes);
//            companyList = (JSONArray) jsonObject.get("Company List");

//            Iterator<String> iterator = companyList.iterator();
//            while (iterator.hasNext()) {
//                System.out.println(iterator.next());
//            }
        }catch (Exception e){

            System.out.println(e);
        }
        System.out.println(nodes);
        return nodes;
    }

    public void OpenWebBrowser(String deviceName,String udid,String platformName,String platformVersion,String browserName,String applicationURL){

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName",deviceName);
        caps.setCapability("udid",udid); //Give Device ID of your mobile phone
        caps.setCapability("platformName",platformName);
        caps.setCapability("platformVersion", platformVersion);
        caps.setCapability("browserName", browserName);
        caps.setCapability("noReset", true);
        System.out.println(applicationURL);
        //Set ChromeDriver location
        System.setProperty("webdriver.chrome.driver","E:\\Local_Drive\\Suppliment_Drivers\\chromedriver.exe");

        //Instantiate Appium Driver
        AppiumDriver<MobileElement> driver = null;
        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }

        //Open URL in Chrome Browser
        driver.get(applicationURL);
    }


    @AfterTest
    public void Quite() {
        driver.quit();
    }

}
