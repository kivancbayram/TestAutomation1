package InitialSettings;

import com.sun.org.apache.xpath.internal.operations.And;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.grpc.netty.shaded.io.netty.handler.ssl.JdkApplicationProtocolNegotiator;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.LoggerFactory;
import java.io.Flushable;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Selector;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class InitialImpl {

    private static String deviceName;
    private static String deviceUDID;
    private static String appPackage;
    private static String appActivity;
    public static AppiumDriver<MobileElement> appiumDriver;
    protected static FluentWait<AndroidDriver> appiumFluentWait;
    protected static Selector selector;
    protected boolean localAndroid = true;
    //private Logger logger = LoggerFactory.getLogger(getClass();

    public AndroidDriver<MobileElement> getDriver(){

        return (AndroidDriver<MobileElement>) appiumDriver;
    }

    public InitialImpl(String deviceName, String deviceUDID, String appPackage, String appActivity) throws MalformedURLException, InterruptedException {
        this.deviceName= deviceName;
        this.deviceUDID= deviceUDID;
        this.appPackage= appPackage;
        this.appActivity= appActivity;
        String appiumURL=null;
        String adbPort=null;


        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, this.deviceName);
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, this.deviceUDID);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,300);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,this.appPackage);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,this.appActivity);
        desiredCapabilities.setCapability("resetKeyboard",false);
        desiredCapabilities.setCapability("unicodeKeyboard",false);
        desiredCapabilities.setCapability("autoGrantPermissions",true);

        if (adbPort !=null){
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.ADB_PORT,adbPort);
        }

        URL url = new URL("http://localhost:4723/wd/hub");
        if (appiumURL !=null){
            url=new URL(appiumURL);
        }

        appiumDriver = new AndroidDriver(url, desiredCapabilities);
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        appiumFluentWait = new FluentWait(appiumDriver);
        appiumFluentWait.withTimeout(Duration.ofSeconds(3)).pollingEvery(Duration.ofMillis(200));

    }

   /* public static AndroidDriver<MobileElement> beforeScenario(String deviceName) throws MalformedURLException, InterruptedException {
        String deviceName="HUAWEI P40 lite";
        String deviceUDID="EPHUT20429006493";
        String appPackage="com.huawei.hwid";
        String appActivity="com.huawei.hwid20.AccountCenter.CenterActivity";
        String appiumURL=null;
        String adbPort=null;

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, deviceUDID);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,300);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,appPackage);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,appActivity);
        desiredCapabilities.setCapability("resetKeyboard",false);
        desiredCapabilities.setCapability("unicodeKeyboard",false);
        desiredCapabilities.setCapability("autoGrantPermissions",true);

        if (adbPort !=null){
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.ADB_PORT,adbPort);
        }

        URL url = new URL("http://localhost:4723/wd/hub");
        if (appiumURL !=null){
            url=new URL(appiumURL);
        }

        appiumDriver = new AndroidDriver(url, desiredCapabilities);
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        appiumFluentWait = new FluentWait(appiumDriver);
        appiumFluentWait.withTimeout(Duration.ofSeconds(3)).pollingEvery(Duration.ofMillis(200));





    }  */



}
