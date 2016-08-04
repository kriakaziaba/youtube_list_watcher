package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by DiR on 04.08.2016.
 */
public class Search extends BasePage{
    Search(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h3.yt-lockup-title>a")
    private List<WebElement> listLinks;

    public void clickSeeerchResult(int index){
        listLinks.get(index).click();
        waitFotAjax();
    }
}
