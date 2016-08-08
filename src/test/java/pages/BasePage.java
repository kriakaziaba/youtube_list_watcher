package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by DiR on 04.08.2016.
 */
public class BasePage {

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        header = PageFactory.initElements(driver, Header.class);
    }

    protected WebDriver driver;
    protected WebDriverWait wait;
    public Header header;

//    public void waitFotAjax(){
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        int i = 0;
//        while (5>i++) {
//            boolean active;
//            try {
//                active = (boolean) js.executeScript("return jQuery.active == 0");
//            } catch (WebDriverException e) {
//                if (e.getMessage().contains("jQuery is not defined")) {
//                    active = (boolean) js.executeScript("return Backbone.$.active == 0");
//                } else {
//                    throw e;
//                }
//            }
//            if (active) {
//                return;
//            } else {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

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
