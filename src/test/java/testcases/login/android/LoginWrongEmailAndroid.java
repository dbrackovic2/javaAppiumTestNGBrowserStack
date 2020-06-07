package testcases.login.android;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.HomeScreenPO;
import pageobjects.LoginScreenPO;
import testcases.BaseTest;
import utils.PropertyUtils;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginWrongEmailAndroid extends BaseTest {
    public String testName = "Negative Login scenario - wrong email: ";
    public HomeScreenPO homeScreenPO;
    public LoginScreenPO loginScreenPO;

    @Test(priority = 1)
    public void openApplication() throws InterruptedException {
        homeScreenPO = new HomeScreenPO(androidDriver);
    }

    @Test(priority = 2)
    public void tryLoginWrongPassword () throws InterruptedException {
        loginScreenPO = homeScreenPO.tapOnGetStartedButton();
        loginScreenPO.loginWrongEmail();
    }

    @Test(priority = 3)
    public void verifyWrongEmail () throws InterruptedException {
        loginScreenPO.verifyWrongEmail();
    }

    @Parameters({"device-name", "android-version"})
    @BeforeTest
    @Override
    public void setUpPage(String deviceName, String androidVersion) throws MalformedURLException {
        this.testCaseName = testName;
        this.deviceNameBase = PropertyUtils.getProperty(deviceName);
        this.OS_versionBase = androidVersion;
        androidDriver = new AndroidDriver(new URL(APPIUM_SERVER_URL), getDesiredCapabilitiesForAndroid());
    }
}
