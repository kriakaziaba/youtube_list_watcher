import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by tku on 8/3/2016.
 */
public class TestBase {
    private WebDriver driver;
    @BeforeClass
    public void browserSetup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    void sleep(int i){
        try {
            Thread.sleep(i*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1(){
        driver.get("https://www.youtube.com/");
        driver.findElement(By.id("masthead-search-term")).sendKeys("sladkoTV");
        driver.findElement(By.id("masthead-search-term")).submit();
        sleep(2);
        driver.findElement(By.cssSelector("h3>a")).click();
        sleep(2);
        driver.findElement(By.cssSelector("ul#channel-navigation-menu>li:nth-child(2)")).click();
        sleep(2);
        driver.findElement(By.cssSelector("h3>a")).click();
        sleep(2);

        String text = driver.findElement(By.cssSelector("span.ytp-time-duration")).getText();
        System.out.println(text);
        sleep(2);
    }

    @AfterClass
    public void terminateDriver(){
        driver.quit();
    }

}
