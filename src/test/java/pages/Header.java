package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by DiR on 04.08.2016.
 */
public class Header{
    public Header(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(id = "masthead-search-term")
    private WebElement txbSearch;

    public Search searchAndClearBefore(String text){
        txbSearch.sendKeys(text);
        txbSearch.clear();
        txbSearch.sendKeys(text);
        txbSearch.submit();
        return PageFactory.initElements(driver, Search.class);
    }
}
