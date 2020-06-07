package testcases.location.android;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.ERLocationPO;
import pageobjects.HomeScreenPO;
import pageobjects.LoginScreenPO;
import pageobjects.ProfilePO;
import testcases.BaseTest;

import java.net.MalformedURLException;
import java.net.URL;

public class AddLocationERUser extends BaseTest {
    public String testName = "Add Location as ER user on Android device: ";
    public HomeScreenPO homeScreenPO;
    public LoginScreenPO loginScreenPO;
    public ProfilePO profilePO;
    public ERLocationPO erLocationPO;

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
    public void openLocationView () throws InterruptedException {
        profilePO = loginScreenPO.openProfilePage();
        erLocationPO = profilePO.openLocationsView();
    }

    @Test(priority = 4)
    public void addAddress() throws InterruptedException {
        erLocationPO.addAddress("Vancouver-Blaine Highway, Surrey, BC, Canada");
    }

    @Test(priority = 5)
    public void scrollDown() throws InterruptedException {
        //erLocationPO.increaseNumberOfOperatories();
        erLocationPO.scrollDown();
    }

    @Test(priority = 6)
    public void saveLocation() throws InterruptedException {
        erLocationPO.saveLocation();
    }

    @Test(priority = 7)
    public void verifyProfilePageOpened() throws InterruptedException {
        loginScreenPO.verifyCompanyUserLoggedIn();
    }

    @Parameters({"device-name", "android-version"})
    @BeforeTest
    @Override
    public void setUpPage(String deviceName, String androidVersion) throws MalformedURLException {
        this.testCaseName = testName;
        this.deviceNameBase = deviceName;
        this.OS_versionBase = androidVersion;
        androidDriver = new AndroidDriver(new URL(APPIUM_SERVER_URL), getDesiredCapabilitiesForAndroid());
    }
}
