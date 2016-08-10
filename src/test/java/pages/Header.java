package pages;

import org.openqa.selenium.JavascriptExecutor;
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
        waitFotAjax();
        return PageFactory.initElements(driver, Search.class);
    }

    public void waitFotAjax(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        if (null == js.executeScript("return window.ajaxRequestCounter")) {
            js.executeScript("window.ajaxRequestCounter = 0; (function(send) {XMLHttpRequest.prototype.send = function(data) {window.ajaxRequestCounter++;(function(func, self) {self.onreadystatechange = function() {if (this.readyState == 4) {window.ajaxRequestCounter--;}func.call(this);}})(this.onreadystatechange, this); send.call(this, data);};})(XMLHttpRequest.prototype.send);");
        }

        int i = 0;
        while (5 > i++) // Handle timeout somewhere
        {
            if ("0".equals((js.executeScript("return window.ajaxRequestCounter")).toString())) {
                break;
            }
            else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
