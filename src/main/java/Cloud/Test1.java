package Cloud;
import InitialSettings.*;
import com.sun.org.apache.xml.internal.security.Init;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import jdk.nashorn.internal.parser.JSONParser;
import org.openqa.selenium.By;
import io.appium.java_client.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.json.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Selector;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test1 {


    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        properties.createDriverForService();
        properties.test1();
        /* InitialImpl initialDriver= new InitialImpl("HUAWEI P40 lite","EPHUT20429006493","com.huawei.hwid","com.huawei.hwid20.AccountCenter.CenterActivity");


        AndroidDriver<MobileElement> driver = initialDriver.getDriver();


        properties.test1();
        driver.findElement(properties.cloudTab).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='MANAGE STORAGE']")).click(); */


    }

}
