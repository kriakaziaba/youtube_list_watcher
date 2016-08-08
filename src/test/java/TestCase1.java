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
    public void newestVideo(@Optional("ptd19871")String channelName){
        driver.get("https://www.youtube.com/");
        Main main = PageFactory.initElements(driver, Main.class);
        Search search = main.header.searchAndClearBefore(channelName);
        ChannelHome channelHome = search.clickSearchResultChannel(0);
        ChannelVideo channelVideo = channelHome.gotoChanelVideo();
        Video video = channelVideo.openVideo(0);
        sleep(3);
        video.turnOfAutoPlay();
        sleep(video.getDuration());
    }

    @Parameters({"urlOfPlaylist"})
    @Test
    public void playlist(@Optional("https://www.youtube.com/playlist?v=PX7gHkSX8kM&list=UUBCuCIXJBvNZnUSwSZ9ounA") String url){
        driver.get(url);
        PlaylistChannel playlistChannel = PageFactory.initElements(driver, PlaylistChannel.class);
        Video video = playlistChannel.playPlaylist();
        while (!video.isPlaylistEnding()){
            sleep(60);
        }
        sleep(video.getDuration());
    }

    @Parameters({"urlOfVideo"})
    @Test
    public void specificVideo(@Optional("https://www.youtube.com/watch?v=sI8rfYL7px8") String url){
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
        ChannelHome channelHome = search.clickSearchResultChannel(0);
        Video video = channelHome.clickPlayAllVideos();
        while (!video.isPlaylistEnding()){
            sleep(60);
        }
        sleep(video.getDuration());
    }

}
