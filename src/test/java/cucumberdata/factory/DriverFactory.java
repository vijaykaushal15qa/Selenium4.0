package cucumberdata.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    // static is used as this driver object will be used in different classes.
    // If we don't static driver variable and methods here then ,every time we need to create
    // instance of this class to use the driver object and that driver object will have NULL value
    // And also driver wil be then get bind to the instance instead of the class.

    private static WebDriver driver;

    public static WebDriver initializeDriver()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriver()
    {
        return driver;
    }
}
