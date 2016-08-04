import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by DiR on 04.08.2016.
 */
public class TestCase1 extends TestBase {


    @Test
    public void newestVideo(){
        driver.get("https://www.youtube.com/");
        driver.findElement(By.id("masthead-search-term")).sendKeys("sladkoTV");
        driver.findElement(By.id("masthead-search-term")).submit();
        sleep(2);
        driver.findElement(By.cssSelector("h3.yt-lockup-title>a")).click();
        sleep(2);
        driver.findElement(By.cssSelector("ul#channel-navigation-menu>li:nth-child(2)")).click();
        sleep(2);
        driver.findElement(By.cssSelector("h3>a")).click();
        sleep(2);

        String text = driver.findElement(By.cssSelector("span.ytp-time-duration")).getText();
        System.out.println(text);
        sleep(2);
    }

    @Parameters({"url_of_playlist"})
    @Test
    public void playlist(String url){
        driver.get(url);
    }

    @Parameters({"chanel"})
    @Test
    public void allChanel(String chanelName){
        driver.get("https://www.youtube.com/");
        driver.findElement(By.id("masthead-search-term")).sendKeys(chanelName);
        driver.findElement(By.id("masthead-search-term")).submit();
        sleep(2);
        driver.findElement(By.cssSelector("h3.yt-lockup-title>a")).click();
        sleep(2);
        driver.findElement(By.cssSelector("ul#channel-navigation-menu>li:nth-child(2)")).click();
        sleep(2);
        driver.findElement(By.cssSelector("h3>a")).click();
        sleep(2);

        String text = driver.findElement(By.cssSelector("span.ytp-time-duration")).getText();
        System.out.println(text);
        sleep(2);
    }

}
