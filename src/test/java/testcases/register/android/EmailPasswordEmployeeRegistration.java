package testcases.register.android;

import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.AccountSetupScreenPO;
import pageobjects.HomeScreenPO;
import pageobjects.LoginScreenPO;
import pageobjects.RegisterScreenPO;
import testcases.BaseTest;
import utils.HttpUtils;
import utils.PropertyUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class EmailPasswordEmployeeRegistration extends BaseTest {
    public String testName = "Register with email/password employee account on Android device: ";
    public HomeScreenPO homeScreenPO;
    public LoginScreenPO loginScreenPO;
    public RegisterScreenPO registerScreenPO;
    public AccountSetupScreenPO accountSetupScreenPO;
    public String emailCode;

    @Test(priority = 1)
    public void openApplication() throws InterruptedException {
        homeScreenPO = new HomeScreenPO(androidDriver);
    }

    @Test(priority = 2)
    public void openLoginPage() throws InterruptedException {
        loginScreenPO = homeScreenPO.tapOnGetStartedButton();
    }

    @Test(priority = 3)
    public void openRegisterPage() throws InterruptedException {
        registerScreenPO = loginScreenPO.tapOnRegisterButton();
    }

    @Test(priority = 4)
    public void enterEmployeeEmail () throws InterruptedException {
        registerScreenPO.enterEmployeeEmail(PropertyUtils.getProperty("qa.employee.email"));
    }

    @Test(priority = 5)
    public void enterEmployeePassword () throws InterruptedException {
        registerScreenPO.enterEmployeePassword(PropertyUtils.getProperty("qa.employee.password"));
    }

    @Test(priority = 6)
    public void confirmEmployeePassword () throws InterruptedException {
        registerScreenPO.confirmEmployeePassword(PropertyUtils.getProperty("qa.employee.password"));
    }

    @Test(priority = 7)
    public void clickRegister () throws InterruptedException {
        registerScreenPO.clickSignup();
        Thread.sleep(10000);
    }

    @Test(priority = 8)
    public void verifyEmail () throws MalformedURLException, InterruptedException {
        try{
            verifyEmailRegistration();
        }catch (IOException e){
            System.out.println(e.toString());
        }
        Thread.sleep(10000);
        System.out.println(emailCode);
        Assert.assertNotEquals(emailCode, null);
    }

    @Test(priority = 9)
    public void enterEmailCode() throws InterruptedException{
        registerScreenPO.enterEmailCode(emailCode);
    }

    @Test(priority = 10)
    public void agreeToTerms() throws InterruptedException{
        registerScreenPO.agreeToTerms();
    }

    @Test(priority = 11)
    public void allowPermissions() throws InterruptedException{
        accountSetupScreenPO = registerScreenPO.allowPermissions();
    }

    @Test(priority = 12)
    public void chooseEmployeeAccountType() throws InterruptedException {
        accountSetupScreenPO.chooseEmployeeAccountType();
    }

    @Test(priority = 13)
    public void enterEmployeeData() throws InterruptedException {
        accountSetupScreenPO.enterEmployeePersonalData();
    }

    @Test(priority = 14)
    public void chooseEmployeeProfession() throws InterruptedException {
        accountSetupScreenPO.chooseEmployeeProfession("CDA");
    }

    @Test(priority = 15)
    public void chooseAvailabilityEmployee() throws InterruptedException {
        accountSetupScreenPO.chooseAvailabilityEmployee("Tuesday 28/April/2020");
    }

    @Test(priority = 16)
    public void choosePracticeTypeEmployee() throws InterruptedException {
        accountSetupScreenPO.choosePracticeTypeEmployee("General");
    }

    @Test(priority = 17)
    public void chooseLanguageEmployee() throws InterruptedException {
        accountSetupScreenPO.chooseLanguageEmployee("English");
    }

    @Test(priority = 18)
    public void chooseSoftwareSystemsEmployee() throws InterruptedException {
        accountSetupScreenPO.chooseSoftwareSystemsEmployee("Gold");
    }

    @Test(priority = 19)
    public void chooseTravelOptionEmployee() throws InterruptedException {
        accountSetupScreenPO.chooseTravelOptionsEmployee("Vehicle");
    }

    @Test(priority = 20)
    public void chooseHourlyRateEmployee() throws InterruptedException {
        accountSetupScreenPO.chooseHourlyRateEmployee();
    }

    @Test(priority = 21)
    public void addCertificateEmployee() throws InterruptedException {
        accountSetupScreenPO.addCertificateEmployee();
    }

    @Test(priority = 22)
    public void skipVideoEmployee() throws InterruptedException {
        accountSetupScreenPO.skipVideoEmployee();
    }

    @Test(priority = 23)
    public void proceedToProfileEmployee() throws InterruptedException {
        accountSetupScreenPO.showMyProfileEmployee();
        loginScreenPO.verifyEmployeeUserLoggedIn();
    }

    @Parameters({"device-name", "android-version"})
    @BeforeTest
    @Override
    public void setUpPage(String deviceName, String androidVersion) throws MalformedURLException {
        try{
            deleteUser(getToken());
        }catch (IOException e){
            System.out.println(e.toString());
        }
        this.testCaseName = testName;
        this.deviceNameBase = PropertyUtils.getProperty(deviceName);
        this.OS_versionBase = androidVersion;
        androidDriver = new AndroidDriver(new URL(APPIUM_SERVER_URL), getDesiredCapabilitiesForAndroid());
    }

    private void deleteUser(String token) throws IOException, MalformedURLException {
        try{
            HttpUtils.createDeleteRequest(PropertyUtils.getProperty("qa.employee.email"), token);
        }catch(IOException e){
            System.out.println(e.toString());
        }
    }

    private String getToken() throws IOException {
        return HttpUtils.getAccessToken();
    }

    private void verifyEmailRegistration () throws IOException, MalformedURLException {
        try {
            emailCode = HttpUtils.createPostRequest(PropertyUtils.getProperty("qa.employee.email"));
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
