package testcases.login.iOS;

import io.appium.java_client.ios.IOSDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.HomeScreenPO;
import pageobjects.LoginScreenPO;
import pageobjects.ProfilePO;
import testcases.BaseTest;
import utils.PropertyUtils;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginEmployeeEmailPassiOS extends BaseTest {
    public String testName = "Login with Employee email/pass account on iOS: ";
    public HomeScreenPO homeScreenPO;
    public LoginScreenPO loginScreenPO;
    public ProfilePO profilePO;

    @Test(priority = 1)
    public void openApplication() throws InterruptedException {
        homeScreenPO = new HomeScreenPO(iosDriver);
    }

    @Test(priority = 2)
    public void loginwithEmployeeAccount () throws InterruptedException {
        loginScreenPO = homeScreenPO.tapOnGetStartedButtoniOS();
        loginScreenPO.loginWithEmployeeEmailPassiOS();
    }

    @Test(priority = 3)
    public void verifyEmployeeLoggedIn () throws InterruptedException {
        profilePO = loginScreenPO.openProfilePageiOS();
        loginScreenPO.verifyEmployeeUserLoggedIniOS();
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
