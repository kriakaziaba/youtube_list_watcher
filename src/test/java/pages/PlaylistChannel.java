package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by tku on 8/8/2016.
 */
public class PlaylistChannel extends BasePage{

    @FindBy(css = "div.playlist-actions>a")
    WebElement btnPlayAll;

    public PlaylistChannel(WebDriver driver) {
        super(driver);
    }

    public Video playPlaylist(){
        btnPlayAll.click();
        waitFotAjax();
        return PageFactory.initElements(driver, Video.class);
    }
}
