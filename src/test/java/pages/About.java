package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class About {

    private AndroidDriver<AndroidElement> driver;
    private AndroidElement versionLabel;
    private AndroidElement titleLabel;

    public About(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    public String getVersion() {
        versionLabel = driver.findElementById("com.saucelabs.mydemoapp.android:id/versionTV");
        return versionLabel.getText();
    }

    public String getTitle() {
        titleLabel = driver.findElementById("com.saucelabs.mydemoapp.android:id/aboutTV");
        return titleLabel.getText();
    }
}
