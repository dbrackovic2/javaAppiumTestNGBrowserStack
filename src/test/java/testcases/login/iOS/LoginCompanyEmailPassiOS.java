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

public class LoginCompanyEmailPassiOS extends BaseTest {
    public String testName = "Login with Company email/pass account on iOS: ";
    public HomeScreenPO homeScreenPO;
    public LoginScreenPO loginScreenPO;
    public ProfilePO profilePO;

    @Test(priority = 1)
    public void openApplication() throws InterruptedException {
        homeScreenPO = new HomeScreenPO(iosDriver);
    }

    @Test(priority = 2)
    public void loginwithEmployerAccount () throws InterruptedException {
        loginScreenPO = homeScreenPO.tapOnGetStartedButtoniOS();
        loginScreenPO.loginWithCompanyEmailPassiOS();
    }

    @Test(priority = 3)
    public void verifyEmployerLoggedIn () throws InterruptedException {
        profilePO = loginScreenPO.openProfilePageiOS();
        loginScreenPO.verifyCompanyUserLoggediniOS();
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
