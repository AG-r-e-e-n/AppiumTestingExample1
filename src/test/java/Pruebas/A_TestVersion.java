package Pruebas;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.About;
import pages.Home;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class A_TestVersion {
    private AndroidDriver<AndroidElement> driver;

    @Before
    public void setUp() throws MalformedURLException {
        Logger.getLogger("org.openqa.selenium.remote").setLevel(Level.WARNING);
    	DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
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
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        mainPage.clickAboutButton();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        About ab = new About(driver);
        if (ab.getTitle().equals("About")) {
            if (ab.getVersion().equals("V.2.2.0-build 25")) {
                assertTrue("Test Passed", true);
            } else {
                //Test failed
                fail("Test Failed");
            }
        } else {
            //Test failed
            fail("Test Failed");
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
