package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

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

    public void turnOfAutoPlay(){
        if (!chbAutoPlay.isSelected())
            chbAutoPlay.click();
    }

    public Integer getDuration(){
        String time = textDuration.getText();
        String[] splitted = time.split(":");
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
        return (int) (duration.getSeconds() + 60);
    }
}
