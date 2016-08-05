import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.Video;

/**
 * Created by DiR on 04.08.2016.
 */
public class TestCase1 extends TestBase {


    @Test(enabled = false)
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

    @Parameters({"urlOfPlaylist"})
    @Test(enabled = false)
    public void playlist(String url){
        driver.get(url);
    }

    @Parameters({"urlOfVideo"})
    @Test(enabled = true)
    public void specificVideo(@Optional("https://www.youtube.com/watch?v=k3Pc9U2FJa0") String url){
        driver.get(url);
        Video video = PageFactory.initElements(driver, Video.class);
        video.waitFotAjax();
        sleep(3);
        video.turnOfAutoPlay();
        sleep(video.getDuration());
    }

    @Parameters({"urlOfVideo"})
    @Test(enabled = true)
    public void specificVideoAndAllSuggested(@Optional("https://www.youtube.com/watch?v=k3Pc9U2FJa0") String url){
        driver.get(url);
        Video video = PageFactory.initElements(driver, Video.class);
        video.waitFotAjax();
        sleep(3);
        video.turnOfAutoPlay();
        sleep(video.getDuration());
        while (video.goToAutoPlayVideoIfSameChannel()){
            video.turnOfAutoPlay();
            sleep(video.getDuration());
        }
    }

    @Parameters({"channel"})
    @Test(enabled = false)
    public void allChannel(String chanelName){
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
