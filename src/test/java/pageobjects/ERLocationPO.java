package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import utils.AppiumUtils;

import java.util.concurrent.TimeUnit;

public class ERLocationPO extends BasePO {
    public ERLocationPO (AppiumDriver driver){super(driver);}
    public void addAddress(String address){
        AndroidElement addressField = (AndroidElement) driver.findElementsByClassName("android.widget.EditText").get(0);
        addressField.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.EditText[@text='Search']")).sendKeys(address);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Vancouver-Blaine Highway']")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
    public void increaseNumberOfOperatories(){
        /*AndroidElement seekBar = (AndroidElement) driver.findElement(By.xpath("//android.widget.SeekBar"));
        int x = seekBar.getLocation().getX();
        int y = seekBar.getLocation().getY();
        appiumUtils.clickOnPoint(x+100,y, driver);*/
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
    public void scrollDown() {
        AppiumUtils.verticalScroll(driver);
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
    }
    public void saveLocation(){
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Save']")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
}
