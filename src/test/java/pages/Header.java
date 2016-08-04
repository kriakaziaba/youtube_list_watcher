package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by DiR on 04.08.2016.
 */
public class Header extends BasePage{
    public Header(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "masthead-search-term")
    private WebElement txbSearch;

    public void serch(String text){
        txbSearch.sendKeys(text);
        txbSearch.submit();
    }
}
