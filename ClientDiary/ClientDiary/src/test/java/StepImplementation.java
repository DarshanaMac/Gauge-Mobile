import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;

import java.net.MalformedURLException;


public class StepImplementation extends TestBase {


    @Step("Open Dialer")
    public void OpenDialrerApp() throws MalformedURLException {
        OpenApp();

        VerifyText("Dialing","Dialing");
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
       
    }
}
