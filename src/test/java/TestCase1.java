import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

/**
 * Created by DiR on 04.08.2016.
 */
public class TestCase1 extends TestBase {


    @Test
    public void newestVideo(){
        driver.get("https://www.youtube.com/");
        driver.findElement(By.id("masthead-searchAndClearBefore-term")).sendKeys("sladkoTV");
        driver.findElement(By.id("masthead-searchAndClearBefore-term")).submit();
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
    @Test
    public void playlist(@Optional("https://www.youtube.com/playlist?list=PLFSNn_ZDtbMLWTFwPyDB4e6j7mLEhYi5c") String url){
        driver.get(url);
        PlaylistChannel playlistChannel = PageFactory.initElements(driver, PlaylistChannel.class);
        Video video = playlistChannel.playPlaylist();
        sleep(20);
        //todo how to end watching
    }

    @Parameters({"urlOfVideo"})
    @Test
    public void specificVideo(@Optional("https://www.youtube.com/watch?v=k3Pc9U2FJa0") String url){
        driver.get(url);
        Video video = PageFactory.initElements(driver, Video.class);
        video.waitFotAjax();
        sleep(3);
        video.turnOfAutoPlay();
        sleep(video.getDuration());
    }

    @Parameters({"urlOfVideo"})
    @Test
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
    @Test
    public void allChannel(@Optional("SirDiR")String channelName){
        driver.get("https://www.youtube.com/");
        Main main = PageFactory.initElements(driver, Main.class);
        Search search = main.header.searchAndClearBefore(channelName);
        ChanelHome chanelHome = search.clickSearchResultChannel(0);
        chanelHome.clickPlayAllVideos();
        //todo how to end watching
    }

}
