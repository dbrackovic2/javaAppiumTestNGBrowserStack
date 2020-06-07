package testcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.AssertUtils;
import utils.PropertyUtils;
import utils.ScreenshotUtility;
import utils.WaitUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Listeners({ScreenshotUtility.class})
public abstract class BaseTest {
    /*** As driver static it will be created only once and used across all of the test classes.*/
    public static AppiumDriver driver;
    public static AndroidDriver androidDriver;
    public static IOSDriver iosDriver;
    public final static String APPIUM_SERVER_URL = PropertyUtils.getProperty("appium.server.url", "http://127.0.0.1:4723/wd/hub");
    public final static int IMPLICIT_WAIT = PropertyUtils.getIntegerProperty("implicitWait", 30);
    public static WaitUtils waitUtils = new WaitUtils();
    public static AssertUtils assertUtils = new AssertUtils();
    public static String testCaseName;
    public static String buildNumber;
    public static String deviceNameBase;
    public static String OS_versionBase;
    /*** This method will run at the time of Test Suite creation so it will run at once through out the execution* <p>* Appium is a client - server model:* So we need to set up appium client in order to connect to Device Farm's appium server.*/
    @BeforeMethod
    public void setUpAppium() {}
    /*** This method will be called everytime before your test runs*/
    @BeforeTest
    public abstract void setUpPage(String deviceName, String androidVersion) throws IOException;
    /*** This method will always execute after each test case, This will quit the WebDriver instance called at the last*/
    @AfterMethod(alwaysRun = true)
    public void afterMethod(final ITestResult result) throws IOException {
        String fileName = result.getTestClass().getName() + "_" + result.getName();
        System.out.println("Test Case: [" + fileName + "] executed..!");
    }
    /*** This method will be called after class finishes the execution of all tests*/
    @AfterClass
    public void afterClass() {}
    /*** At the end of the Test Suite(At last) this method would be called*/
    @AfterSuite
    public void tearDownAppium() {
        quitDriver();
    }
    /*** It will set the DesiredCapabilities for the local execution** @param desiredCapabilities*/
    protected DesiredCapabilities getDesiredCapabilitiesForAndroid() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        String PLATFORM_NAME = PropertyUtils.getProperty("android.platform");
        String PLATFORM_VERSION = PropertyUtils.getProperty("android.platform.version");
        String BUILD_NUMBER = PropertyUtils.getProperty("android.build.number");
        String APP_NAME = PropertyUtils.getProperty("android.app.name");
        String DEVICE_NAME = PropertyUtils.getProperty("android.device.name");
        String APP_FULL_RESET = PropertyUtils.getProperty("android.app.full.reset");
        String APP_NO_RESET = PropertyUtils.getProperty("android.app.no.reset");
        String APP_NO_SIGN = PropertyUtils.getProperty("android.app.no.sign");
        String AUTOMATION_NAME = PropertyUtils.getProperty("android.automation.name");
        String AUTO_GRANT_PERMISSIONS = PropertyUtils.getProperty("android.app.permissions");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AUTOMATION_NAME);
        desiredCapabilities.setCapability("browserstack.appium_version", "1.15.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, (deviceNameBase!=null)? deviceNameBase : DEVICE_NAME);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,(OS_versionBase!=null)? OS_versionBase : PLATFORM_VERSION);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, APP_NAME);
        desiredCapabilities.setCapability("project", "OpenTemp Project");
        desiredCapabilities.setCapability("build",  (deviceNameBase!=null)? BUILD_NUMBER + deviceNameBase : BUILD_NUMBER + DEVICE_NAME);
        desiredCapabilities.setCapability("name",(deviceNameBase!=null)? testCaseName + deviceNameBase : testCaseName + DEVICE_NAME);
        desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, APP_FULL_RESET);
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, APP_NO_RESET);
        desiredCapabilities.setCapability("setWebContentsDebuggingEnabled", "true");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.NO_SIGN, APP_NO_SIGN);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, AUTO_GRANT_PERMISSIONS);
        return desiredCapabilities;
    }

    protected DesiredCapabilities getDesiredCapabilitiesForiOS() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        String PLATFORM_NAME = PropertyUtils.getProperty("ios.platform");
        String PLATFORM_VERSION = PropertyUtils.getProperty("ios.platform.version");
        String BUILD_NUMBER = PropertyUtils.getProperty("ios.build.number");
        String APP_NAME = PropertyUtils.getProperty("ios.app.name");
        String DEVICE_NAME = PropertyUtils.getProperty("ios.device.name");
        String APP_FULL_RESET = PropertyUtils.getProperty("ios.app.full.reset");
        String APP_NO_RESET = PropertyUtils.getProperty("ios.app.no.reset");
        String AUTO_ACCEPTS_ALERTS = PropertyUtils.getProperty("ios.app.auto.accept.alerts");
        //desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        //desiredCapabilities.setCapability("browserstack.appium_version", "1.15.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, (deviceNameBase!=null)? deviceNameBase : DEVICE_NAME);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, (OS_versionBase!=null)? OS_versionBase : PLATFORM_VERSION);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, APP_NAME);
        desiredCapabilities.setCapability("project", "OpenTemp Project");
        desiredCapabilities.setCapability("build", (deviceNameBase!=null)? BUILD_NUMBER + deviceNameBase : BUILD_NUMBER + DEVICE_NAME);
        desiredCapabilities.setCapability("name",(deviceNameBase!=null)? testCaseName + deviceNameBase : testCaseName + DEVICE_NAME);
        desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, APP_FULL_RESET);
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, APP_NO_RESET);
        desiredCapabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, AUTO_ACCEPTS_ALERTS);
        return desiredCapabilities;
    }
    private void takeLocalScreenshot(String imageName) throws IOException {
        File scrFile = ((TakesScreenshot) androidDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("failureScreenshots/" + imageName + ".png"));
    }
    public static WebDriver getScreenshotableWebDriver() {
        if(androidDriver!=null){
            final WebDriver augmentedDriver = new Augmenter().augment(androidDriver);
            return augmentedDriver;
        }else{
            final WebDriver augmentedDriver = new Augmenter().augment(iosDriver);
            return augmentedDriver;
        }
    }
    /**This will set implicit wait ** @param driver*/
    private static void setTimeOuts(AppiumDriver driver) {
        //Use a higher value if your mobile elements take time to show up
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
    }
    private static String getAbsolutePath(String appRelativePath) {
        File file = new File(appRelativePath);
        return file.getAbsolutePath();
    }
    /*** This will quit the android driver instance*/
    private void quitDriver() {
        try {
            this.androidDriver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
