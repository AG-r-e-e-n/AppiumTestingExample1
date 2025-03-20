package Pruebas;

import Enviroment.EnvLoader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.Home;
import pages.LogIn;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class B_LogInTests {
    private AndroidDriver<AndroidElement> driver;
    private EnvLoader envLoader;

    @Before
    public void setUp() throws MalformedURLException, IOException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        String appPath = Paths.get("src", "test", "resources", "My demo app", "mda-2.2.0-25.apk").toAbsolutePath().toString();
        caps.setCapability(MobileCapabilityType.APP, appPath);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability("appWaitActivity", "com.saucelabs.mydemoapp.android.view.activities.MainActivity");
        caps.setCapability("appWaitDuration", 30000);
        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/"), caps);

        String envPath = Paths.get(".env").toAbsolutePath().toString();
        envLoader = new EnvLoader(envPath);
    }

    @Test
    public void test_TC02() {
        Home mainPage = new Home(driver);
        mainPage.clickMenuButton();
        mainPage.clickLogInButton();
        LogIn lgin = new LogIn(driver);
        lgin.setUsername(envLoader.getProperty("User"));
        lgin.setPassword(envLoader.getProperty("Pass"));
        lgin.clickLogInButton();

        String logInValidate = "Products";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        assertTrue("El login no fue exitoso", lgin.isLoggedIn(logInValidate));
    }

    @Test
    public void test_TC03() {
        Home mainPage = new Home(driver);
        mainPage.clickMenuButton();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        mainPage.clickLogInButton();
        LogIn lgin = new LogIn(driver);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        lgin.setUsername(envLoader.getProperty("UserLock"));
        lgin.setPassword(envLoader.getProperty("Pass"));
        lgin.clickLogInButton();

        assertTrue("Flujo alternativo correcto", lgin.isAblockUser());
    }

    @Test
    public void test_TC04(){
        Home mainPage = new Home(driver);
        mainPage.clickMenuButton();
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        mainPage.clickLogInButton();
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        LogIn lgIn = new LogIn(driver);
        lgIn.clickLogInButton();
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        assertTrue("Flujo alternativo correcto", lgIn.areEmptyBoxes("first"));
        lgIn.setUsername(envLoader.getProperty("User"));
        lgIn.clickLogInButton();
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        assertTrue("Flujo alternativo correcto", lgIn.areEmptyBoxes("second"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}