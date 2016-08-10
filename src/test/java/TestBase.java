import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by tku on 8/3/2016.
 */
public class TestBase {

    static protected WebDriver driver;

    @Parameters({"browser"})
    @BeforeSuite
    public void browserSetup(@Optional("ff")String name){
        switch (name){
            case "ch":
            default:
                ChromeOptions options = new ChromeOptions();
                options.setBinary("/usr/bin/chromium-browser");
                driver = new ChromeDriver(options);
                break;
            case "ff":
                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability("marionette", true);
                driver = new FirefoxDriver(capabilities);
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    void sleep(int i){
        try {
            Thread.sleep(i*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterSuite(alwaysRun = true)
    public void terminateDriver(){
        driver.quit();
    }

}
