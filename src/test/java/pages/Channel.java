package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by tku on 8/8/2016.
 */
public class Channel extends BasePage {
    public Channel(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "ul#channel-navigation-menu>li:nth-child(2)")
    public WebElement btnVideo;
}
