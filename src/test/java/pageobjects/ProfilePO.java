package pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class ProfilePO extends BasePO {
    public ProfilePO (AppiumDriver driver){super(driver);}
    public ERLocationPO openLocationsView(){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@text='+ Add Location']")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return new ERLocationPO(driver);
    }
}
