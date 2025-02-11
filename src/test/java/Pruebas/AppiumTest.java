package Pruebas;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.OutputType;
import java.net.URL;

public class AppiumTest {
    public static void main(String[] args) {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "R9JR40PS32J"); // Change this to your device name
        caps.setCapability(MobileCapabilityType.APP, "C:/Users/Abraham Green/Documents/AppiumEjemplo1/General-Store-AppiumTesting/src/General-Store.apk"); // Change this to the path of your app
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        try {
            // Initialize the driver
            AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/"), caps);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

            driver.findElementByClassName("android.widget.Spinner").click();
    		
    	    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Panama\"));").click();
    		
    		driver.findElementByAndroidUIAutomator("text(\"Enter name here\")").sendKeys("AG");
    		
    		driver.hideKeyboard();
    		
    		driver.findElementByAndroidUIAutomator("text(\"Male\")").click();
    		

    		driver.findElementByAndroidUIAutomator("text(\"Let's  Shop\")").click();
    		
            
            // Example: Find an element and click it
            /*AndroidElement element = driver.findElementById("com.example:id/button");
            element.click();*/

            // Quit the driver
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
