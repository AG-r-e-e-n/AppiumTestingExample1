package pages;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
/*import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;*/

public class Home{
    private AndroidDriver<AndroidElement> driver;

    private AndroidElement menubutton;
    
    @AndroidFindBy(id = "com.example:id/username")
    private AndroidElement usernameField;

    public Home(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        //PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickButton() {
    	menubutton = driver.findElementByAccessibilityId("View menu");
        menubutton.click();
    }
}