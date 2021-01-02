package Cloud;

import InitialSettings.InitialImpl;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.springframework.util.Assert;
import java.net.MalformedURLException;

public class properties {

    // Driver
    public static InitialImpl initialDriver;
    public static AndroidDriver<MobileElement> driver;

    // Cloud Elements
    public static By cloudTab = By.xpath("//android.widget.TextView[@text='Cloud']");
    public static By manageStorageTab = By.xpath("//android.widget.TextView[@text='MANAGE STORAGE']");
    public static By upgradeStorage = By.id("com.huawei.hidisk:id/upgrade_space_entrance");
    public static By currentPlanSize = By.id("com.huawei.hidisk:id/upgrade_user_capacity");

    public static void createDriverForService() throws MalformedURLException, InterruptedException {
        initialDriver= new InitialImpl("HUAWEI P40 lite","EPHUT20429006493","com.huawei.hwid","com.huawei.hwid20.AccountCenter.CenterActivity");
        driver = initialDriver.getDriver();
    }

    public static void test1() throws MalformedURLException, InterruptedException {

        driver.findElement(cloudTab).click();
        driver.findElement(manageStorageTab).click();
        driver.findElement(upgradeStorage).click();

        if (driver.findElement(currentPlanSize).getText().equals("5 GB")){
            System.out.println("Test is Successful");
        }
        else {

            System.out.println("Test is Failed");
        }


    }

}
