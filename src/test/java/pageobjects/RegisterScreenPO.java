package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class RegisterScreenPO extends BasePO {
    public RegisterScreenPO (AppiumDriver driver){super(driver);}
    public void enterCompanyEmail(String company){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("Email Address. EditBox, Double tap to enter the text").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByClassName("android.widget.EditText").sendKeys(company);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
    }
    public void enterEmployeeEmail(String employee){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("Email Address. EditBox, Double tap to enter the text").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByClassName("android.widget.EditText").sendKeys(employee);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
    }
    public void enterCompanyPassword(String company){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("Password. EditBox, Double tap to enter the text").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        AndroidElement pass = (AndroidElement) driver.findElementsByClassName("android.widget.EditText").get(1);
        pass.sendKeys(company);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
    }
    public void enterEmployeePassword(String employee){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("Password. EditBox, Double tap to enter the text").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        AndroidElement pass = (AndroidElement) driver.findElementsByClassName("android.widget.EditText").get(1);
        pass.sendKeys(employee);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
    }
    public void confirmCompanyPassword(String company){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("Repeat Password. EditBox, Double tap to enter the text").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        AndroidElement pass = (AndroidElement) driver.findElementsByClassName("android.widget.EditText").get(2);
        pass.sendKeys(company);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
    }
    public void confirmEmployeePassword(String employee){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("Repeat Password. EditBox, Double tap to enter the text").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        AndroidElement pass = (AndroidElement) driver.findElementsByClassName("android.widget.EditText").get(2);
        pass.sendKeys(employee);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
    }
    public void clickSignup(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("SignUpSfButton").click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    public void enterEmailCode(String code){
        AndroidElement first = (AndroidElement) driver.findElementsByClassName("android.widget.EditText").get(0);
        AndroidElement second = (AndroidElement) driver.findElementsByClassName("android.widget.EditText").get(1);
        AndroidElement third = (AndroidElement) driver.findElementsByClassName("android.widget.EditText").get(2);
        AndroidElement fourth = (AndroidElement) driver.findElementsByClassName("android.widget.EditText").get(3);
        first.sendKeys(code.substring(0,1));
        second.sendKeys(code.substring(1,2));
        third.sendKeys(code.substring(2,3));
        fourth.sendKeys(code.substring(3,4));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    public void agreeToTerms(){
        driver.findElement(By.xpath("//android.widget.Button[@text='I Agree']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.Button[@text='Next']")).click();
    }
    public AccountSetupScreenPO allowPermissions(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ((AndroidElement)driver.findElements(By.xpath("//android.widget.Button[contains(@text, 'Allow')]")).get(0)).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        ((AndroidElement)driver.findElements(By.xpath("//android.widget.Button[contains(@text, 'Allow')]")).get(0)).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return new AccountSetupScreenPO(driver);
    }
    public LoginScreenPO backToLoginScreen () {
        return new LoginScreenPO(driver);
    }
}
