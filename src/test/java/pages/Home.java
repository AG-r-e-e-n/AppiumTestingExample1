package pages;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
/*import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;*/

public class Home{
    private final AndroidDriver<AndroidElement> driver;

    /* @AndroidFindBy(id = "com.example:id/username")
    private AndroidElement usernameField;*/

    public Home(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        //PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String getTitleLabel() {
        AndroidElement titleLabel = driver.findElementById("com.saucelabs.mydemoapp.android:id/productTV");
        return titleLabel.getText();
    }

    public void clickMenuButton() {
        AndroidElement menuButton = driver.findElementByAccessibilityId("View menu");
        menuButton.click();
    }

    public void clickAboutButton() {
        AndroidElement aboutButton = driver.findElementByXPath("//android.widget.TextView[@text='About']");
        aboutButton.click();
    }

    public void clickLogInButton() {
        AndroidElement logInButton = driver.findElementByAccessibilityId("Login Menu Item");
        logInButton.click();
    }
}