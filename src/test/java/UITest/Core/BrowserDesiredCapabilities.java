package UITest.Core;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserDesiredCapabilities {

    public DesiredCapabilities getDesiredCapabilities(String browserName) throws Exception {
        DesiredCapabilities dc = new DesiredCapabilities();

        switch (browserName.toUpperCase()){

            case "CHROME":
                dc.setBrowserName(browserName);
                dc.acceptInsecureCerts();
                dc.setPlatform(Platform.getCurrent());
                break;
            case "FIREFOX":
                dc.setBrowserName(browserName);
                dc.acceptInsecureCerts();
                dc.setPlatform(Platform.getCurrent());
                break;
            default:
                throw new Exception();
        }
        return dc;
    }


}
