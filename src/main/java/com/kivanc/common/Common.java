package com.kivanc.common;

import Cloud.properties;
import InitialSettings.InitialImpl;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.net.MalformedURLException;

public class Common {
    public static InitialImpl commonInitialDriver;
    public static AndroidDriver<MobileElement> commonDriver;
    public static void createDriverForService() throws MalformedURLException, InterruptedException {
        commonInitialDriver= new InitialImpl("HUAWEI P40 lite","EPHUT20429006493","com.huawei.hwid","com.huawei.hwid20.AccountCenter.CenterActivity");
        commonDriver = commonInitialDriver.getDriver();
    }

    public static void basicKeyProcesses( AndroidDriver<MobileElement> commonDriver, String process){
        process.equalsIgnoreCase("back");
        if(process.equalsIgnoreCase("back")){
            commonDriver.navigate().back();
        }

        else if(process.equalsIgnoreCase("home")){
            ((AndroidDriver) commonDriver).pressKey(new KeyEvent(AndroidKey.HOME));
        }

        else if(process.equalsIgnoreCase("appswitch")){
            ((AndroidDriver) commonDriver).pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
        }

    }
}
