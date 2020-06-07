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

public class LoginWithGoogleAccountAndroid extends BaseTest {
    public String testName = "Login with Google account on Android device: ";
    //public String buildNum = "5.1.0 QA";
    //public String deviceName = "Google Pixel 3";
    //public String OS_version = "10.0";
    public HomeScreenPO homeScreenPO;
    public LoginScreenPO loginScreenPO;
    public ProfilePO profilePO;

    @Test(priority = 1)
    public void openApplication() throws InterruptedException {
        homeScreenPO = new HomeScreenPO(androidDriver);
    }

    @Test(priority = 2)
    public void openLoginPage() throws InterruptedException {
        loginScreenPO = homeScreenPO.tapOnGetStartedButton();
    }

    @Test(priority = 3)
    public void openGoogleOAuth() throws InterruptedException {
        loginScreenPO.openGoogleAuth();
    }

    @Test(priority = 4)
    public void loginwithGoogleAccount () throws InterruptedException {
        loginScreenPO.loginWithGoogleAccount(PropertyUtils.getProperty("qa.google.employee.email"), PropertyUtils.getProperty("qa.google.employee.password"));
    }

    @Test(priority = 5)
    public void verifyLoggedIn () throws InterruptedException {
        loginScreenPO.switchBackToNativeApp();
        profilePO = loginScreenPO.openProfilePage();
        loginScreenPO.verifyEmployeeUserLoggedIn();
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
