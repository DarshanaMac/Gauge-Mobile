import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;

import java.net.MalformedURLException;


public class StepImplementation extends TestBase {


    @Step("Open Dialer")
    public void OpenDialrerApp() throws MalformedURLException {

       OpenApp("Native","Android","7.1.0","Google Pixel","192.168.159.101:5555","com.android.dialer","com.android.dialer.DialtactsActivity","true");
       // readJSONFile("Company List");
    }

    @Step("Open <applicationURL> Web Appication")
    public void OpenChromeApp(String applicationURL)  {
        OpenWebBrowser("Google Pixel","192.168.159.101:5555","Android","7.1.0","Chrome",applicationURL);
    }


    @Step("Enter mobile number")
    public void entermobilenumber(){
        Click("com.android.dialer:id/floating_action_button");
        Click("com.android.dialer:id/zero");
        Click("com.android.dialer:id/seven");
        Click("com.android.dialer:id/seven");
        Click("com.android.dialer:id/one");
        Click("com.android.dialer:id/two");
    }

    @Step("Verify Call")
    public void VerifyCall(){
        VerifyText("Dialing","Dialing");
    }

    @Step("Fill Contact Information section")
    public void test(){

    }
}
