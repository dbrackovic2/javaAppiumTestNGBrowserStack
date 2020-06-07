package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import utils.AppiumUtils;

import java.util.concurrent.TimeUnit;

public class AccountSetupScreenPO extends BasePO {
    public AccountSetupScreenPO (AppiumDriver driver){super(driver);}
    public void chooseEmployerAccountType (){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Employer']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void enterCompanyData(){
        AndroidElement companyName = (AndroidElement) driver.findElementsByClassName("android.widget.EditText").get(0);
        AndroidElement aboutUs = (AndroidElement) driver.findElementsByClassName("android.widget.EditText").get(2);
        companyName.sendKeys("Teeth Bleech");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        aboutUs.sendKeys("Dejan QA automation test company");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.Button[@text='Next']")).click();
    }
    public void chooseCompanySoftwareSystems(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Gold']")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.Button[@text='Next']")).click();
    }
    public void proceedToCompanyProfile(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.Button[@text='Skip']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.Button[@text='Go to Profile']")).click();
    }
    public void allowPermissions() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        ((AndroidElement)driver.findElements(By.xpath("//android.widget.Button[contains(@text, 'Allow')]")).get(0)).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ((AndroidElement)driver.findElements(By.xpath("//android.widget.Button[contains(@text, 'Allow')]")).get(0)).click();
    }
    //Employee
    public void chooseEmployeeAccountType (){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Employee']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void enterEmployeePersonalData(){
        AndroidElement firstName = (AndroidElement) driver.findElementsByClassName("android.widget.EditText").get(0);
        AndroidElement lastName = (AndroidElement) driver.findElementsByClassName("android.widget.EditText").get(1);
        AndroidElement dateOfBirth = (AndroidElement) driver.findElementsByClassName("android.widget.EditText").get(2);
        AndroidElement address = (AndroidElement) driver.findElementsByClassName("android.widget.EditText").get(3);
        AndroidElement aboutMe = (AndroidElement) driver.findElementsByClassName("android.widget.EditText").get(4);
        firstName.sendKeys("AutoEE");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        lastName.sendKeys("Hotmail");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        address.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        enterAddress("Vancouver-Blaine Highway, Surrey, BC, Canada");
        aboutMe.sendKeys("Automation test EE account setup");
        AppiumUtils.verticalScroll(driver);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Next']")).click();
    }
    private void enterAddress(String address){
        driver.findElement(By.xpath("//android.widget.EditText[@text='Search']")).sendKeys(address);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Vancouver-Blaine Highway']")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
    public void chooseEmployeeProfession (String profession) {
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        if(profession == "CDA"){
            driver.findElement(By.xpath("//android.widget.TextView[@text='Certified Dental Assistant']")).click();
        }
        else if (profession == "RDH"){
            driver.findElement(By.xpath("//android.widget.TextView[@text='Registered Dental Hygienist']")).click();
        }
        else {
            driver.findElement(By.xpath("//android.widget.TextView[@text='Dental Receptionist']")).click();
        }
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Next']")).click();
    }
    public void chooseAvailabilityEmployee (String date){//DayName DD/Month/YYYY  - format
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId(date).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        AppiumUtils.verticalScroll(driver);
        AndroidElement btnNext = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='Next']"));
        btnNext.click();
    }
    public void choosePracticeTypeEmployee (String type){//General
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        AndroidElement seekBar = (AndroidElement) driver.findElement(By.xpath("//android.widget.SeekBar"));
        int x = seekBar.getLocation().getX();
        int y = seekBar.getLocation().getY();
        appiumUtils.clickOnPoint(x+100,y, driver);
        AppiumUtils.verticalScroll(driver);
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+type+"']")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Next']")).click();
    }
    public void chooseLanguageEmployee (String language) {//English
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+language+"']")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Next']")).click();
    }
    public void chooseSoftwareSystemsEmployee(String system){//Gold
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+system+"']")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Next']")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //((AndroidElement)driver.findElements(By.xpath("//android.widget.Button[contains(@text, 'Allow')]")).get(0)).click();
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //((AndroidElement)driver.findElements(By.xpath("//android.widget.Button[contains(@text, 'Allow')]")).get(0)).click();
    }
    public void chooseTravelOptionsEmployee(String option){//Vehicle
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        //driver.findElement(By.xpath("//android.widget.TextView[@text='"+option+"']")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Next']")).click();
    }
    public void chooseHourlyRateEmployee (){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        AndroidElement seekBar = (AndroidElement) driver.findElement(By.xpath("//android.widget.SeekBar"));
        int x = seekBar.getLocation().getX();
        int y = seekBar.getLocation().getY();
        appiumUtils.clickOnPoint(x+100,y, driver);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Next']")).click();
    }
    public void addCertificateEmployee(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Add Certificate']")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        ((AndroidElement)driver.findElements(By.xpath("//android.widget.Button[contains(@text, 'Allow')]")).get(0)).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Pictures']")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        AndroidElement photo = (AndroidElement) driver.findElements(By.xpath("//android.view.ViewGroup")).get(1);
        photo.click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Next']")).click();
    }
    public void skipVideoEmployee(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.Button[@text='Skip']")).click();
    }
    public void showMyProfileEmployee(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.Button[@text='Show My Profile']")).click();
    }
}
