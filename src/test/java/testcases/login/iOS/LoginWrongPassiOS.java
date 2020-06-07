package testcases.login.iOS;

import io.appium.java_client.ios.IOSDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.HomeScreenPO;
import pageobjects.LoginScreenPO;
import testcases.BaseTest;
import utils.PropertyUtils;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginWrongPassiOS extends BaseTest {
    public String testName = "Negative login scenario - wrong password: ";
    public HomeScreenPO homeScreenPO;
    public LoginScreenPO loginScreenPO;

    @Test(priority = 1)
    public void openApplication() throws InterruptedException {
        homeScreenPO = new HomeScreenPO(iosDriver);
    }

    @Test(priority = 2)
    public void tryLoginWrongPassword () throws InterruptedException {
        loginScreenPO = homeScreenPO.tapOnGetStartedButtoniOS();
        loginScreenPO.loginWrongPasswordiOS();
    }

    @Test(priority = 3)
    public void verifyWrongPassword () throws InterruptedException {
        loginScreenPO.verifyWrongPasswordiOS();
    }

    @Parameters({"device-name", "ios-version"})
    @BeforeTest
    @Override
    public void setUpPage(String deviceName, String iOSVersion) throws MalformedURLException {
        this.testCaseName = testName;
        this.deviceNameBase = PropertyUtils.getProperty(deviceName);
        this.OS_versionBase = iOSVersion;
        this.iosDriver = new IOSDriver(new URL(APPIUM_SERVER_URL), getDesiredCapabilitiesForiOS());
    }
}
