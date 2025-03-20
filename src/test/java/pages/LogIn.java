package pages;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LogIn {
    private final AndroidDriver<AndroidElement> driver;

    public LogIn(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    public void setUsername(String username) {
        AndroidElement usernameField = driver.findElementById("com.saucelabs.mydemoapp.android:id/nameET");
        usernameField.sendKeys(username);
    }

    public void setPassword(String password) {
        AndroidElement passwordField = driver.findElementById("com.saucelabs.mydemoapp.android:id/passwordET");
        passwordField.sendKeys(password);
    }

    public void clickLogInButton() {
        AndroidElement logInButton = driver.findElementById("com.saucelabs.mydemoapp.android:id/loginBtn");
        logInButton.click();
    }

    public boolean isLoggedIn(String element) {
        Home mainPage = new Home(driver);
        System.out.println(mainPage.getTitleLabel());
        if (mainPage.getTitleLabel().equals(element)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAblockUser(){
        AndroidElement error = driver.findElementById("com.saucelabs.mydemoapp.android:id/passwordErrorTV");
        if (error.getText().equals("Sorry this user has been locked out.")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean areEmptyBoxes() {
        try{
            AndroidElement emptyUser = driver.findElementById("com.saucelabs.mydemoapp.android:id/nameErrorTV");
            //AndroidElement emptyPass = driver.findElementById("com.saucelabs.mydemoapp.android:id/passwordErrorTV");
            if (emptyUser.getText().equals("Username is required")){ //|| emptyPass.getText().equals("Enter Password")){
                return true;
            } else{
                return false;
            }
        }
        catch (NoSuchElementException e) {
            throw new RuntimeException(e);

        }
    }
}
