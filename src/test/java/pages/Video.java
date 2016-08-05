package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;

/**
 * Created by DiR on 04.08.2016.
 */
public class Video extends BasePage {
    public Video(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "span.ytp-time-duration")
    private WebElement textDuration;

    @FindBy(id = "autoplay-checkbox")
    private WebElement chbAutoPlay;

    @FindBy(css = "input#autoplay-checkbox+label")
    private WebElement chbAutoPlayLabel;

    @FindBy(css = "div.yt-user-info>a")
    private WebElement textVideoNameOfChanel;

    @FindBy(css = "span[data-name='autonav']")
    private WebElement textAutoPlayNameOfChanel;

    @FindBy(css = "span[data-name='autonav']")
    private WebElement textAutoPlayNameOfVideo;

    @FindBy(css = "span.stat.attribution")
    private List<WebElement> list_textSuggestedNameOfChanel;

    public void turnOfAutoPlay(){
        if (chbAutoPlay.isSelected())
            chbAutoPlay.click();
    }

    public Integer getDuration(){
        String time = textDuration.getText();
        String[] splitted = time.split(":");
        System.out.println("lol " + time);
        switch (splitted.length){
            case 3:
                time = "PT" + splitted[0] + "H" + splitted[1] + "M" + splitted[2] + "S";
                break;
            case 2:
            default:
                time = "PT" + splitted[0] + "M" + splitted[1] + "S";
                break;
        }
        Duration duration = Duration.parse(time);
        return (int) (duration.getSeconds() + 1);
    }

    public boolean goToAutoPlayVideoIfSameChannel(){
        boolean isSameChannel = textVideoNameOfChanel.getText().equals(textAutoPlayNameOfChanel.getText());
        if (isSameChannel){
            textAutoPlayNameOfVideo.click();
            waitFotAjax();
        }
        return isSameChannel;
    }
}
