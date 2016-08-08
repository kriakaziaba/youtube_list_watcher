package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by DiR on 04.08.2016.
 */
public class ChannelVideo extends Channel{
    public ChannelVideo(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "ul#channels-browse-content-grid h3.yt-lockup-title>a")
    private List<WebElement> list_linkNameOfVideo;

    public Video openVideo(int index){
        list_linkNameOfVideo.get(0).click();
        waitFotAjax();
        return PageFactory.initElements(driver, Video.class);
    }
}
