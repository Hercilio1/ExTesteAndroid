package Login;


import action.LoginAction;
import resources.ConfigAppium;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginTest {

    private AppiumDriver<MobileElement> driver;
    private AndroidDriver<MobileElement> driverAndroid;
    private ConfigAppium configAppium;
    private String user = "";
    private String senha = "";

    @Parameters({"DEVICE_ID", "AppiumServerURL", "DeviceType", "appName"})
    @BeforeTest
    public void setUp(String Device_ID, String AppiumServerURL, String appName) throws MalformedURLException{


        configAppium = new ConfigAppium(Device_ID, AppiumServerURL, appName);
        this.driverAndroid = new AndroidDriver<MobileElement>(new URL(AppiumServerURL), configAppium.getCap());

    }

    @Test
    public void testLoginAndroid() throws InterruptedException {
        LoginAction login = new LoginAction(driverAndroid, user, senha);

    }



}