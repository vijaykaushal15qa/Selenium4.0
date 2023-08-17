package cucumberdata.hooks;

import cucumberdata.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class MyHooks {
    private WebDriver driver;

    @Before
    public void Before()
    {
        driver= DriverFactory.initializeDriver();
    }

    @After
    public void After()
    {
        driver.quit();
    }
}
