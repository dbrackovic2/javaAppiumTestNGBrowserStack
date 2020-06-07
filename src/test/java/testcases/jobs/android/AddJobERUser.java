package testcases.jobs.android;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;
import pageobjects.ERLocationPO;
import pageobjects.HomeScreenPO;
import pageobjects.LoginScreenPO;
import pageobjects.ProfilePO;
import testcases.BaseTest;

import java.net.MalformedURLException;
import java.net.URL;

public class AddJobERUser extends BaseTest {
    public String testName = "Add job as ER user on Android device: ";
    public String buildNum = "5.3.0 QA";
    public String deviceName = "Samsung Galaxy Note 10 Plus";
    public String OS_version = "9.0";
    public HomeScreenPO homeScreenPO;
    public LoginScreenPO loginScreenPO;
    public ProfilePO profilePO;
    public ERLocationPO erLocationPO;

    @BeforeTest
    @Override
    public void setUpPage(String a, String b) throws MalformedURLException {
        this.testCaseName = testName;
        this.buildNumber = buildNum;
        this.deviceNameBase = deviceName;
        this.OS_versionBase = OS_version;
        androidDriver = new AndroidDriver(new URL(APPIUM_SERVER_URL), getDesiredCapabilitiesForAndroid());
    }
}
