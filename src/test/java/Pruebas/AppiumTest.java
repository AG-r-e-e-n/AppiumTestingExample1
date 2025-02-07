package Pruebas;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class AppiumTest {
    public static void main(String[] args) {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator"); // Change this to your device name
        caps.setCapability(MobileCapabilityType.APP, "/path/to/your/app.apk"); // Change this to the path of your app

        try {
            // Initialize the driver
            AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);

            // Write your test here
            // Example: Find an element and click it
            MobileElement element = driver.findElementById("com.example:id/button");
            element.click();

            // Quit the driver
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
