package pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class HomeScreenPO extends  BasePO{
    /*** A base constructor that sets the page's driver* <p>* The page structure is being used within this test in order to separate the* page actions from the tests.* <p>* Please use the AppiumFieldDecorator class within the page factory. This way annotations* like @AndroidFindBy within the page objects.** @param driver the appium driver created in the beforesuite method.*/
    public HomeScreenPO(AppiumDriver driver) {
        super(driver);
    }

    //@AndroidFindBy(xpath = "//android.widget.TextView[@name='Get Started']")
    //AndroidElement homeScreenGetStartedButton;

    //@iOSXCUITFindBy(xpath = "//[@text='Get Started']")
    /*** This method will click on Get started Screen textview.*/
    public LoginScreenPO tapOnGetStartedButton(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.Button[@text='Get Started']")).click();
        //waitUtils.waitForElementToBeVisible(homeScreenGetStartedButton, driver);
        //homeScreenGetStartedButton.click();
        System.out.println("Clicked Get started");
        chooseDental();
        return new LoginScreenPO(driver);
    }
    private void chooseDental(){
        driver.findElement(By.xpath("//android.widget.TextView[@text='Dental']")).click();
    }
    private void choosePharma(){
        driver.findElement(By.xpath("android.widget.TextView[@text='Pharma']")).click();
    }
    private void chooseDentaliOS(){
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Dental\"]")).click();
    }
    private void choosePharmaiOS(){
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Pharma\"]")).click();
    }
    public LoginScreenPO tapOnGetStartedButtoniOS(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Get Started\"]")).click();
        //waitUtils.waitForElementToBeVisible(homeScreenGetStartedButton, driver);
        //homeScreenGetStartedButton.click();
        System.out.println("Clicked Get started");
        chooseDentaliOS();
        return new LoginScreenPO(driver);
    }
}
