package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by DiR on 04.08.2016.
 */
public class ChannelHome extends Channel{
    public ChannelHome(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Uploads' or text()='Все видео']")
    WebElement btnAllVideos;

    @FindBy(xpath = "//h2[.//span[text()='Uploads' or text()='Все видео']]//span[@class='yt-uix-button-content']")
    WebElement btnPlayAllVideos;

    public Video clickPlayAllVideos(){
        Actions action = new Actions(driver);
        action.moveToElement(btnAllVideos);
        action.perform();
        ExpectedConditions.elementToBeClickable(btnPlayAllVideos);
        btnPlayAllVideos.click();
        waitFotAjax();
        return PageFactory.initElements(driver, Video.class);
    }

    public ChannelVideo gotoChanelVideo() {
        btnVideo.click();
        waitFotAjax();
        return PageFactory.initElements(driver, ChannelVideo.class);
    }
}
