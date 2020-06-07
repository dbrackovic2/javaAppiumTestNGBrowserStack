package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import utils.PropertyUtils;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LoginScreenPO extends BasePO{

    public LoginScreenPO (AppiumDriver driver){super(driver);}
    public ProfilePO openProfilePage(){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        ((AndroidElement)driver.findElements(By.xpath("//android.widget.Button[contains(@text, 'Allow')]")).get(0)).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        ((AndroidElement)driver.findElements(By.xpath("//android.widget.Button[contains(@text, 'Allow')]")).get(0)).click();
        return new ProfilePO(driver);
    }
    public ProfilePO openProfilePageiOS(){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        if(driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name, \"Allow\")]"))==null){
            System.out.println("No location popup dipslayed");
        }else {
            driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@name, \"Allow\")]")).click();
        }
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        if(driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"OK\"]"))==null){
            System.out.println("No camera access popup");
        }else {
            driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"OK\"]\n")).click();
        }
        return new ProfilePO(driver);
    }
    public RegisterScreenPO tapOnRegisterButton (){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("RegisterButton").click();
        //waitUtils.waitForElementToBeVisible(homeScreenGetStartedButton, driver);
        //homeScreenGetStartedButton.click();
        System.out.println("Clicked Register");
        return new RegisterScreenPO(driver);
    }
    public void loginWithEmployeeEmailPassAndroid (){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("Email Address. EditBox, Double tap to enter the text").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByClassName("android.widget.EditText").sendKeys(PropertyUtils.getProperty("qa.employee.email"));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("Password. EditBox, Double tap to enter the text").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        AndroidElement pass = (AndroidElement) driver.findElementsByClassName("android.widget.EditText").get(1);
        pass.sendKeys(PropertyUtils.getProperty("qa.employee.password"));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@text='SIGN IN']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public AccountSetupScreenPO loginWithEmployeeEmailPassAndroidSetup(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("Email Address. EditBox, Double tap to enter the text").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByClassName("android.widget.EditText").sendKeys("email@email.com");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("Password. EditBox, Double tap to enter the text").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        AndroidElement pass = (AndroidElement) driver.findElementsByClassName("android.widget.EditText").get(1);
        pass.sendKeys("Sarajevo123");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@text='SIGN IN']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new AccountSetupScreenPO(driver);
    }
    public void loginWithCompanyEmailPassAndroid (){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("Email Address. EditBox, Double tap to enter the text").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByClassName("android.widget.EditText").sendKeys(PropertyUtils.getProperty("qa.company.email"));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("Password. EditBox, Double tap to enter the text").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        AndroidElement pass = (AndroidElement) driver.findElementsByClassName("android.widget.EditText").get(1);
        pass.sendKeys(PropertyUtils.getProperty("qa.company.password"));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@text='SIGN IN']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public AccountSetupScreenPO loginWithCompanyEmailPassAndroidSetup (){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("Email Address. EditBox, Double tap to enter the text").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByClassName("android.widget.EditText").sendKeys("dejan@qaengineers.net");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("Password. EditBox, Double tap to enter the text").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        AndroidElement pass = (AndroidElement) driver.findElementsByClassName("android.widget.EditText").get(1);
        pass.sendKeys("Sarajevo123");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@text='SIGN IN']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new AccountSetupScreenPO(driver);
    }
    public void loginWithCompanyEmailPassiOS() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"Email Address\"])[1]").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByXPath("//XCUIElementTypeTextField[@name=\"Email Address\"]").sendKeys(PropertyUtils.getProperty("qa.company.email")+"\n");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Password\"]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//XCUIElementTypeSecureTextField[@name=\"Password\"])[1]")).sendKeys(PropertyUtils.getProperty("qa.company.password")+"\n");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"SignInSfButton\"])[1]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void loginWithEmployeeEmailPassiOS() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"Email Address\"])[1]").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByXPath("//XCUIElementTypeTextField[@name=\"Email Address\"]").sendKeys(PropertyUtils.getProperty("qa.employee.email")+"\n");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Password\"]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//XCUIElementTypeSecureTextField[@name=\"Password\"])[1]")).sendKeys(PropertyUtils.getProperty("qa.employee.password")+"\n");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"SignInSfButton\"])[1]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void loginWrongPassword () {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("Email Address. EditBox, Double tap to enter the text").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByClassName("android.widget.EditText").sendKeys(PropertyUtils.getProperty("qa.company.email"));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("Password. EditBox, Double tap to enter the text").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        AndroidElement pass = (AndroidElement) driver.findElementsByClassName("android.widget.EditText").get(1);
        pass.sendKeys("Sarajevo");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@text='SIGN IN']")).click();
    }
    public void loginWrongPasswordiOS(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"Email Address\"])[1]").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByXPath("//XCUIElementTypeTextField[@name=\"Email Address\"]").sendKeys(PropertyUtils.getProperty("qa.company.email")+"\n");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Password\"]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//XCUIElementTypeSecureTextField[@name=\"Password\"])[1]")).sendKeys("Sarajevo\n");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"SignInSfButton\"])[1]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void loginWrongEmail(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("Email Address. EditBox, Double tap to enter the text").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByClassName("android.widget.EditText").sendKeys("dejanqaengineers.net");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("Password. EditBox, Double tap to enter the text").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        AndroidElement pass = (AndroidElement) driver.findElementsByClassName("android.widget.EditText").get(1);
        pass.sendKeys("Sarajevo");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@text='SIGN IN']")).click();
    }
    public void loginWrongEmailiOS(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"Email Address\"])[1]").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByXPath("//XCUIElementTypeTextField[@name=\"Email Address\"]").sendKeys("dejanqaengineers.net\n");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Password\"]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//XCUIElementTypeSecureTextField[@name=\"Password\"])[1]")).sendKeys("Sarajevo\n");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"SignInSfButton\"])[1]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void openGoogleAuth () throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        AndroidElement element = (AndroidElement) driver.findElements(By.xpath("//android.widget.ImageView")).get(2);
        element.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Chrome']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementById("android:id/button_once").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void loginWithGoogleAccount(String email, String password) throws InterruptedException{
        Thread.sleep(10000);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            if (contextName.contains("WEBVIEW")){
                driver.context(contextName);
            }
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys(email);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("div#identifierNext")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys(password);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("div#passwordNext")).click();
    }
    public void switchBackToNativeApp() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            if (contextName.contains("NATIVE")){
                driver.context(contextName);
            }
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void verifyWrongPassword(){
        if(assertUtils.isElementDisplayed((AndroidElement)driver.findElement(By.xpath("//android.widget.TextView[@text='Login failed.']")))) {
            System.out.println("Wrong password - Login failed");
        } else {
            System.out.println("something wrong");
        }
    }
    public void verifyWrongPasswordiOS(){
        if(assertUtils.isElementDisplayed((IOSElement) driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"SignInSfButton\"])[1]")))) {
            System.out.println("Wrong password - Login failed");
        } else {
            System.out.println("something wrong");
        }
    }
    public void verifyWrongEmail(){
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        appiumUtils.closeAlert(driver);
    }
    public void verifyCompanyUserLoggedIn (){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        if(assertUtils.isElementDisplayed((AndroidElement)driver.findElement(By.xpath("//android.widget.TextView[@text='Profile']")))){
            System.out.println("Company User Logged In");
        };
    }
    public void verifyCompanyUserLoggediniOS(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        if(assertUtils.isElementDisplayed((IOSElement)driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Profile\"]")))){
            System.out.println("Company User Logged In");
        };
    }
    public void verifyEmployeeUserLoggedIn (){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        if(assertUtils.isElementDisplayed((AndroidElement)driver.findElement(By.xpath("//android.widget.TextView[@text='Profile']")))){
            System.out.println("Employee User Logged in.");
        };
    }
    public void verifyEmployeeUserLoggedIniOS(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        if(assertUtils.isElementDisplayed((IOSElement)driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Profile\"]")))){
            System.out.println("Employee User Logged In");
        };
    }
}
