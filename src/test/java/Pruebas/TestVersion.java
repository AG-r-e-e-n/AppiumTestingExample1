package Pruebas;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.About;
import pages.Home;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

public class TestVersion {
    private AndroidDriver<AndroidElement> driver;

    @Before
    public void setUp() throws MalformedURLException {
    	DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "R9JR40PS32J");
        String appPath = Paths.get("src", "test", "resources", "My demo app", "mda-2.2.0-25.apk").toAbsolutePath().toString();
        caps.setCapability(MobileCapabilityType.APP, appPath); // Change this to the path of your app
        //caps.setCapability(MobileCapabilityType.APP, "C:/Users/Abraham Green/Documents/AppiumEjemplo1/General-Store-AppiumTesting/src/General-Store.apk"); // Change this to the path of your app
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability("appWaitActivity", "com.saucelabs.mydemoapp.android.view.activities.MainActivity");
        caps.setCapability("appWaitDuration", 30000); // Aumenta el tiempo de espera a 30 segundos
        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/"), caps);
    }

    @Test
    public void test_TC01() {
        Home mainPage = new Home(driver);
        mainPage.clickMenuButton();
        mainPage.clickAboutButton();
        About ab = new About(driver);
        if (ab.getTitle().equals("About")) {
            if (ab.getVersion().equals("V.2.2.0-build 25")) {
                System.out.println("Test Passed");
            } else {
                //Test failed
                System.out.println("Test Failed");
            }
        } else {
            //Test failed
            System.out.println("Test Failed");
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
