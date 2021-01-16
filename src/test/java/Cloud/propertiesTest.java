package Cloud;

import InitialSettings.InitialImpl;
import com.kivanc.common.Common;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static org.testng.Assert.*;

public class propertiesTest {

    public static InitialImpl initialDriver;
    public static AndroidDriver<MobileElement> driver;

    public static By cloudTab = By.xpath("//android.widget.TextView[@text='Cloud']");
    public static By manageStorageTab = By.xpath("//android.widget.TextView[@text='MANAGE STORAGE']");
    public static By upgradeStorage = By.id("com.huawei.hidisk:id/upgrade_space_entrance");
    public static By currentPlanSize = By.id("com.huawei.hidisk:id/upgrade_user_capacity");
    public static By androidClearButton = By.id("com.huawei.android.launcher:id/clear_all_recents_image_button");

    @BeforeMethod
    public void setUp() throws MalformedURLException, InterruptedException{
        initialDriver= new InitialImpl("HUAWEI P40 lite","EPHUT20429006493","com.huawei.hwid","com.huawei.hwid20.AccountCenter.CenterActivity");
        driver = initialDriver.getDriver();
        System.out.println("Test is starting!");
    }

    @AfterMethod
    public void tearDown() {
        Common.basicKeyProcesses(driver,"Appswitch");
        driver.findElement(androidClearButton).click();
        System.out.println("All Tests Completed");
    }

    @Test
    public void testTest1() {
        driver.findElement(cloudTab).click();
        driver.findElement(manageStorageTab).click();
        driver.findElement(upgradeStorage).click();

        if (driver.findElement(currentPlanSize).getText().equals("5 GB")){
            System.out.println("Test is Successful");
        }
        else {

            System.out.println("Test is Failed");
        }

        //Common.basicKeyProcesses(driver,"back");
        //Common.basicKeyProcesses(driver,"home");




    }
}