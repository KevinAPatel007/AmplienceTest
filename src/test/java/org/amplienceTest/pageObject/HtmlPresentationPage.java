package org.amplienceTest.pageObject;

import org.amplienceTest.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HtmlPresentationPage extends DriverManager {

    @FindBy(css = ".word-wrap")
    WebElement getApiText;

    public String getTextFromApiPageResult() {
        return driver.getPageSource();
    }

}
