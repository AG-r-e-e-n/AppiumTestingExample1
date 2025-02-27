package pages;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

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
        if (mainPage.getTitleLabel().equals(element)) {
            System.out.println("Test Passed");
            return true;
        } else {
            //Test failed
            System.out.println("Test Failed");
            return false;
        }
    }

    public boolean isAblockUser(){
        AndroidElement error = driver.findElementById("com.saucelabs.mydemoapp.android:id/passwordErrorTV");
        if (error.getText().equals("Sorry this user has been locked out.")) {
            System.out.println("Test Passed");
            return true;
        } else {
            //Test failed
            System.out.println("Test Failed");
            return false;
        }
    }
}
