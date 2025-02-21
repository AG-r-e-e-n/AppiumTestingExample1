package PruebasQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

public class Basics {
    protected WebDriver driver;
    protected DesiredCapabilities caps;

    public Basics() {
        // Inicializar las capabilities
        /*capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Windows");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("version", "latest");*/

        /*// Inicializar las capabilities para Appium
        caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "R9JR40PS32J"); // Change this to your device name

        // Usar ruta relativa para la aplicación
        String appPath = Paths.get("src", "test", "resources", "My demo app", "mda-2.2.0-25.apk").toAbsolutePath().toString();
        caps.setCapability(MobileCapabilityType.APP, appPath); // Change this to the path of your app
        caps.setCapability(MobileCapabilityType.APP, "C:/Users/Abraham Green/Documents/AppiumEjemplo1/General-Store-AppiumTesting/src/General-Store.apk"); // Change this to the path of your app
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");*/

    }

    public void setUp(String hubUrl) throws MalformedURLException {
        // Configurar el WebDriver con las capabilities
    	AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/"), caps);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}