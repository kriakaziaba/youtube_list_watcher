package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by DiR on 04.08.2016.
 */
public class Search extends BasePage{
    public Search(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h3.yt-lockup-title>a")
    private List<WebElement> listLinks;

    public ChanelHome clickSearchResultChannel(int index){
        waitFotAjax();
        listLinks.get(index).click();
        waitFotAjax();
        return PageFactory.initElements(driver, ChanelHome.class);
    }

    public Video clickSearchResultVideo(int index){
        waitFotAjax();
        listLinks.get(index).click();
        waitFotAjax();
        return PageFactory.initElements(driver, Video.class);
    }
}
