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

public class EmailPasswordEmployerRegistration extends BaseTest {
    public String testName = "Register with email/password employer account on Android device: ";
    public HomeScreenPO homeScreenPO;
    public LoginScreenPO loginScreenPO;
    public RegisterScreenPO registerScreenPO;
    public AccountSetupScreenPO accountSetupScreenPO;
    private String emailCode;

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
    public void enterCompanyEmail () throws InterruptedException {
        registerScreenPO.enterCompanyEmail(PropertyUtils.getProperty("qa.company.email"));
    }

    @Test(priority = 5)
    public void enterCompanyPassword () throws InterruptedException {
        registerScreenPO.enterCompanyPassword(PropertyUtils.getProperty("qa.company.password"));
    }

    @Test(priority = 6)
    public void confirmCompanyPassword () throws InterruptedException {
        registerScreenPO.confirmCompanyPassword(PropertyUtils.getProperty("qa.company.password"));
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
    public void chooseEmployerAccountType() throws InterruptedException{
        accountSetupScreenPO.chooseEmployerAccountType();
    }

    @Test(priority = 13)
    public void enterCompanyData () throws InterruptedException{
        accountSetupScreenPO.enterCompanyData();
    }

    @Test(priority = 14)
    public void setCompanySoftwareSystems() throws InterruptedException{
        accountSetupScreenPO.chooseCompanySoftwareSystems();
    }

    @Test(priority = 15)
    public void proceedToCompanyProfile () throws InterruptedException{
        accountSetupScreenPO.proceedToCompanyProfile();
    }

    @Test(priority = 16)
    public void verifyLoggedin()throws InterruptedException{
        //accountSetupScreenPO.allowPermissions();
        loginScreenPO.verifyCompanyUserLoggedIn();
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
            HttpUtils.createDeleteRequest(PropertyUtils.getProperty("qa.company.email"), token);
        }catch(IOException e){
            System.out.println(e.toString());
        }
    }

    private String getToken() throws IOException {
        return HttpUtils.getAccessToken();
    }

    private void verifyEmailRegistration () throws IOException, MalformedURLException {
        try {
            emailCode = HttpUtils.createPostRequest(PropertyUtils.getProperty("qa.company.email"));
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
