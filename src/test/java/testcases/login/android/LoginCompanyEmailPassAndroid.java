package testcases.login.android;

import io.appium.java_client.android.AndroidDriver;
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

public class LoginCompanyEmailPassAndroid extends BaseTest {
    public String testName = "Login with Company email/pass account: ";
    public HomeScreenPO homeScreenPO;
    public LoginScreenPO loginScreenPO;
    public ProfilePO profilePO;

    @Test(priority = 1)
    public void openApplication() throws InterruptedException {
        homeScreenPO = new HomeScreenPO(androidDriver);
    }

    @Test(priority = 2)
    public void loginwithEmployerAccount () throws InterruptedException {
        loginScreenPO = homeScreenPO.tapOnGetStartedButton();
        loginScreenPO.loginWithCompanyEmailPassAndroid();
    }

    @Test(priority = 3)
    public void verifyEmployerLoggedIn () throws InterruptedException {
        profilePO = loginScreenPO.openProfilePage();
        loginScreenPO.verifyCompanyUserLoggedIn();
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
